package com.ueb.cost_calculation.cost_calculator.ui.fragment

import androidx.lifecycle.ViewModel
import com.ueb.cost_calculation.cost_calculator.repository.CostCalculatorRepository
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class CostCalculatorViewModel (
    private val costCalculatorRepository: CostCalculatorRepository
    ): ViewModel() {

    val item = GlobalScope.async(start = CoroutineStart.LAZY){
        costCalculatorRepository.getItem()
    }
}