package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.content.Intent
import android.os.Looper


class splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, login::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}