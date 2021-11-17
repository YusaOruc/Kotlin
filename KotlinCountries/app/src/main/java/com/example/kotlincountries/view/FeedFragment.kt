package com.example.kotlincountries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStores.of
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlincountries.Adapter.CountryAdapter
import com.example.kotlincountries.databinding.FragmentFeedBinding
import com.example.kotlincountries.viewmodel.FeedViewModel
import java.util.EnumSet.of


class FeedFragment : Fragment() {

    private lateinit var viewModel:FeedViewModel
    private val countryAdapter=CountryAdapter(arrayListOf())

    private lateinit var binding:FragmentFeedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFeedBinding.inflate(inflater,container,false)

        return binding.root
        //return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel=ViewModelProvider(this)[FeedViewModel::class.java]
        viewModel.refreshData()

        binding.countryList.layoutManager=LinearLayoutManager(context)
        binding.countryList.adapter=countryAdapter

        /*
        binding.fragmentButton.setOnClickListener{
            val action=FeedFragmentDirections.actionFeedFragmentToCountryFragment()
            Navigation.findNavController(it).navigate(action)
        }*/
        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.countryList.visibility=View.GONE
            binding.countryError.visibility=View.GONE
            binding.countryLoading.visibility=View.VISIBLE
            viewModel.refreshFromAPI()
            binding.swipeRefreshLayout.isRefreshing=false
        }
        observeLiveData()

    }
    private fun observeLiveData(){
        viewModel.countries.observe(viewLifecycleOwner, Observer { countries->
            countries?.let {
                binding.countryList.visibility=View.VISIBLE
                countryAdapter.updateCountryList(countries)
            }
        })
        viewModel.countryError.observe(viewLifecycleOwner, Observer { error->
            error?.let {
                if(it){
                    binding.countryError.visibility=View.VISIBLE
                }
                else{
                    binding.countryError.visibility=View.GONE
                }
            }
        })
        viewModel.countryLoading.observe(viewLifecycleOwner, Observer { loading->
            loading?.let {
                if(it){
                    binding.countryLoading.visibility=View.VISIBLE
                    binding.countryList.visibility=View.GONE
                    binding.countryError.visibility=View.GONE
                }else{
                    binding.countryLoading.visibility=View.GONE
                }
            }
        })
    }


}










