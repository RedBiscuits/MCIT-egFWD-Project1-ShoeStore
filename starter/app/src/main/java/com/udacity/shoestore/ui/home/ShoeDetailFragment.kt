package com.udacity.shoestore.ui.home

import android.os.Bundle
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
    private val shoe: Shoe by lazy {
        Shoe("",0.0,"","")
    }
    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentShoeDetailBinding.inflate(layoutInflater, container, false)

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
        shoe.size = binding.shoeSizeET.text.toString().toDouble()
        shoe.name = binding.shoeNameET.text.toString()
        shoe.company = binding.shoeCompanyET.text.toString()
        shoe.description = binding.shoeDescriptionET.text.toString()
        viewModel.mutableLiveData.value?.add(shoe)
    }catch (e:Exception){
        e.printStackTrace()
    }
    }

}