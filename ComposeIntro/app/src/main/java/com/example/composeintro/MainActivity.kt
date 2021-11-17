package com.example.composeintro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeintro.Model.CryptoModel
import com.example.composeintro.Service.CryptoAPI
import com.example.composeintro.ui.theme.ComposeIntroTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Modifier

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeIntroTheme {
                // A surface container using the 'background' color from the theme
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {

    var cryptoModels=remember{ mutableStateListOf<CryptoModel>()}

    val BASE_URL="https://raw.githubusercontent.com/"
    val retrofit=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CryptoAPI::class.java)

    val call=retrofit.getData()
    call.enqueue(object :Callback<List<CryptoModel>>{
        override fun onResponse(
            call: Call<List<CryptoModel>>,
            response: Response<List<CryptoModel>>
        ) {
            if (response.isSuccessful){
                response.body()?.let {
                    cryptoModels.addAll(it)
                    
                }
            }
        }

        override fun onFailure(call: Call<List<CryptoModel>>, t: Throwable) {
            t.printStackTrace()
        }

    })

    Scaffold(topBar = {AppBar()}) {
        CryptoList(cryptos =cryptoModels )
    }

}
@Composable
fun AppBar(){
    TopAppBar(backgroundColor = Color.DarkGray,contentPadding = PaddingValues(10.dp)) {
        Text(text = "Retrofit Compose",color =Color.White,textAlign= TextAlign.Center,fontSize = 26.sp)
    }
}
@Composable
fun CryptoList(cryptos:List<CryptoModel>){
    LazyColumn(){
        items(cryptos){ crypto ->
            CryptoRow(crypto = crypto)
        }
    }
}
@Composable
fun CryptoRow(crypto:CryptoModel){
    Column() {
        Text(text = crypto.currency)
        Text(text = crypto.price)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    ComposeIntroTheme {
        MainScreen()
    }
}