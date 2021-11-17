package com.example.kotlincatchthekenny

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.kotlincatchthekenny.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random as Random1

class MainActivity : AppCompatActivity() {
    var score=0
    var imageArray=ArrayList<ImageView>()

    var handler:Handler= Handler()
    var runnable:Runnable= Runnable {  }

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //ImageView
        imageArray.add(binding.imageView)
        imageArray.add(binding.imageView1)
        imageArray.add(binding.imageView2)
        imageArray.add(binding.imageView3)
        imageArray.add(binding.imageView4)
        imageArray.add(binding.imageView5)
        imageArray.add(binding.imageView6)
        imageArray.add(binding.imageView7)
        imageArray.add(binding.imageView8)
        hideImage()

        //CounterDown
        object :CountDownTimer(15000,1000){
            override fun onTick(p0: Long) {
                binding.timeText.text="Time : "+p0/1000
            }

            override fun onFinish() {
                binding.timeText.text="Time Over "

                handler.removeCallbacks(runnable)
                invizible()

                //Alert
                val alert=AlertDialog.Builder(this@MainActivity)

                alert.setTitle("Game Over")
                alert.setMessage("Do you want play again ?")
                alert.setPositiveButton("Yes"){dialog,which->
                    val intent=intent
                    finish()
                    startActivity(intent)
                }
                alert.setNegativeButton("No"){dialog,which->
                    Toast.makeText(this@MainActivity,"Game Over",Toast.LENGTH_LONG).show()
                }
                alert.show()
            }

        }.start()
    }
    fun hideImage(){
        runnable=object :Runnable{
            override fun run() {
                invizible()
                var random= Random()
                var randomIndex=random.nextInt(9)
                imageArray[randomIndex].visibility=View.VISIBLE

                handler.postDelayed(runnable,500)
            }

        }
        handler.post(runnable)

    }
    fun invizible(){
        for (imageView in imageArray){
            imageView.visibility=View.INVISIBLE
        }
    }

    fun increanseScore(view:View){
        score=score+1
        binding.scoreText.text="Score: ${score}"
    }
}









