package com.bangkit.kukus.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.bangkit.kukus.R
import com.bangkit.kukus.data.remote.response.auth.User
import com.bangkit.kukus.databinding.ActivityRegisterBinding
import com.bangkit.kukus.databinding.LoginBinding
import com.bangkit.kukus.firebase.BaseActivity
import com.bangkit.kukus.firebase.FirestoreClass
import com.bangkit.kukus.ui.login.LoginActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class RegisterActivity : BaseActivity() {

    private lateinit var binding : ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityRegisterBinding.inflate(layoutInflater);
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        binding.btnRegister.setOnClickListener {
            registerUser()
        }

        binding.tvRegisterHighlined.setOnClickListener{
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
        }
    }

    private fun registerUser() {

        val name: String = binding.etNameRegister.text.toString().trim { it <= ' ' }
        val email: String = binding.etEmailRegister.text.toString().trim { it <= ' ' }
        val password: String = binding.etPasswordRegister.text.toString().trim { it <= ' ' }

        if (validateForm(name, email, password)) {
            // Show the progress dialog.
            showProgressDialog(resources.getString(R.string.please_wait))
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                    OnCompleteListener<AuthResult> { task ->

                        // If the registration is successfully done
                        if (task.isSuccessful) {

                            // Firebase registered user
                            val firebaseUser: FirebaseUser = task.result!!.user!!
                            // Registered Email
                            val registeredEmail = firebaseUser.email!!

                            val user = User(
                                firebaseUser.uid, name, registeredEmail
                            )

                            // call the registerUser function of FirestoreClass to make an entry in the database.
                            FirestoreClass().registerUser(this@RegisterActivity, user)
                        } else {
                            Toast.makeText(
                                this@RegisterActivity,
                                task.exception!!.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    })
        }


    }

    private fun validateForm(name: String, email: String, password: String): Boolean {
        return when {
            TextUtils.isEmpty(name) -> {
                showErrorSnackBar("Please enter name.")
                false
            }
            TextUtils.isEmpty(email) -> {
                showErrorSnackBar("Please enter email.")
                false
            }
            TextUtils.isEmpty(password) -> {
                showErrorSnackBar("Please enter password.")
                false
            }
            else -> {
                true
            }
        }
    }

    fun userRegisteredSuccess() {

        Toast.makeText(
            this@RegisterActivity,
            "You have successfully registered.",
            Toast.LENGTH_SHORT
        ).show()

        hideProgressDialog()

        FirebaseAuth.getInstance().signOut()
        // Finish the Sign-Up Screen
        finish()
    }



}