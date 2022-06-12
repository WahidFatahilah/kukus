package com.bangkit.kukus.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bangkit.kukus.databinding.FragmentOnboarding2Binding
import com.bangkit.kukus.preference.Constant.JENIS_KELAMIN
import com.bangkit.kukus.preference.Utils.putPreferenceInt


class Onboarding2 : Fragment() {

    private lateinit var binding: FragmentOnboarding2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboarding2Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var gender: Int

        binding.apply {
            btnKelaminPria.setOnClickListener {
                gender = +5
                findNavController().navigate(Onboarding2Directions.actionOnboarding2ToOnboarding3())
                putPreferenceInt(requireContext(), JENIS_KELAMIN, gender)
            }
            btnKelaminWanita.setOnClickListener {
                gender = -161
                findNavController().navigate(Onboarding2Directions.actionOnboarding2ToOnboarding3())
                putPreferenceInt(requireContext(), JENIS_KELAMIN, gender)
            }
            ivBack.setOnClickListener {
                requireActivity().onBackPressed()
            }
        }
    }
}