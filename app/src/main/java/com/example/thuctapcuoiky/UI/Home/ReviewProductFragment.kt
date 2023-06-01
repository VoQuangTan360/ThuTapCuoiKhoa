package com.example.thuctapcuoiky.UI.Home

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.thuctapcuoiky.R
import com.example.thuctapcuoiky.ViewModel.AddProductViewModel
import com.example.thuctapcuoiky.databinding.FragmentHomeBinding
import com.example.thuctapcuoiky.databinding.FragmentReviewProductBinding
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ReviewProductFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class ReviewProductFragment : Fragment() {


    lateinit var binding: FragmentReviewProductBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReviewProductBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val model = ViewModelProvider(requireActivity()).get(AddProductViewModel::class.java)
        model.Pricing.observe(viewLifecycleOwner, Observer {
            binding.money.text = "$"+it
        })
        model.Stock.observe(viewLifecycleOwner, Observer {
            binding.number.text = it
        })

        binding.up.setOnClickListener{

            var text =binding.number.text.toString()
            var number=text.toInt()+1
            model.SetStock(number.toString())
        }
        binding.down.setOnClickListener{

            var text =binding.number.text.toString()
            var number=text.toInt()-1
            model.SetStock(number.toString())
        }
        binding.btnContinue.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(com.example.thuctapcuoiky.R.id.fragment_container,HomeFragment()).commit()

        }


    }

}