package com.example.taskmanager3.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskmanager3.Model.OnBoard
import com.example.taskmanager3.Utils.loadImage
import com.example.taskmanager3.databinding.ItemOnboardBinding

class OnBoardAdapter(private val onSkip: () -> Unit) :
    RecyclerView.Adapter<OnBoardAdapter.OnBoardViewHolder>() {
    private val arrayList = arrayListOf<OnBoard>(

        OnBoard(
            "https://www.chanty.com/blog/wp-content/uploads/2020/10/Task-manager-apps-scaled.jpg",
            "Title",
            "Description"
        ),
        OnBoard(
            "https://www.chanty.com/blog/wp-content/uploads/2020/10/Task-manager-apps-scaled.jpg",
            "Title",
            "Description"
        ),
        OnBoard(
            "https://www.chanty.com/blog/wp-content/uploads/2020/10/Task-manager-apps-scaled.jpg",
            "Title",
            "Description"
        ),
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OnBoardAdapter.OnBoardViewHolder {
        return OnBoardViewHolder(
            ItemOnboardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardAdapter.OnBoardViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class OnBoardViewHolder(private val binding: ItemOnboardBinding) :
        ViewHolder(binding.root) {
        fun onBind() {
            with(binding) {
                tvTitleOnboard.text = arrayList[position].title
                tvDescriptionOnboard.text = arrayList[position].desc
                ivOnboard.loadImage(arrayList[position].image)

                btnSkip.isVisible = adapterPosition != 2
                btnStart.isVisible = adapterPosition == 2

                btnSkip.setOnClickListener {
                    onSkip()
                }
                btnStart.setOnClickListener {
                    onSkip()
                }
            }
        }

    }
}