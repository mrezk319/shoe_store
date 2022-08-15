package com.udacity.shoestore.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.view_model.ShareViewModel
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class detailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    lateinit var binding: FragmentDetailBinding
    val viewModel: ShareViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater)
        (activity as AppCompatActivity).supportActionBar?.title = "Add New Shoe!"

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.shareViewModel = viewModel
        super.onViewCreated(view, savedInstanceState)
        binding.Save.setOnClickListener {
            viewModel.shoesList.value?.add(
                Shoe(
                    binding.shoeName.text.toString(),
                    binding.size.text.toString().toDouble(),
                    binding.company.text.toString(),
                    binding.description.text.toString()
                )
            )
            viewModel.cleanFields()
            findNavController().navigate(R.id.action_detailFragment_to_shoeListFragment)
            Timber.i(viewModel.shoesList.value.toString())

        }

        binding.cancel.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_shoeListFragment)
        }
    }
}