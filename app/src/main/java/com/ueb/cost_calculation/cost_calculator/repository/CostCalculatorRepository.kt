package com.ueb.cost_calculation.cost_calculator.repository

import androidx.lifecycle.LiveData
import com.ueb.cost_calculation.cost_calculator.model.entity.ItemEntityModel


interface CostCalculatorRepository {

    suspend fun getItems(): LiveData<List<ItemEntityModel>>
}