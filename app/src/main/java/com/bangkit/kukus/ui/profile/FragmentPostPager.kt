package com.bangkit.kukus.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.bangkit.kukus.R

import com.bangkit.kukus.databinding.FragmentPostPagerBinding
import com.bangkit.kukus.firebase.FirestoreClass


class FragmentPostPager : Fragment() {

    private var _binding: FragmentPostPagerBinding? = null
    private val binding get() = _binding!!
    val currentUserID = FirestoreClass().getCurrentUserID()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPostPagerBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       /* binding.btnAddNewPost.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_profileFragment_to_fragmentAddNewPost)
        )*/

        if (currentUserID.isNotEmpty()){
            FirestoreClass().dataUser(this)
        } else {

        }

        if (currentUserID.isEmpty()){
            binding.textView17.setVisibility(View.INVISIBLE)
            binding.btnAddNewPost.setVisibility(View.INVISIBLE)

        }
        else{
            binding.btnAddNewPost.setOnClickListener{
                Toast.makeText(activity,"Maaf fitur ini belum tersedia",Toast.LENGTH_SHORT).show();
            }
            binding.textView18.setVisibility(View.INVISIBLE)
        }



    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}