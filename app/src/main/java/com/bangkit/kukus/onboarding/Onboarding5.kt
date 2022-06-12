package com.bangkit.kukus.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.bangkit.kukus.R
import com.bangkit.kukus.databinding.FragmentOnboarding4Binding
import com.bangkit.kukus.databinding.FragmentOnboarding5Binding
import com.bangkit.kukus.preference.Constant
import com.bangkit.kukus.preference.Constant.BERAT_BADAN
import com.bangkit.kukus.preference.Constant.TINGGI_BADAN
import com.bangkit.kukus.preference.Utils
import com.bangkit.kukus.preference.Utils.putPreferenceInt


class Onboarding5 : Fragment() {

    private lateinit var binding: FragmentOnboarding5Binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboarding5Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnBeratBadan.setOnClickListener {
                var berat = etBeratBadan.text.toString()
                if (berat.isEmpty()) {
                    binding.etBeratBadan.error = getString(R.string.empty)
                } else {
                    findNavController().navigate(Onboarding5Directions.actionOnboarding5ToOnboarding6())
                    putPreferenceInt(requireContext(), BERAT_BADAN, berat.toInt())
                }
            }
            ivBack.setOnClickListener{
                requireActivity().onBackPressed()
            }
        }
    }



}