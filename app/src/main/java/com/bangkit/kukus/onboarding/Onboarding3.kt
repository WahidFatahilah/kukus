package com.bangkit.kukus.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bangkit.kukus.R
import com.bangkit.kukus.databinding.FragmentOnboarding3Binding
import com.bangkit.kukus.preference.Constant.UMUR
import com.bangkit.kukus.preference.Utils.putPreferenceInt


class Onboarding3 : Fragment() {


    private lateinit var binding: FragmentOnboarding3Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboarding3Binding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.apply {
            btnUmur.setOnClickListener {
                var umur = etUmur.text.toString()
                if (umur.isEmpty()) {
                    binding.etUmur.error = getString(R.string.empty)
                } else {
                    findNavController().navigate(Onboarding3Directions.actionOnboarding3ToOnboarding4())
                    putPreferenceInt(requireContext(), UMUR, umur.toInt())
                }
            }
            ivBack.setOnClickListener {
                requireActivity().onBackPressed()
            }
        }
    }
}