package com.ueb.cost_calculation.cost_calculator.network.service

import com.ueb.cost_calculation.cost_calculator.model.entity.ItemEntityModel
import retrofit2.Response
import retrofit2.http.GET

interface ICostCalculatorService {

    @GET("sample_3.json")
    suspend fun getItemsAsync() : Response<ItemEntityModel>
}