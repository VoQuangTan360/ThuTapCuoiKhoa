package com.fatherofapps.androidbase.data.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fatherofapps.androidbase.data.database.entities.CustomerEntity

@Dao
interface CustomerDao {


    @Query("select * from customer")
    suspend fun getUser(): CustomerEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(customerEntity: CustomerEntity)


}