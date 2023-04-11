package com.example.thuctapcuoiky.UI.Home

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

import com.example.thuctapcuoiky.databinding.FragmentLayoutDailogBinding


class DialogFragmentshow: DialogFragment() {
    lateinit var binding: FragmentLayoutDailogBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLayoutDailogBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addProduct12.setOnClickListener {
            dismiss()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(com.example.thuctapcuoiky.R.id.fragment_container,AddProductFragment()).commit()

        }

    }
}