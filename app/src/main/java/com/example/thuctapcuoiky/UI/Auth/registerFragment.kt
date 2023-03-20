package com.example.thuctapcuoiky.UI.Auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.firebasewithmvvm.util.isValidEmail
import com.example.firebasewithmvvm.util.toast
import com.example.thuctapcuoiky.R
import com.example.thuctapcuoiky.ViewModel.AuthViewModel
import com.example.thuctapcuoiky.data.model.User
import com.example.thuctapcuoiky.databinding.FragmentLoginBinding
import com.example.thuctapcuoiky.databinding.FragmentRegisterBinding
import com.example.thuctapcuoiky.util.UiState
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [registerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

@AndroidEntryPoint
class registerFragment : Fragment() {
    val TAG: String = "RegisterFragment"
    lateinit var binding: FragmentRegisterBinding
    val viewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observer()
        binding.register.setOnClickListener {
            if (validation()) {
                viewModel.register(
                    email = binding.email.text.toString(),
                    password = binding.password.text.toString(),
                    getUserObj()
                )
            }
        }

        binding.tvLogin.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }

    fun observer(){
        viewModel.register.observe(viewLifecycleOwner) { state ->
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
    fun validation(): Boolean {
        var isValid = true

        if (binding.email.text.isNullOrEmpty()){
            isValid = false
            toast(getString(R.string.enter_email))
        }else{
            if (!binding.email.text.toString().isValidEmail()){
                isValid = false
                toast(getString(R.string.invalid_email))
            }
        }
        if (binding.password.text.isNullOrEmpty()){
            isValid = false
            toast(getString(R.string.enter_password))
        }else{
            if (binding.password.text.toString().length < 8){
                isValid = false
                toast(getString(R.string.invalid_password))
            }
        }
        return isValid
    }

    fun getUserObj(): User {
        return User(
            id = "",
            first_name = "tan",
            last_name = "vo",
            job_title = "voQuangTan",
            email = "thoa123@gmail.com",
        )
    }


}