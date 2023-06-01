package com.example.thuctapcuoiky.UI.Auth

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.LifecycleObserver
import com.example.firebasewithmvvm.util.toast
import com.example.thuctapcuoiky.ViewModel.AuthViewModel
import com.example.thuctapcuoiky.data.model.User

import com.example.thuctapcuoiky.databinding.ActivityRegisterBinding
import com.example.thuctapcuoiky.util.MainActivityObserver
import com.example.thuctapcuoiky.util.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        observer()
        binding = ActivityRegisterBinding.inflate(LayoutInflater.from(this@RegisterActivity))
        setContentView(binding.root)
        handleListener()
    }

    private fun handleListener() {
        binding.apply {
            tvLogin.setOnClickListener {
                navigationActivity()
            }
            register.setOnClickListener {
                viewModel.register(
                    "thoa12345@gmail.com",
                    "123123",
                    getUserObj()
                )
            }

        }
    }
//    fun observer() {
//        viewModel.register.observe(view) { state ->
//            when(state){
//                is UiState.Loading -> {
//                }
//                is UiState.Failure -> {
//                    Toast.makeText(this@RegisterActivity,state.error, Toast.LENGTH_LONG).show()
//                }
//                is UiState.Success -> {
//                    Toast.makeText(this@RegisterActivity,"Thanh Cong", Toast.LENGTH_LONG).show()
//                }
//            }
//        }
//    }

    fun getUserObj(): User {
        return User(
            id = "",
            first_name = "tan",
            last_name = "vo",
            job_title = "voQuangTan",
            email = "thoa123@gmail.com",
        )
    }
    private fun navigationActivity() {
        val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
        startActivity(intent)
    }
}
