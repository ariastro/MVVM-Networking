package com.astronout.viewmodelnetworking.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.astronout.viewmodelnetworking.R
import com.astronout.viewmodelnetworking.adapters.ListPlaceAdapter
import com.astronout.viewmodelnetworking.databinding.ActivityMainBinding
import com.astronout.viewmodelnetworking.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    private lateinit var adapter: ListPlaceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.main = viewModel

        setUpRecyclerView()
        observeLiveData()

        viewModel.getListPlace()

    }

    private fun observeLiveData() {
        viewModel.listPlace.observe(this, Observer {
            adapter.setData(it?.data!!)
            adapter.notifyDataSetChanged()
        })
        viewModel.error.observe(this, Observer {

        })
    }

    private fun setUpRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        binding.rv.layoutManager = layoutManager
        adapter = ListPlaceAdapter(this)
        binding.rv.adapter = adapter
    }
}
