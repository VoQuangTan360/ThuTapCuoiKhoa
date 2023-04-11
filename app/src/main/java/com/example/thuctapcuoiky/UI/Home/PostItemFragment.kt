package com.example.thuctapcuoiky.UI.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.thuctapcuoiky.databinding.FragmentPostBinding
import com.example.thuctapcuoiky.databinding.FragmentPostItemBinding
import com.example.thuctapcuoiky.databinding.FragmentProfileBinding

class PostItemFragment: Fragment() {
    lateinit var binding: FragmentPostItemBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostItemBinding.inflate(layoutInflater)
        return binding.root



    }


}