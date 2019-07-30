package com.astronout.viewmodelnetworking.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.astronout.viewmodelnetworking.R
import com.astronout.viewmodelnetworking.databinding.ItemPlaceBinding
import com.astronout.viewmodelnetworking.models.ListPlaceResponseModel
import com.astronout.viewmodelnetworking.viewmodels.ItemPlaceViewModel

class ListPlaceAdapter(val context: Context): RecyclerView.Adapter<ListPlaceAdapter.ItemPlaceViewHolder>() {

    private var listPlace: MutableList<ListPlaceResponseModel.ListPlaceModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPlaceViewHolder {
        val binding: ItemPlaceBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_place, parent, false)
        return ItemPlaceViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listPlace.size
    }

    override fun onBindViewHolder(holder: ItemPlaceViewHolder, position: Int) {
        holder.bindData(listPlace[holder.adapterPosition])

        holder.itemView.setOnClickListener{
            Toast.makeText(context, listPlace[position].name, Toast.LENGTH_SHORT).show()
        }
    }

    fun setData(list: MutableList<ListPlaceResponseModel.ListPlaceModel>){
        this.listPlace = list
    }

    class ItemPlaceViewHolder(private val binding: ItemPlaceBinding) : RecyclerView.ViewHolder(binding.root){

        fun bindData(model: ListPlaceResponseModel.ListPlaceModel){
            val viewModel = ItemPlaceViewModel(model)
            binding.itemPlace = viewModel
        }

    }

}

