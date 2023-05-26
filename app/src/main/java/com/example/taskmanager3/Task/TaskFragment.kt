package com.example.taskmanager3.Task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.taskmanager3.Model.Task
import com.example.taskmanager3.databinding.FragmentTaskBinding

class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataSend()
    }

    private fun dataSend() {
        with(binding) {
            btnSave.setOnClickListener {
                val data = Task(etTitle.text.toString(), etDescription.text.toString())
                setFragmentResult(RESULT_REQUEST, bundleOf(RESULT_KEY to data))
                findNavController().navigateUp()
            }
        }
    }

    companion object {
        const val RESULT_REQUEST = "result_request.task"
        const val RESULT_KEY = "result_key.task"
    }
}