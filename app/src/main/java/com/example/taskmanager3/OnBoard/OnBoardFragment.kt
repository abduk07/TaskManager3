package com.example.taskmanager3.OnBoard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.taskmanager3.Adapters.OnBoardAdapter
import com.example.taskmanager3.Data.local.PrefTasks
import com.example.taskmanager3.databinding.FragmentOnBoardBinding

class OnBoardFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardBinding
    private var adapter = OnBoardAdapter(this::onSkip)
    private lateinit var prefTasks: PrefTasks


    private fun onSkip() {
        prefTasks.userSeen()
        findNavController().navigateUp()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prefTasks = PrefTasks(requireContext())
        initAdapter()
    }

    private fun initAdapter() {
        with(binding) {
            viewPager2.adapter = adapter
            indicator.setViewPager(viewPager2)
        }
    }
}