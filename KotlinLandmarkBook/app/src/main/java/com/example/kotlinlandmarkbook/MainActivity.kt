package com.example.kotlinlandmarkbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinlandmarkbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var landmarkList:ArrayList<Landmark>

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Array()


        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        val landmarkAdapter=LandmarkAdapter(landmarkList)
        binding.recyclerView.adapter=landmarkAdapter
        /*
        //Adapter
        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarkList.map { landmark -> landmark.name })
        binding.listView.adapter=adapter

        //Intent(Veri Aktarimi)
        binding.listView.onItemClickListener=AdapterView.OnItemClickListener { adapterView, view, i, l ->

            val intent=Intent(MainActivity@this,DetailsActivity::class.java)
            intent.putExtra("landmark",landmarkList.get(i))
            startActivity(intent)


        }
        */


    }
    fun Array(){
        landmarkList= ArrayList<Landmark>()

        val pisa=Landmark("Pisa","Italy",R.drawable.pisa)
        val eyfel=Landmark("Eyfel","Fransa",R.drawable.eyfel)
        val colosseum=Landmark("Colesseum","Italya",R.drawable.colosseum)
        val londonBridge=Landmark("London Bridge","UK",R.drawable.london)

        landmarkList.add(pisa)
        landmarkList.add(eyfel)
        landmarkList.add(colosseum)
        landmarkList.add(londonBridge)
    }
}




























