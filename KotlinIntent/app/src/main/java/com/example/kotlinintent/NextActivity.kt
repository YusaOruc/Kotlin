package com.example.kotlinintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinintent.databinding.ActivityMainBinding
import com.example.kotlinintent.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNextBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNextBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //Get Intent
        val intent=intent
        val username=intent.getStringExtra("username")
        val password=intent.getStringExtra("password")

        binding.userNameNextText.text="User Name :"+username
        binding.passwordNextText.text="Password :" +password

    }
}