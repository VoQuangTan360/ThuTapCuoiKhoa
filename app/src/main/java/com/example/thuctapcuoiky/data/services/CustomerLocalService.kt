package com.example.thuctapcuoiky.data.services


import com.fatherofapps.androidbase.data.database.daos.CustomerDao
import com.fatherofapps.androidbase.data.database.entities.CustomerEntity
import javax.inject.Inject

class CustomerLocalService @Inject constructor(private val customerDao: CustomerDao) {
    suspend fun CreateCustomer(customerEntity: CustomerEntity){
        return customerDao.insert(customerEntity)
    }
    suspend fun getCustomer():CustomerEntity{
        return customerDao.getUser()
    }
}