package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.login.databinding.ActivityLoginBinding
import com.example.login.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class signup : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var firebaseauth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseauth = FirebaseAuth.getInstance()
        binding.signupRedirect.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }
        binding.singnupButton.setOnClickListener {
            val email = binding.signupEmail.text.toString()
            val pass = binding.signupPassword.text.toString()
            val name = binding.signupName.text.toString()
            val confirmpass = binding.signupConfirmpassword.text.toString()
            if (email.isNotEmpty() && pass.isNotEmpty() && confirmpass.isNotEmpty() && name.isNotEmpty()) {
                if (pass == confirmpass) {


                    firebaseauth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this, login::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }

                } else {
                    Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Empty fields are not allowed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
