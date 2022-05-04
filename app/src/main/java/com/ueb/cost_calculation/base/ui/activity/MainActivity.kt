package com.ueb.cost_calculation.base.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.ueb.cost_calculation.R
import com.ueb.cost_calculation.cost_calculator.di.costCalculatorActivityModule
import com.ueb.cost_calculation.cost_calculator.fragment.CostCalculatorFragment
import com.ueb.cost_calculation.cost_calculator.network.datasource.CostCalculatorNetworkDataSourceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.activityScope
import org.koin.core.scope.Scope

class MainActivity : BaseActivity(), AndroidScopeComponent {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        startPageFragment(CostCalculatorFragment.newInstance())

        /*GlobalScope.launch(Dispatchers.Main) {
            val dataSource = CostCalculatorNetworkDataSourceImpl()
            dataSource.getItems()

            val items = dataSource.fetchedItems.observe(this@MainActivity, Observer {
                Log.e("MainActivity" , it.name +" "+ it.count)
            })
        }*/
    }

    override val scope: Scope by activityScope()
}