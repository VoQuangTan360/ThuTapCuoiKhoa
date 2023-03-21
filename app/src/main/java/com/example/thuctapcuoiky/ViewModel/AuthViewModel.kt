package com.example.thuctapcuoiky.ViewModel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thuctapcuoiky.data.model.User
import com.example.thuctapcuoiky.data.repository.AuthRepository
import com.example.thuctapcuoiky.data.repository.CustomerRepository
import com.example.thuctapcuoiky.util.UiState
import com.fatherofapps.androidbase.data.database.entities.CustomerEntity

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    val repository: AuthRepository,
    private val customerRepository: CustomerRepository
): ViewModel() {
    val handler = CoroutineExceptionHandler { _, exception ->
//        parseErrorCallApi(exception)
    }
    private val _register = MutableLiveData<UiState<String>>()
    val register: LiveData<UiState<String>>
            get() = _register

    private val _login = MutableLiveData<UiState<String>>()
    val login: LiveData<UiState<String>>
        get() = _login

    private val _forgotPassword = MutableLiveData<UiState<String>>()
    val forgotPassword: LiveData<UiState<String>>
        get() = _forgotPassword

    fun createDataBaseLocall(customerEntity: CustomerEntity){
        var parentJob: Job? = null

         parentJob = viewModelScope.launch  (handler){
            customerRepository.creatercustomer(customerEntity)
        }
    }

    var customerEntity:CustomerEntity?=null



    fun register(
        email: String,
        password: String,
        user: User
    ) {
        _register.value = UiState.Loading
        repository.registerUser(
            email = email,
            password = password,
            user = user
        ) { _register.value = it }
    }

    fun login(
        email: String,
        password: String
    ) {
        _login.value = UiState.Loading
        repository.loginUser(
            email,
            password, result = {_login.value = it}
            ,resultUser =
            {
                if (it != null){
                    Log.d(TAG, "user firebase :$it")
                    Log.d(TAG, "co tao room")
                    createDataBaseLocall(
                        CustomerEntity(
                            it.id,
                            it.email,
                            it.first_name,
                            it.last_name,
                            it.job_title
                    ))
                }
//                {
//                    Log.d(TAG, "user firebase :$it")
//                    customerEntity?.id=it.id
//                    customerEntity?.email=it.email
//                    customerEntity?.first_name=it.first_name
//                    customerEntity?.last_name=it.last_name
//                    customerEntity?.job_title=it.job_title
//                    customerEntity?.let {
//                            it1 -> {createDataBaseLocall(it1)
//                                Log.d(TAG, "co tao room")
//                            }
//                    }
//                }
            }
        )
//        {
//            _login.value = it
//        }
            }


    fun forgotPassword(email: String) {
        _forgotPassword.value = UiState.Loading
        repository.forgotPassword(email){
            _forgotPassword.value = it
        }
    }

    fun logout(result: () -> Unit){
        repository.logout(result)
    }

    fun getSession(result: (User?) -> Unit){
        repository.getSession(result)
    }
}