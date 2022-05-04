package com.ueb.cost_calculation.base.ui.activity

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ueb.cost_calculation.R
import com.ueb.cost_calculation.base.ui.fragment.BasePageFragment

abstract class BaseActivity: AppCompatActivity() {

    fun startPageFragment(fragment:BasePageFragment){
        var fragmentTag: String = fragment.javaClass.canonicalName
        supportFragmentManager
            .beginTransaction()
            .add(R.id.content,fragment, fragmentTag)
            .addToBackStack(fragmentTag)
            .commitAllowingStateLoss()

        Log.i(fragmentTag, "Fragment started")
    }
}