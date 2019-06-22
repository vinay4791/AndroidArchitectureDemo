package com.vinay.kotlinbasicappwithretrofitlivedataandviewmodel.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.vinay.kotlinbasicappwithretrofitlivedataandviewmodel.adapter.PhotosListCustomAdapter
import com.vinay.kotlinbasicappwithretrofitlivedataandviewmodel.viewmodels.MainActivityViewModel
import litmus7.com.kotlinbasicappwithretrofitlivedataandviewmodel.R

class MainActivity : BaseActivity() {

    var recyclerView: RecyclerView? = null
    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()
    }

    override fun initialize() {
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        recyclerView = findViewById(R.id.albums_recycler_view)
        recyclerView?.layoutManager = LinearLayoutManager(this)

        mainActivityViewModel.photosModel.observe(this, Observer {

            it?.let {
                recyclerView?.setAdapter(PhotosListCustomAdapter(it,this))
            }
        })

        mainActivityViewModel.getData()
    }

}
