package com.example.thuctapcuoiky.ViewModel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thuctapcuoiky.data.model.User
import com.example.thuctapcuoiky.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddProductViewModel @Inject constructor(

): ViewModel(){
    private val _category = MutableLiveData<String>()
    val category: LiveData<String> get() = _category

    val selected_category = MutableLiveData<String>()

    fun SelectCategory(item: String) {
        selected_category.value = item
    }

    val selected_currency = MutableLiveData<String>()

    fun SelectCurrency(item: String) {
        selected_currency.value = item
    }

}


