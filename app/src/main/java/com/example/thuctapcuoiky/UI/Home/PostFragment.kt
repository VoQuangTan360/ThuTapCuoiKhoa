package com.example.thuctapcuoiky.UI.Home

import android.R
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

import com.example.thuctapcuoiky.databinding.FragmentPostBinding


class PostFragment: Fragment() {
    lateinit var binding: FragmentPostBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostBinding.inflate(layoutInflater)
        return binding.root



    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageAdded.setOnClickListener {

        }
        binding.post.setOnClickListener{
            Log.d(TAG,"co chay")
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(com.example.thuctapcuoiky.R.id.fragment_container,PostItemFragment()).commit()


//            val fragment: Fragment = PostItemFragment()
//            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
//            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
//            fragmentTransaction.replace(com.example.thuctapcuoiky.R.id.fragment_container, fragment)
////            fragmentTransaction.addToBackStack(null)
//            fragmentTransaction.commit()

        }
    }

}