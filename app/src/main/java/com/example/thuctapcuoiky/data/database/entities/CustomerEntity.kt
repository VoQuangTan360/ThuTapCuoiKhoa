package com.fatherofapps.androidbase.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customer")
data class CustomerEntity (@PrimaryKey
                           var id: String,
                           var first_name: String,
                           var last_name: String,
                           var job_title: String,
                           var email: String,)