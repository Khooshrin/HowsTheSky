package com.example.howsthesky

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.trimmedLength
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.howsthesky.databinding.FragmentCurrentWeatherBinding
import java.util.*


class CurrentWeatherFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        (activity as MainActivity).change("Current Weather")
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        val binding = DataBindingUtil.inflate<FragmentCurrentWeatherBinding>(inflater,R.layout.fragment_current_weather,container,false)
        binding.city.visibility=View.GONE
        binding.temperature.visibility=View.GONE
        binding.weather.visibility=View.GONE
        binding.buttonCheckWeather.setOnClickListener { view: View ->
            if(binding.enterCity.text.toString().length!=0)
            binding.city.text=binding.enterCity.text.toString()
            else
                binding.city.text="Hyderabad"
            binding.temperature.text=when(Random().nextInt(4)+1){
                1 -> "23°C"
                2 -> "25°C"
                3 -> "27°C"
                else -> "21°C"
            }
            binding.weather.text=when(Random().nextInt(4)+1){
                1 -> "Thunderstorm"
                2 -> "Sunny"
                3 -> "Snow"
                else -> "Rainy"
            }
            binding.temperature.visibility=View.VISIBLE
            binding.weather.visibility=View.VISIBLE
            binding.city.visibility=View.VISIBLE
            binding.enterCity.text.clear()
        }
        binding.buttonGotoRecentCities.setOnClickListener { view:View ->
            view.findNavController().navigate(R.id.action_currentWeatherFragment_to_recentCitiesFragment)
        }
        return binding.root
    }


}






