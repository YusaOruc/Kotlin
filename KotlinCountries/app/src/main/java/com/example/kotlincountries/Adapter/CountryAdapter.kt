package com.example.kotlincountries.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincountries.R
import com.example.kotlincountries.databinding.ItemCountryBinding
import com.example.kotlincountries.model.Country
import com.example.kotlincountries.util.downloadFromUrl
import com.example.kotlincountries.util.placeholderProgressBar
import com.example.kotlincountries.view.FeedFragmentDirections

class CountryAdapter(val countryList:ArrayList<Country>):RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(val binding: ItemCountryBinding):RecyclerView.ViewHolder(binding.root){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        /*val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.item_country,parent,false)
        return CountryViewHolder(view)*/
        //val binding =ItemCountryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        //return CountryViewHolder(binding)
        val inflater=LayoutInflater.from(parent.context)
        val binding=DataBindingUtil.inflate<ItemCountryBinding>(inflater,R.layout.item_country,parent,false)
        return CountryViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        holder.binding.country=countryList[position]


        /*-holder.binding.name.text=countryList[position].countryName
        holder.binding.region.text=countryList[position].countryRegion
        holder.binding.imageView.downloadFromUrl(countryList[position].imageUrl,
            placeholderProgressBar(holder.binding.imageView.context))
        */
        holder.itemView.setOnClickListener{
            val action=FeedFragmentDirections.actionFeedFragmentToCountryFragment()
            action.countryUuid=countryList[position].uuid

            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return countryList.size
    }
    fun updateCountryList(newCountryList:List<Country>){
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }




}











