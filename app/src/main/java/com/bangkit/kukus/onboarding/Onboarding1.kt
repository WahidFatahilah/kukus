package com.bangkit.kukus.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bangkit.kukus.databinding.FragmentOnboarding1Binding
import com.bangkit.kukus.preference.Constant
import com.bangkit.kukus.preference.Utils


class Onboarding1 : Fragment() {

    private lateinit var binding: FragmentOnboarding1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboarding1Binding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var tujuanIdeal: Int

        binding.apply {
            btnGainWeight.setOnClickListener {
                tujuanIdeal = 0
                findNavController().navigate(Onboarding1Directions.actionOnboarding1ToOnboarding2())
                Utils.putPreferenceInt(requireContext(), Constant.TUJUAN_IDEAL, tujuanIdeal)
            }
            btnLoseWeight.setOnClickListener {
                tujuanIdeal = 1
                findNavController().navigate(Onboarding1Directions.actionOnboarding1ToOnboarding2())
                Utils.putPreferenceInt(requireContext(), Constant.TUJUAN_IDEAL, tujuanIdeal)
            }
        }
    }
}