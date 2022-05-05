package com.ueb.cost_calculation.cost_calculator.network.datasource

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ueb.cost_calculation.cost_calculator.model.entity.ItemEntityModel
import com.ueb.cost_calculation.cost_calculator.network.service.CostCalculatorService
import java.lang.Exception

class CostCalculatorNetworkDataSourceImpl : CostCalculatorNetworkDataSource {

    private val mutableFetchedItems = MutableLiveData<ItemEntityModel>()

    override val fetchedItems: LiveData<ItemEntityModel>
        get() = mutableFetchedItems

    override suspend fun getItem() {
        try {
            val items = CostCalculatorService.getItems().body()
            mutableFetchedItems.postValue(items!!)
        }
        catch (e:Exception){
            Log.e("ItemNetworkDataSource", e.stackTrace.toString())
        }

    }
}