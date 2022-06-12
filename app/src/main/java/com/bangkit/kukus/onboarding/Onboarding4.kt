package com.bangkit.kukus.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bangkit.kukus.R
import com.bangkit.kukus.databinding.FragmentOnboarding4Binding
import com.bangkit.kukus.preference.Constant.TINGGI_BADAN
import com.bangkit.kukus.preference.Utils.putPreferenceInt


class Onboarding4 : Fragment() {

    private lateinit var binding: FragmentOnboarding4Binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboarding4Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnTinggi.setOnClickListener {
                var tinggi = etTinggi.text.toString()
                if (tinggi.isEmpty()) {
                    binding.etTinggi.error = getString(R.string.empty)
                } else {
                    findNavController().navigate(Onboarding4Directions.actionOnboarding4ToOnboarding5())
                    putPreferenceInt(requireContext(), TINGGI_BADAN, tinggi.toInt())
                }
            }
            ivBack.setOnClickListener {
                requireActivity().onBackPressed()
            }
        }
    }
}