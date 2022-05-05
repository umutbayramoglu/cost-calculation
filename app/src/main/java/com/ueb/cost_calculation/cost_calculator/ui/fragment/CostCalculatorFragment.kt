package com.ueb.cost_calculation.cost_calculator.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.ueb.cost_calculation.R
import com.ueb.cost_calculation.base.ui.fragment.BasePageFragment
import com.ueb.cost_calculation.cost_calculator.ui.CostCalculatorViewModelFactory
import kotlinx.android.synthetic.main.cost_calculator_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
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

        viewModel =
            ViewModelProvider(this, viewModelFactory).get(CostCalculatorViewModel::class.java)
        initViews()
    }

    private fun initViews() = GlobalScope.launch(Dispatchers.Main) {
        viewModel.items.await().observe(viewLifecycleOwner, Observer { itemList ->
            if (itemList != null && itemList.isNotEmpty()) {
                itemName.text = itemList[0].name
                itemCount.text = itemList[0].count.toString()
            }

        })
    }
}