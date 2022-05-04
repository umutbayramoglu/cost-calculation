package com.ueb.cost_calculation.base.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ueb.cost_calculation.base.constant.NetworkConstants
import com.ueb.cost_calculation.base.network.RetrofitUtil
import com.ueb.cost_calculation.cost_calculator.model.dao.ItemDao
import com.ueb.cost_calculation.cost_calculator.model.entity.ItemEntityModel

@Database(
    entities = [ItemEntityModel::class],
    version = 1
)

abstract class ItemDatabase : RoomDatabase() {

    abstract fun itemDao() : ItemDao

    companion object {
        @Volatile private var itemDbInstance:ItemDatabase? = null

        fun getDbInstance(context: Context): ItemDatabase =
            itemDbInstance ?: synchronized(this) {
                itemDbInstance ?: buildDb(context)
                    .also { itemDbInstance = it }
            }

        private fun buildDb(context: Context): ItemDatabase {
            return Room
                .databaseBuilder(context.applicationContext, ItemDatabase::class.java,"itemdb.db")
                .build()
        }

    }

}