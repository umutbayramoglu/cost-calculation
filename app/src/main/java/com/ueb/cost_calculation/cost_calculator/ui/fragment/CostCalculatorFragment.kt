package com.ueb.cost_calculation.cost_calculator.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ueb.cost_calculation.R
import com.ueb.cost_calculation.base.ui.fragment.BasePageFragment
import com.ueb.cost_calculation.cost_calculator.ui.CostCalculatorViewModelFactory
import org.koin.android.ext.android.inject

class CostCalculatorFragment : BasePageFragment() {

    companion object {
        fun newInstance() = CostCalculatorFragment()
    }

    private val viewModelFactory by inject<CostCalculatorViewModelFactory>()

    private lateinit var viewModel: CostCalculatorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cost_calculator_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory).get(CostCalculatorViewModel::class.java)


    }

}