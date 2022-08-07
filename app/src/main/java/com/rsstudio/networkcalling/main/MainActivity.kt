package com.rsstudio.networkcalling.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.rsstudio.networkcalling.R
import com.rsstudio.networkcalling.databinding.ActivityMainBinding
import com.rsstudio.networkcalling.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        viewModel.responseBeerDetail.observe(this) { response ->

            if (response != null) {
                // submit list
                val list: MutableList<BeerNetworkEntity> = mutableListOf()
                list.addAll(response)
                mainAdapter.submitList(response)

                Log.d(logTag, "onCreate: data$list")

            }
        }


    }

    private fun initTheme() {
        window.statusBarColor = resources.getColor(R.color.Black)
        window.navigationBarColor = resources.getColor(R.color.lightBlack)
    }
}