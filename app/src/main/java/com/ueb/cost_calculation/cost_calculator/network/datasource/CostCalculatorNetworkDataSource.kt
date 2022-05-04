package com.ueb.cost_calculation.cost_calculator.network.datasource

import androidx.lifecycle.LiveData
import com.ueb.cost_calculation.cost_calculator.model.response.ItemResponseModel

interface CostCalculatorNetworkDataSource {
    val fetchedItems: LiveData<ItemResponseModel>

    suspend fun getItems()
}