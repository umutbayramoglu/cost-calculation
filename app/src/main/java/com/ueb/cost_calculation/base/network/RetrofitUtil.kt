package com.ueb.cost_calculation.base.network

import com.ueb.cost_calculation.base.constant.NetworkConstants.Retrofit.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitUtil {

    companion object {

        @Volatile private var retrofitInstance: Retrofit? = null

        fun getRetrofitInstance(): Retrofit =
            retrofitInstance ?: synchronized(this) {

                retrofitInstance ?: Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .also { retrofitInstance = it }
            }
    }
}