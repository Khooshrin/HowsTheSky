package com.example.howsthesky

import android.app.ActionBar
import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.howsthesky.databinding.FragmentRecentCitiesBinding

class RecentCitiesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentRecentCitiesBinding>(inflater,R.layout.fragment_recent_cities,container,false)
        (activity as MainActivity).change("Recent Cities")
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.goToCurrentWeather.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_recentCitiesFragment_to_currentWeatherFragment)
        }
        return binding.root
    }


}