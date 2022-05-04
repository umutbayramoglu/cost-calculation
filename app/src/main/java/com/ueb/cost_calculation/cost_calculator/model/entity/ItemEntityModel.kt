package com.ueb.cost_calculation.cost_calculator.model.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ueb.cost_calculation.base.model.entity.BaseEntityModel

@Entity(tableName = "item")
data class ItemEntityModel(

    @PrimaryKey(autoGenerate = true)
    var id: Long,

    val name: String,
    val count: Int,

    @Embedded(prefix = "items_")
    val items: List<ItemPartEntryEntityModel>
) : BaseEntityModel()