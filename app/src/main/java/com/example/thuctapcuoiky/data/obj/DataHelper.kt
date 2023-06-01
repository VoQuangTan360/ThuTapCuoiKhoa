package com.example.thuctapcuoiky.data.obj

import android.content.ContentValues.TAG
import android.util.Log
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

    fun getdata( text:String ): List<Search> {


        var listOld=listOf(
            Search.Tag("Lịch sữ", "120","https://sachhaynendoc.net/wp-content/uploads/2019/03/bia-sach-1.jpg"),
            Search.Tag("Lý Cư Minh", "111","https://vcdn.tikicdn.com/media/catalog/product/i/m/img004_18.jpg"),
            Search.Tag("Trần Khánh Dư", "20","https://tse4.mm.bing.net/th?id=OIP.S7BiL37j6Qjm_r2JivAtDgHaLG&pid=Api&P=0"),
            Search.Tag("Hoá", "12","https://img2.thuthuat123.com/uploads/2019/11/19/bia-sach-dep-trai-hoa-do_122840555.jpg"),
            Search.Tag("Địa", "10","https://tuxtini.files.wordpress.com/2013/11/sc3a1ch-c491e1bb8ba-lc3bd-le1bb9bp-3-h1.jpg?w=593&h=798"),

            )
        Log.d(TAG,text)
        return if(text.isNotEmpty()){
            listOld.filter {  it.tag.startsWith(text)}
        } else{
            listOld
        }


    }

//    fun getItem(): List<Search> =
//        listOf(
//            Search.Tag(tagList.random(), numberList.random(),"https://sachhaynendoc.net/wp-content/uploads/2019/03/bia-sach-1.jpg"),
//
//            )

}
