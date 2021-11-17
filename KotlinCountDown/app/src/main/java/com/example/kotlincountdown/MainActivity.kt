package com.example.kotlincountdown

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.kotlincountdown.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        object:CountDownTimer(10000,1000){
            override fun onTick(p0: Long) {
                binding.textView.text="Left : ${p0/1000}"
            }

            override fun onFinish() {
                binding.textView.text="Finish"
            }

        }.start()

    }
}