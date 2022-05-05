package com.ueb.cost_calculation.cost_calculator.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.ueb.cost_calculation.R
import com.ueb.cost_calculation.base.ui.fragment.BasePageFragment
import com.ueb.cost_calculation.cost_calculator.model.entity.ItemEntityModel
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
    private var itemCostHashMap : MutableMap<String,Int> = HashMap()

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

        viewModel.item.await().observe(viewLifecycleOwner, Observer { item ->
            val cost = findItemCost(item)
            tv_costView.text = cost.toString()
            Log.e("CostCalculatorFragment", cost.toString())
        })
    }

    private fun findItemCost(item: ItemEntityModel?): Int{
        if(item == null)
            return 0;

        if(itemCostHashMap.containsKey(item.name))
            return itemCostHashMap[item.name]!!

        // Check cur item is has sub-items or not
        if(item.items == null){
            return item.count * item.price!!
        }

        var curCost = 0
        for(subItem in item.items){
            curCost += findItemCost(subItem)
        }
        curCost *= item.count

        itemCostHashMap[item.name] = curCost
        return  curCost
    }
}