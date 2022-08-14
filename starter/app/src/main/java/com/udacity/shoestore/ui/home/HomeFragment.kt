package com.udacity.shoestore.ui.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentHomeBinding
import com.udacity.shoestore.databinding.ShoeListItemBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.ui.ShoeViewModel


class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
    }
    private val linearLayout by lazy {
        binding.shoesLL
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        binding.addShoeFAB.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_shoeDetailFragment)
        }
        viewModel.mutableLiveData.observe(viewLifecycleOwner) { shoes ->
            for (shoe in shoes) {
                addShoeView(shoe)
            }
        }
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.navigation_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController())
                || super.onOptionsItemSelected(item)

    }

    private fun addShoeView(shoe: Shoe) {
        val shoeView =
            View.inflate(context, R.layout.shoe_list_item, null)
        val shoeBinding = ShoeListItemBinding.bind(shoeView)
        shoeBinding.shoe = shoe
        linearLayout.addView(shoeView)
    }

}