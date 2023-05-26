package com.example.taskmanager3.Profile

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.taskmanager3.Data.local.PrefTasks
import com.example.taskmanager3.Utils.loadImage
import com.example.taskmanager3.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var prefTasks: PrefTasks

    private val launcher = registerForActivityResult<Intent, ActivityResult>(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK
            && result.data != null
        ) {
            val photoUri = result.data?.data
            prefTasks.imageSave(photoUri.toString())
            binding.ivAvatar.loadImage(photoUri.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prefTasks = PrefTasks(requireContext())
        binding.etName.setText(prefTasks.isNameSaved())
        clickListener()
    }

    private fun clickListener() {
        prefTasks = PrefTasks(requireContext())
        binding.ivAvatar.loadImage(prefTasks.getImage())
        binding.ivAvatar.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            launcher.launch(intent)
        }
//        registerForActivityResult(
//            ActivityResultContracts.StartActivityForResult()
//        ) { result: ActivityResult ->
//            if (result.resultCode == Activity.RESULT_OK
//                && result.data != null
//            ) {
//                val photoUri: Uri? = result.data?.data
//                prefTasks.imageSave(photoUri.toString())
//                binding.run {
//                    prefTasks.imageSave(photoUri.toString())
//                    ivAvatar.run { loadImage(photoUri.toString()) }
//                }
//            }
        }
    }
