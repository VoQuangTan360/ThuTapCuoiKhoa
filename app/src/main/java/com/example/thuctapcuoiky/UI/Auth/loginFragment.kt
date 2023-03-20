package com.example.thuctapcuoiky.UI.Auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.firebasewithmvvm.util.isValidEmail
import com.example.firebasewithmvvm.util.toast
import com.example.thuctapcuoiky.R
import com.example.thuctapcuoiky.ViewModel.AuthViewModel
import com.example.thuctapcuoiky.databinding.FragmentLoginBinding
import com.example.thuctapcuoiky.util.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class loginFragment : Fragment() {

    val TAG: String = "RegisterFragment"
    lateinit var binding: FragmentLoginBinding
    val viewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observer()
        binding.btnLogin.setOnClickListener {
            if (validation()) {
                viewModel.login(
                    email = binding.edtEmail.text.toString(),
                    password = binding.edtPassword.text.toString()
                )
            }
        }



        binding.tvRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }
    fun validation(): Boolean {
        var isValid = true

        if (binding.edtEmail.text.isNullOrEmpty()){
            isValid = false
            toast(getString(R.string.enter_email))
        }else{
            if (!binding.edtEmail.text.toString().isValidEmail()){
                isValid = false
                toast(getString(R.string.invalid_email))
            }
        }
        if (binding.edtPassword.text.isNullOrEmpty()){
            isValid = false
            toast(getString(R.string.enter_password))
        }else{
            if (binding.edtPassword.text.toString().length < 6){
                isValid = false
                toast(getString(R.string.invalid_password))
            }
        }
        return isValid
    }
    fun observer(){
        viewModel.login.observe(viewLifecycleOwner) { state ->
            when(state){
                is UiState.Loading -> {
                    Toast.makeText(context,"loading", Toast.LENGTH_LONG).show()
                }
                is UiState.Failure -> {
                    Toast.makeText(context,state.error, Toast.LENGTH_LONG).show()
                }
                is UiState.Success -> {
                    Toast.makeText(context,"thanh cong", Toast.LENGTH_LONG).show()
//                    findNavController().navigate(R.id.action_loginFragment_to_home_navigation)
                }
            }
        }
    }
}