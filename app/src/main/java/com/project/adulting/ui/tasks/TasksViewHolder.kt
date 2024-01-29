package com.project.adulting.ui.tasks

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.project.adulting.databinding.ItemTaskBinding

class TasksViewHolder (view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemTaskBinding.bind(view)

    fun render (task: Task){
        binding.tvItemTask.text = task.text
    }

}