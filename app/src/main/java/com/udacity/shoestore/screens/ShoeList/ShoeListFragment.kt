package com.udacity.shoestore.screens.ShoeList

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.view_model.ShareViewModel
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ListItemBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    val viewModel: ShareViewModel by activityViewModels()
    lateinit var binding: FragmentShoeListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "Shoe List"
        setHasOptionsMenu(true)
        binding = FragmentShoeListBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun addNewShoe(shoe: Shoe) {
        val itemBinding = ListItemBinding.inflate(LayoutInflater.from(context))
        itemBinding.apply {
            name.text = shoe.name
            size.text = shoe.size.toString()
            company.text = shoe.company
            description.text = shoe.description
        }
        binding.viewAdd.addView(itemBinding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.shoesList.observe(viewLifecycleOwner) {
            for (shoe in it) {
                addNewShoe(shoe)
            }
        }
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListFragment_to_detailFragment)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.sign_out, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.SignOut -> findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLogInFragment())
        }
        return super.onOptionsItemSelected(item)
    }

}