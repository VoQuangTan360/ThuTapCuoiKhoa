package com.example.thuctapcuoiky.UI.Home

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thuctapcuoiky.data.adapter.SearchAdapter
import com.example.thuctapcuoiky.data.divider.SpacesItemDecoration
import com.example.thuctapcuoiky.data.model.Search
import com.example.thuctapcuoiky.data.obj.DataHelper
import com.example.thuctapcuoiky.databinding.FragmentSearchBinding
@SuppressLint("NotifyDataSetChanged")
class SearchFragment: Fragment() {
    companion object {
        private const val LOADING_TIME = 1000L
    }
    private lateinit var adaptersearchAdapter: SearchAdapter

    lateinit var binding: FragmentSearchBinding
    private var isLoading = false
    private val dataItem = mutableListOf<Search>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataHelper.initResources(this)
        initData(binding.searchBar.text.toString())


        binding.searchIcon.setOnClickListener{
//            initData(binding.searchBar.text.toString())
            addDataFromDatabase(binding.searchBar.text.toString())
            initScrollListener(binding.searchBar.text.toString())
            initUserAdapter(binding.searchBar.text.toString())
        }
    }

    private fun initData(text: String) {
        Log.d(TAG,text)
        addDataFromDatabase(text)
        addItemDecoration()
        initScrollListener(text)
        initUserAdapter(text)
    }

    private fun addItemDecoration() = binding.recyclerViewTags.addItemDecoration(SpacesItemDecoration(this))



    private fun addDataFromDatabase(text:String) {
//        dataItem.addAll(DataHelper.getItem())
            dataItem.clear()
            dataItem.addAll(DataHelper.getdata(text))
    }

    private fun initUserAdapter(text: String) {
        binding.recyclerViewTags.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//            addItemDecoration()
            adapter = SearchAdapter(
                getUser()
            )
            adaptersearchAdapter=SearchAdapter()
            adaptersearchAdapter.onItemOnclick={
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(com.example.thuctapcuoiky.R.id.fragment_container,SearchFragment()).commit()
            }
            initScrollListener(text)
        }
    }


    private fun getUser(): List<Search> = dataItem

    private fun loadMore(text: String) {
        binding.apply {
            progressBar.visibility = View.VISIBLE
            Handler(Looper.getMainLooper()).postDelayed({
                progressBar.visibility = View.INVISIBLE
                addDataFromDatabase(text)
                recyclerViewTags.adapter?.notifyDataSetChanged()
            }, LOADING_TIME)
        }
    }

    private fun initScrollListener(text: String) {
        binding.recyclerViewTags.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val linearLayoutManager = recyclerView.layoutManager
                if (!isLoading && linearLayoutManager is LinearLayoutManager
                    && linearLayoutManager.findLastCompletelyVisibleItemPosition() == dataItem.size - 1
                ) {
                    loadMore(text)
                    isLoading = true
                }
            }
        })
    }


}




