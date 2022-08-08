package com.rsstudio.networkcalling.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.rsstudio.networkcalling.R
import com.rsstudio.networkcalling.api.BeerInfoNetworkEntity
import com.rsstudio.networkcalling.databinding.ActivityMainBinding
import com.rsstudio.networkcalling.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    var logTag = "@MainActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //
        initTheme()

        viewModel.beerData.observe(this) {

            if (it != null) {
                // submit list
                val list: MutableList<BeerInfoNetworkEntity> = mutableListOf()
                list.addAll(it)
                Log.d(logTag, "onCreate: data$list")

            }
        }

    }

    private fun initTheme() {
        window.statusBarColor = resources.getColor(R.color.Black)
        window.navigationBarColor = resources.getColor(R.color.lightBlack)
    }
}