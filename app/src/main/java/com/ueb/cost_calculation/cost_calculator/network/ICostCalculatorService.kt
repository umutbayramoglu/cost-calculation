package com.ueb.cost_calculation.cost_calculator.network

import com.ueb.cost_calculation.cost_calculator.model.response.ItemResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface ICostCalculatorService {

    @GET("sample_1.json")
    suspend fun getItemsAsync() : Response<ItemResponseModel>
}