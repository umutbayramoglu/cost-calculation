package com.ueb.cost_calculation.cost_calculator.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ueb.cost_calculation.cost_calculator.model.entity.ItemEntityModel

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(itemEntity:ItemEntityModel)

    @Query("select * from item")
    fun getItem(): LiveData<ItemEntityModel>
}
