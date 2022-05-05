package com.ueb.cost_calculation.cost_calculator.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ueb.cost_calculation.cost_calculator.repository.CostCalculatorRepository
import com.ueb.cost_calculation.cost_calculator.ui.fragment.CostCalculatorViewModel

class CostCalculatorViewModelFactory (
    private val costCalculatorRepository: CostCalculatorRepository
        ): ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CostCalculatorViewModel(costCalculatorRepository) as T
    }
}