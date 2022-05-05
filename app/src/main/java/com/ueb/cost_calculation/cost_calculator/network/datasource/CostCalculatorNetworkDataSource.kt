package com.ueb.cost_calculation.cost_calculator.network.datasource

import androidx.lifecycle.LiveData
import com.ueb.cost_calculation.cost_calculator.model.entity.ItemEntityModel

interface CostCalculatorNetworkDataSource {
    val fetchedItems: LiveData<ItemEntityModel>

    suspend fun getItem()
}