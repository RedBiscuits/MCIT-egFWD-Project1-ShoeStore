package com.udacity.shoestore.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.ui.ShoeViewModel
import java.lang.Exception

class ShoeDetailFragment : Fragment(R.layout.fragment_shoe_detail) {

    private lateinit var binding: FragmentShoeDetailBinding

    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentShoeDetailBinding.inflate(layoutInflater, container, false)
        binding.newShoe = Shoe()
        binding.shoeDetailCancelBTN.setOnClickListener{
                it.findNavController().navigate(R.id.action_shoeDetailFragment_to_homeFragment2)
        }
        binding.shoeDetailSaveBTN.setOnClickListener{
            addShoeToViewModel()
            it.findNavController().navigate(R.id.action_shoeDetailFragment_to_homeFragment2)

        }
        return binding.root
    }

    private fun addShoeToViewModel() {
        try{
            //i dont know how to do 2 way binding for double values
            // perhaps will search for it when i get internet connectivity
            binding.newShoe!!.size = binding.shoeSizeET.text.toString().toDouble()
            viewModel.mutableLiveData.value?.add(binding.newShoe!!)
        }
        catch (e:Exception){
            e.printStackTrace()
        }
    }

}