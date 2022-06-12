package com.bangkit.kukus.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.kukus.R
import com.bangkit.kukus.databinding.FragmentProfileBinding
import com.bangkit.kukus.databinding.FragmentSummaryBinding
import com.bangkit.kukus.firebase.FirestoreClass
import com.google.android.material.tabs.TabLayoutMediator


class FragmentSummary : Fragment() {

    private lateinit var binding: FragmentSummaryBinding
    val currentUserID = FirestoreClass().getCurrentUserID()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSummaryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (currentUserID.isNotEmpty()){
            FirestoreClass().dataUser(this)
        } else {

        }

        if (currentUserID.isEmpty()){
            binding.imageView8.visibility = View.INVISIBLE


        }else {
           binding.textViewGraph.visibility = View.INVISIBLE
        }


    }
}