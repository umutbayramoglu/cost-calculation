package com.ueb.cost_calculation.cost_calculator.repository

import androidx.lifecycle.LiveData
import com.ueb.cost_calculation.cost_calculator.model.dao.ItemDao
import com.ueb.cost_calculation.cost_calculator.model.entity.ItemEntityModel
import com.ueb.cost_calculation.cost_calculator.network.datasource.CostCalculatorNetworkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.threeten.bp.ZonedDateTime


class CostCalculatorRepositoryImpl (
    private var itemDao: ItemDao,
    private var dataSource: CostCalculatorNetworkDataSource): CostCalculatorRepository {

    init {
        dataSource.fetchedItems.observeForever { newItem ->
            persistFetchedItem(newItem)
        }
    }

    override suspend fun getItem(): LiveData<ItemEntityModel> {
        return withContext(Dispatchers.IO){
            initItemData()
            return@withContext itemDao.getItem()
        }
    }

    private fun persistFetchedItem(itemEntity: ItemEntityModel){
        GlobalScope.launch (Dispatchers.IO){
            itemDao.upsert(itemEntity)
        }
    }


    private suspend fun initItemData(){
        if(isFetchNeeded(ZonedDateTime.now().minusHours(1))){
            dataSource.getItem()
        }
    }

    private fun isFetchNeeded(lastFetchTime: ZonedDateTime):Boolean {
        val tenMinutesAgo = ZonedDateTime.now().minusMinutes(10)
        return lastFetchTime.isBefore(tenMinutesAgo)
    }

}