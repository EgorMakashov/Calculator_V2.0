package com.example.calculator_v20.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.calculator_v20.MAIN
import com.example.calculator_v20.R
import com.example.calculator_v20.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {


    lateinit var binding: FragmentFirstBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNext.setOnClickListener {
            MAIN.navController.navigate(R.id.action_firstFragment_to_secondFragment)
        }
        binding.btnNews.setOnClickListener {
            MAIN.navController.navigate(R.id.action_firstFragment_to_thirdFragment)

        }


    }
}