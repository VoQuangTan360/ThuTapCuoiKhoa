package com.example.thuctapcuoiky.data.repository

import com.example.thuctapcuoiky.data.services.CustomerLocalService
import com.example.thuctapcuoiky.di.IoDispatcher
import com.fatherofapps.androidbase.data.database.entities.CustomerEntity

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CustomerRepository @Inject constructor(

    private val customerLocalService: CustomerLocalService,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) {
    suspend fun creatercustomer(customerEntity: CustomerEntity)= withContext(dispatcher){
        customerLocalService.CreateCustomer(customerEntity)
    }

    suspend fun getcustomer()= withContext(dispatcher){
        customerLocalService.getCustomer()
    }
}