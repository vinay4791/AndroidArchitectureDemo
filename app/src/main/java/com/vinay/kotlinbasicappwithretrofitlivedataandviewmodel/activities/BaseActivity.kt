package com.vinay.kotlinbasicappwithretrofitlivedataandviewmodel.activities

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    /*
    Every Activity will be having views and that needs to be initialized.
    You can you this function to declare and initialize this type of variables
     */
    abstract fun initialize()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        initialize()
    }
}
