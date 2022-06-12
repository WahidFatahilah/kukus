package com.bangkit.kukus.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bangkit.kukus.databinding.FragmentOnboarding7Binding
import com.bangkit.kukus.preference.Constant
import com.bangkit.kukus.preference.Utils.putPreferenceFloat


class Onboarding7 : Fragment() {

    private lateinit var binding: FragmentOnboarding7Binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboarding7Binding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var proses: Float

        binding.apply {
            btnProsesLambat.setOnClickListener {
                proses = 0.2F
                findNavController().navigate(Onboarding7Directions.actionOnboarding7ToFinalActivity())
                putPreferenceFloat(requireContext(), Constant.KECEPATAN_PROSES, proses)
            }
            btnProsesNormal.setOnClickListener {
                proses = 0.23F
                findNavController().navigate(Onboarding7Directions.actionOnboarding7ToFinalActivity())
                putPreferenceFloat(requireContext(), Constant.KECEPATAN_PROSES, proses)
            }
            btnProsesCepat.setOnClickListener {
                proses = 0.25F
                findNavController().navigate(Onboarding7Directions.actionOnboarding7ToFinalActivity())
                putPreferenceFloat(requireContext(), Constant.KECEPATAN_PROSES, proses)
            }
            ivBack.setOnClickListener {
                requireActivity().onBackPressed()
            }
        }
    }
}