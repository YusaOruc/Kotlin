package com.example.kotlinrunnables

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.example.kotlinrunnables.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var number=0
    var runnable:Runnable= Runnable {  }
    var handler:Handler= Handler()

    var startClick=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
    fun start(view:View){
        if(startClick==0){
            runnable=object :Runnable{
                override fun run() {
                    number=number+1
                    binding.textView.text="Time : $number"

                    handler.postDelayed(this,1000)
                }

            }
            handler.post(runnable)
            startClick=1
        }


    }
    fun stop(view:View){
        startClick=0
        handler.removeCallbacks(runnable)

        binding.textView.text="Time : $number"

    }
    fun reset(view:View){
        startClick=0
        number=0
        binding.textView.text="Time : $number"

    }
}