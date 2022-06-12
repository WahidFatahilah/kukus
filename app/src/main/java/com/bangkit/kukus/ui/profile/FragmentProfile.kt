package com.bangkit.kukus.ui.profile

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.MimeTypeMap
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bangkit.kukus.R
import com.bangkit.kukus.data.remote.response.auth.User
import com.bangkit.kukus.databinding.FragmentProfileBinding
import com.bangkit.kukus.firebase.FirestoreClass
import com.bangkit.kukus.onboarding.Onboarding1Directions
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.IOException


class FragmentProfile : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    val currentUserID = FirestoreClass().getCurrentUserID()
    private var mSelectedImageFileUri: Uri? = null
    private var mProfileImageURL : String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (currentUserID.isNotEmpty()){
            FirestoreClass().dataUser(this)
        } else {

        }


        val sectionsPagerAdapter = SectionsPagerAdapter(requireActivity() as AppCompatActivity)
        binding.viewPager.adapter = sectionsPagerAdapter
        TabLayoutMediator(binding.tablayout, binding.viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.  attach()

        if (currentUserID.isEmpty()){
            binding.textView16.setText(" - ")
            binding.textView22.setText(" - ")
            binding.textView20.setText(" - ")

        }
        binding.btnSetting.setOnClickListener{
            findNavController().navigate(FragmentProfileDirections.actionProfileFragmentToSettingProfile())
        }

        binding.circleImageView2.setOnClickListener{

            if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED
            ) {

                showImageChooser()
                uploadUserImage()
                // END
            } else {

                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    READ_STORAGE_PERMISSION_CODE
                )
            }
        }

    }

    private fun getFileExtension(uri: Uri?): String? {
        var contentResolver = requireActivity().contentResolver
        return MimeTypeMap.getSingleton().getExtensionFromMimeType(contentResolver?.getType(uri!!))
    }

    private fun uploadUserImage() {



        if (mSelectedImageFileUri != null) {

            //getting the storage reference
            val sRef: StorageReference = FirebaseStorage.getInstance().reference.child(
                "USER_IMAGE" + System.currentTimeMillis() + "." + getFileExtension(
                    mSelectedImageFileUri
                )
            )

            //adding the file to reference
            sRef.putFile(mSelectedImageFileUri!!)
                .addOnSuccessListener { taskSnapshot ->
                    // The image upload is success
                    Log.e(
                        "Firebase Image URL",
                        taskSnapshot.metadata!!.reference!!.downloadUrl.toString()
                    )

                    // Get the downloadable url from the task snapshot
                    taskSnapshot.metadata!!.reference!!.downloadUrl
                        .addOnSuccessListener { uri ->
                            Log.e("Downloadable Image URL", uri.toString())

                            // assign the image url to the variable.
                            mProfileImageURL = uri.toString()

                            // Call a function to update user details in the database.
                            /*updateUserProfileData()*/
                        }
                }
                .addOnFailureListener { exception ->
                    Toast.makeText(
                        activity,
                        exception.message,
                        Toast.LENGTH_LONG
                    ).show()


                }
        }

    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == READ_STORAGE_PERMISSION_CODE) {
            //If permission is granted
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                showImageChooser()

            } else {
                //Displaying another toast if permission is not granted
                Toast.makeText(activity,"Opps, kamu tidak memberikan ijin untuk mengakses penyimpanan. Kamu dapat mengubahnya dipengaturan",Toast.LENGTH_SHORT).show();
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val photoProfile = binding.circleImageView2
        if (resultCode == Activity.RESULT_OK
            && requestCode == PICK_IMAGE_REQUEST_CODE
            && data!!.data != null
        ) {
            // The uri of selection image from phone storage.
            mSelectedImageFileUri = data.data

            try {
                // Load the user image in the ImageView.
                Glide
                    .with(this)
                    .load(Uri.parse(mSelectedImageFileUri.toString())) // URI of the image
                    .centerCrop() // Scale type of the image.
                    .placeholder(R.drawable.ic_userprofile) // A default place holder
                    .into(photoProfile) // the view in which the image will be loaded.
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }



    private fun showImageChooser() {
        val galleryIntent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )
        startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST_CODE)
        uploadUserImage()
        activity?.finish()
    }



    companion object {
        @StringRes

        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2
        )
        private const val READ_STORAGE_PERMISSION_CODE = 1
        private const val PICK_IMAGE_REQUEST_CODE = 2

        fun updateNavigationUserDetails(profileFragmentProfile: FragmentProfile, user: User){
            val photoProfile = profileFragmentProfile.binding.circleImageView2
            val userName = profileFragmentProfile.binding.textView14

            Glide
                .with(profileFragmentProfile)
                .load(user.image)
                .centerCrop()
                .placeholder(R.drawable.ic_userprofile)
                .into(photoProfile)
            userName.text = user.name
        }



    }


}