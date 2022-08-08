package com.rsstudio.networkcalling.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.rsstudio.networkcalling.R
import com.rsstudio.networkcalling.adapter.MainAdapter
import com.rsstudio.networkcalling.api.BeerInfoNetworkEntity
import com.rsstudio.networkcalling.databinding.ActivityMainBinding
import com.rsstudio.networkcalling.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    var logTag = "@MainActivity"

    private lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //
        initTheme()
        initRecyclerView()

        viewModel.beerData.observe(this) {

            if (it != null) {
                // submit list
                val list: MutableList<BeerInfoNetworkEntity> = mutableListOf()
                list.addAll(it)
                mainAdapter.submitList(list)
                Log.d(logTag, "onCreate: data$list")

            }
        }

    }

    private fun initRecyclerView() {
        val llm = LinearLayoutManager(this)
        binding.rvBeerInfo.setHasFixedSize(true)
        binding.rvBeerInfo.layoutManager = llm
        mainAdapter = MainAdapter(this)
        binding.rvBeerInfo.adapter = mainAdapter
    }


    private fun initTheme() {
        window.statusBarColor = resources.getColor(R.color.Black)
        window.navigationBarColor = resources.getColor(R.color.lightBlack)
    }
}