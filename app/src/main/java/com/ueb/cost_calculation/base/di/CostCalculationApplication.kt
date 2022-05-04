package com.ueb.cost_calculation.base.di

import android.app.Application
import com.ueb.cost_calculation.cost_calculator.di.costCalculatorActivityModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CostCalculationApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@CostCalculationApplication)
            modules(appModule, costCalculatorActivityModule)
        }
    }
}