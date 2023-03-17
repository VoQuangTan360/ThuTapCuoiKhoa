package com.example.thuctapcuoiky.UI.Auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.core.widget.doAfterTextChanged
import com.example.thuctapcuoiky.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(LayoutInflater.from(this@LoginActivity))
        setContentView(binding.root)
        handleListener()
    }

    private fun handleListener() {
        binding.apply {
            edtEmail.doAfterTextChanged {

            }
            edtPassword.doAfterTextChanged {

            }
            tvRegister.setOnClickListener {
                navigationActivity()
            }
        }
    }

    private fun navigationActivity() {
        val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
        startActivity(intent)
    }
}