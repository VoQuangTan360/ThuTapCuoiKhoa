package com.example.thuctapcuoiky.ViewModel

import androidx.lifecycle.ViewModel
import com.example.thuctapcuoiky.data.repository.AuthRepository
import com.example.thuctapcuoiky.data.repository.CustomerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DatabaseLocal @Inject constructor(
    private val customerRepository: CustomerRepository
): ViewModel(){

}


