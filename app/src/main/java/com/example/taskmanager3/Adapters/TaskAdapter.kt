package com.example.taskmanager3.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskmanager3.Model.Task
import com.example.taskmanager3.databinding.ItemTasksBinding

class TaskAdapter() : Adapter<TaskAdapter.TaskViewHolder>() {
    private val arrayList = ArrayList<Task>()
    fun addData(task: Task) {
        arrayList.add(0, task)
        notifyItemChanged(0)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTasksBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.onBind()
    }

    inner class TaskViewHolder(private var binding: ItemTasksBinding) : ViewHolder(binding.root) {
        fun onBind() {
            with(binding) {
                tvTitle.text = arrayList[adapterPosition].title
                tvDescription.text = arrayList[adapterPosition].desc
            }
        }

    }
}