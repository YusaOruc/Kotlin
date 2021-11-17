package com.example.kotlinintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kotlinintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun next(view:View){
        val intent=Intent(applicationContext,NextActivity::class.java)

        intent.putExtra("username",binding.userNameText.text.toString())
        intent.putExtra("password",binding.passwordText.text.toString())
        startActivity(intent)
    }
}