package com.bangkit.kukus.ui.diary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bangkit.kukus.databinding.FragmentDiaryBinding
import com.bangkit.kukus.preference.Constant
import com.bangkit.kukus.preference.Utils.getPreferenceInt

class DiaryFragment : Fragment(), PopUpFragmentMakan.UpdateData, PopUpFragmentExercise.UpdateData {

    private lateinit var mOptionDialogFragment: PopUpFragmentMakan
    private lateinit var mOptionDialogFragmentExercise: PopUpFragmentExercise
    private lateinit var binding: FragmentDiaryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDiaryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        calculateDiary()

        binding.apply {
            cvBreakfast.setOnClickListener {
                mOptionDialogFragment = PopUpFragmentMakan(this@DiaryFragment)
                val mFragmentManager = childFragmentManager
                mOptionDialogFragment.show(
                    mFragmentManager,
                    PopUpFragmentMakan::class.java.simpleName
                )
            }
            cvLunch.setOnClickListener {
                mOptionDialogFragment = PopUpFragmentMakan(this@DiaryFragment)
                val mFragmentManager = childFragmentManager
                mOptionDialogFragment.show(
                    mFragmentManager,
                    PopUpFragmentMakan::class.java.simpleName
                )
            }
            cvDinner.setOnClickListener {
                mOptionDialogFragment = PopUpFragmentMakan(this@DiaryFragment)
                val mFragmentManager = childFragmentManager
                mOptionDialogFragment.show(
                    mFragmentManager,
                    PopUpFragmentMakan::class.java.simpleName
                )
            }
            cvExercise.setOnClickListener {
                mOptionDialogFragmentExercise = PopUpFragmentExercise(this@DiaryFragment)
                val mFragmentManager = childFragmentManager
                mOptionDialogFragmentExercise.show(
                    mFragmentManager,
                    PopUpFragmentExercise::class.java.simpleName
                )
            }
        }
    }

    private fun calculateDiary() {
        var dikonsumsi = getPreferenceInt(requireContext(), Constant.KALORI_DIKONSUMSI)
        var dibakar = getPreferenceInt(requireContext(), Constant.KALORI_DIBAKAR)
        var kaloriHarian = getPreferenceInt(requireContext(), Constant.KALORI_HARIAN)
        val calculate = kaloriHarian - dikonsumsi

        binding.tvTittleDiaryBurned.text = dibakar.toString()
        binding.tvTittleDiaryConsumed.text = dikonsumsi.toString()
        binding.tvTittleDiaryCalorie.text = calculate.toString()
    }

    override fun setDataUpdate(status: Boolean) {
        if (status) {
            calculateDiary()
        }
    }
}