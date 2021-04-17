package com.hloriot.pizzacrew.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.hloriot.pizzacrew.databinding.FragmentHomeBinding
import com.hloriot.pizzacrew.ui.home.adapter.PizzaAdapter

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.pizzaList.observe(viewLifecycleOwner) {
            binding.pizzaRecyclerView.adapter = PizzaAdapter(it)
        }
    }
}