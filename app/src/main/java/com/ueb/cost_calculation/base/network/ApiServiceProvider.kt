package com.ueb.cost_calculation.base.network

import com.ueb.cost_calculation.cost_calculator.network.service.ICostCalculatorService


class ApiServiceProvider {

    companion object {

        @Volatile private var costCalculatorApiInstance: ICostCalculatorService? = null

        fun getCostCalculatorApiInstance() : ICostCalculatorService =
            costCalculatorApiInstance ?: synchronized(this) {
                costCalculatorApiInstance ?: RetrofitUtil.getRetrofitInstance().create(
                    ICostCalculatorService::class.java)
                    .also { costCalculatorApiInstance = it }
            }
    }
}