package com.ueb.cost_calculation.base.ui.fragment

import androidx.fragment.app.Fragment
import com.ueb.cost_calculation.base.ui.activity.BaseActivity


abstract class BasePageFragment: Fragment(){

    protected fun startPageFragment(fragment: BasePageFragment){
        (fragment.activity as BaseActivity).startPageFragment(fragment)
    }
}