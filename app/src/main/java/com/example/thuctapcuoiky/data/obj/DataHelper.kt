package com.example.thuctapcuoiky.data.obj

import com.example.thuctapcuoiky.R
import com.example.thuctapcuoiky.UI.Home.SearchFragment
import com.example.thuctapcuoiky.data.model.Search

object DataHelper {

    private var tagList = mutableListOf<String>()
    private var numberList = mutableListOf<String>()

    fun initResources(fragment: SearchFragment) {
        fragment.resources?.getStringArray(R.array.tag)?.toList()?.let {
            tagList.addAll(it)
        }
        fragment.resources?.getStringArray(R.array.numberPost)?.toList()?.let {
            numberList.addAll(it)
        }
    }

    fun getItem(): List<Search> =
        listOf(
            Search.Tag(tagList.random(), numberList.random()),
            Search.Tag(tagList.random(), numberList.random()),
            Search.Tag(tagList.random(), numberList.random()),
            Search.Tag(tagList.random(), numberList.random()),
            Search.Tag(tagList.random(), numberList.random()),
            Search.Tag(tagList.random(), numberList.random()),
            Search.Tag(tagList.random(), numberList.random()),
            Search.Tag(tagList.random(), numberList.random()),
            Search.Tag(tagList.random(), numberList.random()),
            Search.Tag(tagList.random(), numberList.random()),
            Search.Tag(tagList.random(), numberList.random()),
            Search.Tag(tagList.random(), numberList.random()),
            )

}
