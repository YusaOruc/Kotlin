package com.example.fragment

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.navigation.Navigation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //inflater
        val menuInflater=menuInflater
        menuInflater.inflate(R.menu.add_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.add_item){
            //val action=FirstFragmentDirections.actionFirstFragmentToSecondFragment()
            //val a=findViewById<View>(R.id.firstFragmentId)
            //Navigation.findNavController(a).navigate(action)
            val action=FirstFragmentDirections.actionFirstFragmentToSecondFragment()
            Navigation.findNavController(this,R.id.firstFragmentId).navigate(action)
        }
        if(item.itemId==R.id.back_item){
            val action=SecondFragmentDirections.actionSecondFragmentToFirstFragment()

            Navigation.findNavController(this,R.id.secondFragmentId).navigate(action)
        }
        return super.onOptionsItemSelected(item)
    }
}