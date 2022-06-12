package com.bangkit.kukus.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.bangkit.kukus.R
import com.bangkit.kukus.databinding.FragmentOnboarding6Binding
import com.bangkit.kukus.preference.Constant
import com.bangkit.kukus.preference.Utils


class Onboarding6 : Fragment() {

    private lateinit var binding: FragmentOnboarding6Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboarding6Binding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var aktifitas: Float

        binding.btnAktifitas1.setOnClickListener {
            aktifitas = 1.2F
            view.findNavController().navigate(R.id.action_onboarding6_to_onboarding7)
            Utils.putPreferenceFloat(requireContext(), Constant.TINGKAT_AKTIVITAS, aktifitas)
        }
        binding.btnAktifitas2.setOnClickListener {
            aktifitas = 1.375F
            view.findNavController().navigate(R.id.action_onboarding6_to_onboarding7)
            Utils.putPreferenceFloat(requireContext(), Constant.TINGKAT_AKTIVITAS, aktifitas)
        }
        binding.btnAktifitas3.setOnClickListener {
            aktifitas = 1.55F
            view.findNavController().navigate(R.id.action_onboarding6_to_onboarding7)
            Utils.putPreferenceFloat(requireContext(), Constant.TINGKAT_AKTIVITAS, aktifitas)
        }
        binding.btnAktifitas4.setOnClickListener {
            aktifitas = 1.725F
            view.findNavController().navigate(R.id.action_onboarding6_to_onboarding7)
            Utils.putPreferenceFloat(requireContext(), Constant.TINGKAT_AKTIVITAS, aktifitas)
        }
        binding.btnAktifitas5.setOnClickListener {
            aktifitas = 1.9F
            view.findNavController().navigate(R.id.action_onboarding6_to_onboarding7)
            Utils.putPreferenceFloat(requireContext(), Constant.TINGKAT_AKTIVITAS, aktifitas)
        }

    }


}