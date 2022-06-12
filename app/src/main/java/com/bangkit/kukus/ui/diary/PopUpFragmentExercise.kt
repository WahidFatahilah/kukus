package com.bangkit.kukus.ui.diary

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.bangkit.kukus.databinding.FragmentPopUpExerciseBinding
import com.bangkit.kukus.preference.Constant
import com.bangkit.kukus.preference.Utils


class PopUpFragmentExercise(private val updateData: UpdateData) : DialogFragment() {

    private var _binding: FragmentPopUpExerciseBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPopUpExerciseBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        binding?.btnCancel?.setOnClickListener {
            dismiss()
        }

        binding?.btnSave?.setOnClickListener {
            val kaloriExercise = binding?.etTotalCalorie?.text.toString().toInt()
            val exercise = Utils.getPreferenceInt(requireContext(), Constant.KALORI_DIBAKAR)
            val calculate = kaloriExercise + exercise
            Utils.putPreferenceInt(requireContext(), Constant.KALORI_DIBAKAR, calculate)
            dismiss()
            updateData.setDataUpdate(true)
            Toast.makeText(requireActivity(), "Berhasil ditambahkan", Toast.LENGTH_SHORT).show()
        }
        isCancelable = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    interface UpdateData {
        fun setDataUpdate(status: Boolean)
    }
}