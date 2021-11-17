package com.example.kotlinretrofitip.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinretrofitip.Model.CryptoModel
import com.example.kotlinretrofitip.R
import com.example.kotlinretrofitip.Service.CryptoAPI
import com.example.kotlinretrofitip.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    //https://raw.githubusercontent.com/atilsamancioglu/K21-JSONDataSet/master/crypto.json
    //API key: fc91e1c5714112bbfb7cf0b22d50649456db65d0
    //https://api.nomics.com/v1/prices?key=fc91e1c5714112bbfb7cf0b22d50649456db65d0

    private lateinit var binding: ActivityMainBinding
    private val BASE_URL="https://api.nomics.com/v1/"
    private var cryptoModels:ArrayList<CryptoModel>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        loadData()

    }
    private fun loadData(){
        val retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service=retrofit.create(CryptoAPI::class.java)
        val call=service.getData()

        call.enqueue(object :Callback<List<CryptoModel>>{
            override fun onResponse(
                call: Call<List<CryptoModel>>,
                response: Response<List<CryptoModel>>
            ) {
                if(response.isSuccessful){
                    response.body()?.let {
                        cryptoModels=ArrayList(it)

                        for (cryptoModel:CryptoModel in cryptoModels!!){
                            println(cryptoModel.currency)
                            println(cryptoModel.price)}
                    }
                }

            }

            override fun onFailure(call: Call<List<CryptoModel>>, t: Throwable) {

                t.printStackTrace()

            }

        })
    }











}