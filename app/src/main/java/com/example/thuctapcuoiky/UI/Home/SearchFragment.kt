package com.example.thuctapcuoiky.UI.Home

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
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
        initData()
    }

    private fun initData() {
        addDataFromDatabase()
        addItemDecoration()
        initScrollListener()
        initUserAdapter()
    }

    private fun addItemDecoration() = binding.recyclerViewTags.addItemDecoration(SpacesItemDecoration(this))

    private fun addDataFromDatabase() {
        dataItem.addAll(DataHelper.getItem())
    }

    private fun initUserAdapter() {
        binding.recyclerViewTags.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            addItemDecoration()
            adapter = SearchAdapter(
                getUser()
            )
            initScrollListener()
        }
    }

    private fun getUser(): List<Search> = dataItem

    private fun loadMore() {
        binding.apply {
            progressBar.visibility = View.VISIBLE
            Handler(Looper.getMainLooper()).postDelayed({
                progressBar.visibility = View.INVISIBLE
                addDataFromDatabase()
                recyclerViewTags.adapter?.notifyDataSetChanged()
            }, LOADING_TIME)
        }
    }

    private fun initScrollListener() {
        binding.recyclerViewTags.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val linearLayoutManager = recyclerView.layoutManager
                if (!isLoading && linearLayoutManager is LinearLayoutManager
                    && linearLayoutManager.findLastCompletelyVisibleItemPosition() == dataItem.size - 1
                ) {
                    loadMore()
                    isLoading = true
                }
            }
        })
    }

}




