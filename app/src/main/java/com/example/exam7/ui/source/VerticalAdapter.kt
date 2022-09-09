package com.example.exam7.ui.source

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exam7.databinding.CustomItemVerticalBinding
import com.example.exam7.exstensions.setImage
import com.example.exam7.model.RecycleData

class VerticalAdapter :
    ListAdapter<RecycleData.ActiveCourse, VerticalAdapter.VerticalViewHolder>(
        VerticalCallBack
    ) {

    inner class VerticalViewHolder(private val binding: CustomItemVerticalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val items = getItem(adapterPosition)
            binding.apply {
                imageView.setImage(items.image)
                ivTime.text = items.bookingTime
                ivTime2.text = items.bookingTime
                constraint.setBackgroundColor(items.mainColor!!.toInt())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalViewHolder {
        return VerticalViewHolder(
            CustomItemVerticalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VerticalViewHolder, position: Int) {
        holder.bind()
    }

}

object VerticalCallBack : DiffUtil.ItemCallback<RecycleData.ActiveCourse>() {
    override fun areItemsTheSame(
        oldItem: RecycleData.ActiveCourse,
        newItem: RecycleData.ActiveCourse
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: RecycleData.ActiveCourse,
        newItem: RecycleData.ActiveCourse
    ): Boolean {
        return oldItem == newItem
    }

}