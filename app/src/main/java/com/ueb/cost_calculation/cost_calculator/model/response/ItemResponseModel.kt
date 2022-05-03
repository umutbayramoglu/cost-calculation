package com.ueb.cost_calculation.cost_calculator.model.response

import com.ueb.cost_calculation.base.model.response.BaseResponseModel


data class ItemResponseModel(
    val name: String,
    val count: Int,
    val items: List<ItemPartEntryModel>
) : BaseResponseModel()