package com.example.exam7.ui.source

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exam7.databinding.CustomItemHorizontalBinding
import com.example.exam7.databinding.CustomItemVerticalBinding
import com.example.exam7.exstensions.setImage
import com.example.exam7.model.RecycleData

class HorizontalAdapter :
    ListAdapter<RecycleData.NewCourse, HorizontalAdapter.MainViewHolder>(
        HorizontalCallBack
    ) {

    inner class MainViewHolder(private val binding: CustomItemHorizontalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val items = getItem(adapterPosition)
            binding.apply {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            CustomItemHorizontalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind()
    }

}

object HorizontalCallBack : DiffUtil.ItemCallback<RecycleData.NewCourse>() {
    override fun areItemsTheSame(
        oldItem: RecycleData.NewCourse,
        newItem: RecycleData.NewCourse
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: RecycleData.NewCourse,
        newItem: RecycleData.NewCourse
    ): Boolean {
        return oldItem == newItem
    }

}