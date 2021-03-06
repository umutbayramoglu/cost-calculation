package com.ueb.cost_calculation.base.ui.activity

import android.os.Bundle
import com.ueb.cost_calculation.R
import com.ueb.cost_calculation.cost_calculator.ui.fragment.CostCalculatorFragment
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.activityScope
import org.koin.core.scope.Scope

class MainActivity : BaseActivity(), AndroidScopeComponent {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        startPageFragment(CostCalculatorFragment.newInstance())
    }

    override val scope: Scope by activityScope()
}