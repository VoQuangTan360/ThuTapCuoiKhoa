package com.example.thuctapcuoiky

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.core.widget.doAfterTextChanged
import com.example.thuctapcuoiky.databinding.ActivityLoginBinding
import com.example.thuctapcuoiky.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(LayoutInflater.from(this@RegisterActivity))
        setContentView(binding.root)
        handleListener()
    }

    private fun handleListener() {
        binding.apply {
            tvLogin.setOnClickListener {
                navigationActivity()
            }
        }
    }

    private fun navigationActivity() {
        val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
        startActivity(intent)
    }
}
