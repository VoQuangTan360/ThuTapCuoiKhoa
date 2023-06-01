package com.example.thuctapcuoiky.UI.Home

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.thuctapcuoiky.ViewModel.AddProductViewModel
import com.example.thuctapcuoiky.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.addProduct.setOnClickListener{
            Log.d(ContentValues.TAG,"co chay")
            openDialog()
        }

    }

    private fun openDialog() {
       val  dialog= DialogFragmentshow()
        dialog.show((activity as AppCompatActivity).supportFragmentManager,"show dialog")
    }


}