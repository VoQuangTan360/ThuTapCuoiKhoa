package com.example.thuctapcuoiky.UI.Search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.thuctapcuoiky.R
import com.example.thuctapcuoiky.databinding.FragmentAddProductBinding
import com.example.thuctapcuoiky.databinding.FragmentSearch2Binding


class SearchFragment : Fragment() {


    lateinit var binding: FragmentSearch2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearch2Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtDetalls.text="Lý Cư Sỹ"
        Glide.with(binding.root)
            .load("https://vcdn.tikicdn.com/media/catalog/product/i/m/img004_18.jpg").into(binding.imageReview);
    }


    }