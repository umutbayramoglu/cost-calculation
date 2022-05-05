package com.ueb.cost_calculation.base.db

import android.content.Context
import androidx.room.*
import com.ueb.cost_calculation.cost_calculator.model.dao.ItemDao
import com.ueb.cost_calculation.cost_calculator.model.entity.ItemEntityModel
import com.ueb.cost_calculation.cost_calculator.model.entity.ItemPartTypeConverter

@Database(
    entities = [ItemEntityModel::class],
    version = 1
)
@TypeConverters(ItemPartTypeConverter::class)
abstract class CostCalculationDatabase : RoomDatabase() {

    abstract fun itemDao() : ItemDao

    companion object {
        @Volatile private var costCalculationDbInstance:CostCalculationDatabase? = null

        fun getDbInstance(context: Context): CostCalculationDatabase =
            costCalculationDbInstance ?: synchronized(this) {
                costCalculationDbInstance ?: buildDb(context)
                    .also { costCalculationDbInstance = it }
            }

        private fun buildDb(context: Context): CostCalculationDatabase {
            return Room
                .databaseBuilder(context.applicationContext, CostCalculationDatabase::class.java,"itemdb.db")
                .build()
        }

    }

}