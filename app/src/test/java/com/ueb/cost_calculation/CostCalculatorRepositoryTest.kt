package com.ueb.cost_calculation

import androidx.lifecycle.MutableLiveData
import com.ueb.cost_calculation.cost_calculator.model.dao.ItemDao
import com.ueb.cost_calculation.cost_calculator.model.entity.ItemEntityModel
import com.ueb.cost_calculation.cost_calculator.network.datasource.CostCalculatorNetworkDataSource
import com.ueb.cost_calculation.cost_calculator.repository.CostCalculatorRepository
import com.ueb.cost_calculation.cost_calculator.repository.CostCalculatorRepositoryImpl
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CostCalculatorRepositoryTest {
    @MockK
    private lateinit var itemDao: ItemDao

    @MockK
    private lateinit var dataSource: CostCalculatorNetworkDataSource

    private lateinit var costCalculatorRepository: CostCalculatorRepository
    private lateinit var item: MutableLiveData<ItemEntityModel>

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        costCalculatorRepository = CostCalculatorRepositoryImpl(itemDao, dataSource)
        item = MutableLiveData<ItemEntityModel>().apply {
            postValue(ItemEntityModel(-1, "x", 1, null, 5))
        }
    }

    @Test
    fun `invoke the service to fetch the item for cost calculation`(){

        every { itemDao.getItem() }.returns(item)
        every { dataSource.fetchedItems }.returns(item)

        // call repository method
        val fetchedItem = runBlocking { costCalculatorRepository.getItem() }

        Assert.assertEquals(item, fetchedItem)
        verify(atMost = 1) { itemDao.getItem() }
        verify(atMost = 1) { runBlocking { dataSource.getItem() } }
    }
}