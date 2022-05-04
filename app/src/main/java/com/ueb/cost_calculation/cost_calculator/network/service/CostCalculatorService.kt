package com.ueb.cost_calculation.cost_calculator.network.service

import com.ueb.cost_calculation.base.network.ApiServiceProvider
import com.ueb.cost_calculation.cost_calculator.model.response.ItemResponseModel
import retrofit2.Response


class CostCalculatorService {

    companion object {
        suspend fun getItems(): Response<ItemResponseModel> {
            return ApiServiceProvider.getCostCalculatorApiInstance().getItemsAsync()
        }
    }
}