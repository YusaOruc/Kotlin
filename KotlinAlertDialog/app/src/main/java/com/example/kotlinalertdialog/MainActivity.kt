package com.example.kotlinalertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.kotlinalertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Toast.makeText(applicationContext,"Welcome",Toast.LENGTH_LONG).show()
    }
    fun save(view:View){
        val alert=android.app.AlertDialog.Builder(this)
        alert.setTitle("SAVE")
        alert.setMessage("Are you sure ?")
        alert.setPositiveButton("Yes"){dialog,which ->
            Toast.makeText(applicationContext,"Saved",Toast.LENGTH_LONG).show()
        }
        alert.setNegativeButton("No"){dialog,which ->
            Toast.makeText(applicationContext,"Not saved",Toast.LENGTH_LONG).show()
        }
        alert.show()
    }
}