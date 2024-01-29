package com.project.adulting.ui.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.adulting.R

class TasksAdapter (private var tasksList: List <Task> = emptyList()): RecyclerView.Adapter<TasksViewHolder>() {

    fun refresh(list: List<Task>){
        tasksList = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        return TasksViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task,parent,false))

    }

    override fun getItemCount() = tasksList.size

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        holder.render(tasksList[position])

    }

}