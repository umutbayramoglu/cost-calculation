package com.ueb.cost_calculation.cost_calculator.network.datasource

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ueb.cost_calculation.cost_calculator.model.response.ItemResponseModel
import com.ueb.cost_calculation.cost_calculator.network.service.CostCalculatorService
import java.lang.Exception

class CostCalculatorNetworkDataSourceImpl : CostCalculatorNetworkDataSource {

    private val mutableFetchedItems = MutableLiveData<ItemResponseModel>()

    override val fetchedItems: LiveData<ItemResponseModel>
        get() = mutableFetchedItems

    override suspend fun getItems() {
        try {
            val items = CostCalculatorService.getItems().body()
            mutableFetchedItems.postValue(items!!)
        }
        catch (e:Exception){
            Log.e("ItemNetworkDataSource", e.stackTrace.toString())
        }

    }
}