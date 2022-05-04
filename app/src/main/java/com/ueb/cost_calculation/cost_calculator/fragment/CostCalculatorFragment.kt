package com.ueb.cost_calculation.cost_calculator.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ueb.cost_calculation.R
import com.ueb.cost_calculation.base.ui.fragment.BasePageFragment

class CostCalculatorFragment : BasePageFragment() {

    companion object {
        fun newInstance() = CostCalculatorFragment()
    }

    private lateinit var viewModel: CostCalculatorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cost_calculator_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CostCalculatorViewModel::class.java)
        // TODO: Use the ViewModel
    }

}