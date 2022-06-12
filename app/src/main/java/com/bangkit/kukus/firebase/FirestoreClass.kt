package com.bangkit.kukus.firebase


import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.bangkit.kukus.ui.login.LoginActivity
import com.bangkit.kukus.ui.register.RegisterActivity
import com.bangkit.kukus.data.remote.response.auth.User
import com.bangkit.kukus.databinding.FragmentSettingProfileBinding
import com.bangkit.kukus.firebase.Constants
import com.bangkit.kukus.ui.drawer.SettingActivity
import com.bangkit.kukus.ui.home.MainFragment
import com.bangkit.kukus.ui.profile.FragmentProfile
import com.bangkit.kukus.ui.profile.SettingProfile


class FirestoreClass {

    private val mFireStore = FirebaseFirestore.getInstance()

    fun registerUser(activity: RegisterActivity, userInfo: User) {

        mFireStore.collection(Constants.USERS)
            // Document ID for users fields. Here the document it is the User ID.
            .document(getCurrentUserID())
            // Here the userInfo are Field and the SetOption is set to merge. It is for if we wants to merge
            .set(userInfo, SetOptions.merge())
            .addOnSuccessListener {

                // Here call a function of base activity for transferring the result to it.
                activity.userRegisteredSuccess()
            }
            .addOnFailureListener { e ->
                Log.e(
                    activity.javaClass.simpleName,
                    "Error writing document",
                    e
                )
            }
    }


    fun signInUser(activity: Activity) {
        mFireStore.collection(Constants.USERS)

            .document(getCurrentUserID())
            .get()
            .addOnSuccessListener { document ->
                Log.e(
                    activity.javaClass.simpleName, document.toString()
                )


                val loggedInUser = document.toObject(User::class.java)!!

                when(activity){
                    is LoginActivity -> {
                        activity.signInSuccess(loggedInUser)
                    }
                }


            }
            .addOnFailureListener { e ->
                when (activity) {
                    is LoginActivity -> {
                        activity.hideProgressDialog()
                    }
                }
                Log.e(
                    activity.javaClass.simpleName,
                    "Error while getting loggedIn user details",
                    e
                )
            }
    }

    fun dataUser(fragment: Fragment) {
        mFireStore.collection(Constants.USERS)

            .document(getCurrentUserID())
            .get()
            .addOnSuccessListener { document ->


                val loggedInUser = document.toObject(User::class.java)!!


                when(fragment){
                    is MainFragment -> {
                        MainFragment.updateNavigationUserDetails(fragment, loggedInUser)
                    }

                    is FragmentProfile -> {
                        FragmentProfile.updateNavigationUserDetails(fragment, loggedInUser)
                    }
                    is SettingProfile -> {
                        SettingProfile.updateNavigationUserDetails(fragment, loggedInUser)
                    }


                }

            }
            .addOnFailureListener { e ->
                when (fragment) {
                    is MainFragment -> {

                    }
                }
                Log.e(
                    fragment.javaClass.simpleName,
                    "Error while getting loggedIn user details",
                    e
                )
            }
    }

    fun updateUserProfileData(fragment: SettingProfile, userHashMap: HashMap<String, Any>) {
        mFireStore.collection(Constants.USERS) // Collection Name
            .document(getCurrentUserID()) // Document ID
            .update(userHashMap) // A hashmap of fields which are to be updated.
            .addOnSuccessListener {
                // Profile data is updated successfully.
                Log.e(fragment.javaClass.simpleName, "Data berhasil diubah")



                // Notify the success result.
                fragment.profileUpdateSuccess()
            }
            .addOnFailureListener { e ->

                Log.e(
                    fragment.javaClass.simpleName,
                    "Error ",
                    e
                )
            }
    }

    fun dataUserActivity(activity: Activity) {
        mFireStore.collection(Constants.USERS)

            .document(getCurrentUserID())
            .get()
            .addOnSuccessListener { document ->


                val loggedInUser = document.toObject(User::class.java)!!


/*                when(activity){
                    is SettingActivity -> {
                        activity.updateNavigationUserDetails(loggedInUser)
                    }


                }*/

            }
            .addOnFailureListener { e ->
                when (activity) {
                    is SettingActivity -> {

                    }
                }
                Log.e(
                    activity.javaClass.simpleName,
                    "Error while getting loggedIn user details",
                    e
                )
            }
    }

    fun getCurrentUserID(): String {
        val currentUser = FirebaseAuth.getInstance().currentUser

        var currentUserID = ""
        if (currentUser != null) {
            currentUserID = currentUser.uid
        }
        return currentUserID
    }

/*
    fun updateUserProfileData(
        firestoreClass: FirestoreClass,
        fragment: SettingProfile, userHashMap: HashMap<String, Any>) {
        firestoreClass.mFireStore.collection(Constants.USERS) // Collection Name
            .document(firestoreClass.getCurrentUserID()) // Document ID
            .update(userHashMap) // A hashmap of fields which are to be updated.
            .addOnSuccessListener {

                fragment.profileUpdateSuccess()
            }
            .addOnFailureListener { e ->

                Log.e(
                    fragment.javaClass.simpleName,
                    "Error",
                    e
                )
            }
    }
*/

    companion object {
        fun updateUserProfileData(
            firestoreClass: FirestoreClass,
            fragment: SettingProfile, userHashMap: HashMap<String, Any>) {
            firestoreClass.mFireStore.collection(Constants.USERS) // Collection Name
                .document(firestoreClass.getCurrentUserID()) // Document ID
                .update(userHashMap) // A hashmap of fields which are to be updated.
                .addOnSuccessListener {

                    fragment.profileUpdateSuccess()
                }
                .addOnFailureListener { e ->

                    Log.e(
                        fragment.javaClass.simpleName,
                        "Error",
                        e
                    )
                }
        }
    }

}