package com.example.thuctapcuoiky.UI.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.thuctapcuoiky.R
import com.example.thuctapcuoiky.ViewModel.AddProductViewModel
import com.example.thuctapcuoiky.databinding.FragmentDialogCategoryBinding
import com.example.thuctapcuoiky.databinding.FragmentLayoutDailogBinding
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DialogCategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class DialogCategoryFragment : DialogFragment() {
    val viewModel: AddProductViewModel by viewModels()
    lateinit var model: AddProductViewModel
    lateinit var binding: FragmentDialogCategoryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDialogCategoryBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model = ViewModelProvider(requireActivity()).get(AddProductViewModel::class.java)



        binding.addProduct12.setOnClickListener {
            model.SelectCategory("Sandals")
            dismiss()
        }
        binding.choose11.setOnClickListener {
            model.SelectCategory("Running Shoes")
            dismiss()
        }
        binding.choose12.setOnClickListener {
            model.SelectCategory("Walking Shoes")
            dismiss()
        }
        binding.addProduct123.setOnClickListener {
            model.SelectCategory("Busuness Shoes")
            dismiss()
        }

    }
}