package com.ueb.cost_calculation.cost_calculator.model.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ueb.cost_calculation.base.model.entity.BaseEntityModel
import java.lang.reflect.Type

@Entity(tableName = "item")
data class ItemEntityModel(

    @PrimaryKey(autoGenerate = true)
    var id: Long,

    val name: String,
    val count: Int,
    val items: List<ItemPartEntryEntityModel>,
) : BaseEntityModel() {
}

class ItemPartTypeConverter{
    @TypeConverter
    fun toItemPartEntry(value: String?): List<ItemPartEntryEntityModel>{
        val listType = object :TypeToken<List<ItemPartEntryEntityModel>>(){}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromItemPartList(list: List<ItemPartEntryEntityModel>?): String{
        val listType: Type = object : TypeToken<List<ItemPartEntryEntityModel?>?>() {}.type
        return Gson().toJson(list, listType)
    }
}