package com.bangkit.kukus.ui.login

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.kukus.R
import com.bangkit.kukus.data.remote.response.auth.User
import com.bangkit.kukus.databinding.ActivityLoginBinding
import com.bangkit.kukus.databinding.LoginBinding
import com.bangkit.kukus.firebase.BaseActivity
import com.bangkit.kukus.firebase.FirestoreClass
/*import com.bangkit.kukus.onboarding.AInputonboarding*/
import com.bangkit.kukus.onboarding.ActivityOnboarding
import com.bangkit.kukus.ui.home.MainActivity
import com.bangkit.kukus.ui.register.RegisterActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : BaseActivity(){

    private lateinit var binding: LoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = LoginBinding.inflate(layoutInflater);
        setContentView(binding.root)
        binding.tvLoginHighlined.setOnClickListener{
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener{
            signInRegisteredUser()
        }


        binding.guessMode?.setOnClickListener{
            guestMode()
        }

    }

    private fun guestMode() {
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
    }


    private fun signInRegisteredUser() {
        // Here we get the text from editText and trim the space
        val email: String = binding.etEmailLogin.text.toString().trim { it <= ' ' }
        val password: String = binding.etPasswordLogin.text.toString().trim { it <= ' ' }

        if (validateForm(email, password)) {
            // Show the progress dialog.
            showProgressDialog(resources.getString(R.string.please_wait))

            // Sign-In using FirebaseAuth
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Calling the FirestoreClass signInUser function to get the data of user from database.
                        FirestoreClass().signInUser(this@LoginActivity)
                    } else {
                        Toast.makeText(
                            this@LoginActivity,
                            task.exception!!.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
        }
    }

    private fun validateForm(email: String, password: String): Boolean {
        return if (TextUtils.isEmpty(email)) {
            showErrorSnackBar("Please enter email.")
            false
        } else if (TextUtils.isEmpty(password)) {
            showErrorSnackBar("Please enter password.")
            false
        } else {
            true
        }
    }

    fun signInSuccess(user: User) {
        hideProgressDialog()
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        this.finish()
    }
}