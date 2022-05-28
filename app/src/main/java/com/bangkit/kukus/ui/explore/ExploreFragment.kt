package com.bangkit.kukus.ui.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.kukus.databinding.FragmentExploreBinding
import com.bangkit.kukus.viewmodel.ViewModelFactory


class ExploreFragment : Fragment() {

    private lateinit var binding: FragmentExploreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExploreBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel = ViewModelProvider(this@ExploreFragment, factory)[ExploreViewModel::class.java]
        val exploreAdapter = ExploreAdapter()

        binding.rvExplore.apply {
            setHasFixedSize(true)
            adapter = exploreAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel.getUsers().observe(viewLifecycleOwner) {
            exploreAdapter.setData(it)
        }
    }
}