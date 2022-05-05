package com.ueb.cost_calculation.cost_calculator.util

import com.ueb.cost_calculation.cost_calculator.model.entity.ItemEntityModel
import com.ueb.cost_calculation.cost_calculator.model.entity.ItemPartEntryEntityModel
import com.ueb.cost_calculation.cost_calculator.model.response.ItemPartEntryModel
import com.ueb.cost_calculation.cost_calculator.model.response.ItemResponseModel

class ItemMapper {
    companion object{
        fun convertResponseItemPartToEntityItemPart(list: List<ItemPartEntryModel>): List<ItemPartEntryEntityModel>{
            val newList: MutableList<ItemPartEntryEntityModel> = mutableListOf()
            for (item in list){
                newList.add(ItemPartEntryEntityModel(item.name,item.count, item.price))
            }
            return newList
        }

        fun convertResponseModelToEntityModel(item:ItemResponseModel): ItemEntityModel{
            return ItemEntityModel(-1, item.name, item.count,
                convertResponseItemPartToEntityItemPart(item.items))
        }
    }
}