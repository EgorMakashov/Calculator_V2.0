package com.example.calculator_v20.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calculator_v20.DataClass.News
import com.example.calculator_v20.RecyclerAdapter


import com.example.calculator_v20.databinding.FragmentThirdBinding


class ThirdFragment : Fragment() {


    private lateinit var binding: FragmentThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdBinding.inflate(layoutInflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(activity)
            recyclerView.adapter = RecyclerAdapter(fillList(),requireContext())
        }

    }

    private fun fillList(): MutableList<News> {
        val data = mutableListOf<News>()
        (0..30).forEach {i ->  data.add(News(Tittle = "$i element"))}
        return data
    }

}
