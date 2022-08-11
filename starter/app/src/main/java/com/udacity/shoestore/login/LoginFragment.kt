package com.udacity.shoestore.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater , container , false)

        //I don't know what is the best practice for such case
        //waiting for code review to know.. TY!
        binding.loginButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
        }
        binding.registerButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
        }


        return binding.root
    }


}