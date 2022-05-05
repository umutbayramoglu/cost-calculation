package com.ueb.cost_calculation.base.di

import com.ueb.cost_calculation.base.db.CostCalculationDatabase
import com.ueb.cost_calculation.cost_calculator.network.datasource.CostCalculatorNetworkDataSource
import com.ueb.cost_calculation.cost_calculator.network.datasource.CostCalculatorNetworkDataSourceImpl
import com.ueb.cost_calculation.cost_calculator.repository.CostCalculatorRepository
import com.ueb.cost_calculation.cost_calculator.repository.CostCalculatorRepositoryImpl
import com.ueb.cost_calculation.cost_calculator.ui.CostCalculatorViewModelFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    //TODO : refactor it
    single {
        CostCalculationDatabase.getDbInstance(androidContext()).itemDao()
    }

    single <CostCalculatorNetworkDataSource> {
        CostCalculatorNetworkDataSourceImpl()
    }

    single <CostCalculatorRepository>{
        CostCalculatorRepositoryImpl(get(), get())
    }

    single {
        CostCalculatorViewModelFactory(get())
    }
}