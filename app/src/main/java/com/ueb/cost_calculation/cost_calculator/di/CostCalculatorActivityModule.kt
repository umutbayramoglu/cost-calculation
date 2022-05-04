package com.ueb.cost_calculation.cost_calculator.di

import com.ueb.cost_calculation.base.db.CostCalculationDatabase
import com.ueb.cost_calculation.base.ui.fragment.MainActivity
import com.ueb.cost_calculation.cost_calculator.network.datasource.CostCalculatorNetworkDataSource
import com.ueb.cost_calculation.cost_calculator.network.datasource.CostCalculatorNetworkDataSourceImpl
import com.ueb.cost_calculation.cost_calculator.repository.CostCalculatorRepository
import com.ueb.cost_calculation.cost_calculator.repository.CostCalculatorRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val costCalculatorActivityModule = module {
    scope<MainActivity>{

        scoped {
            CostCalculationDatabase.getDbInstance(androidContext()).itemDao()
         }

        scoped <CostCalculatorNetworkDataSource> {
                CostCalculatorNetworkDataSourceImpl()
            }

        scoped <CostCalculatorRepository>{
            CostCalculatorRepositoryImpl(get(), get())
        }
    }
}