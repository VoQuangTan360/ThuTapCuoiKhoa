package com.example.thuctapcuoiky.UI.Home


import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent

import android.graphics.Bitmap
import android.net.Uri
import android.nfc.Tag
import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.nearmekotlindemo.permissions.AppPermissions
import com.example.thuctapcuoiky.R
import com.example.thuctapcuoiky.ViewModel.AddProductViewModel
import com.example.thuctapcuoiky.ViewModel.AuthViewModel
import com.example.thuctapcuoiky.databinding.FragmentAddProductBinding
import com.google.android.material.snackbar.Snackbar

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddProductFragment : Fragment() {

    val viewModel: AddProductViewModel by viewModels()


    var mBitmap: Bitmap? = null
    val permission = 1

    private var image: Uri? = null
    private var permissionToRequest = mutableListOf<String>()
    private lateinit var appPermissions: AppPermissions
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>
    lateinit var binding: FragmentAddProductBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        binding = FragmentAddProductBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel.category.observe(viewLifecycleOwner, Observer { item ->
//            binding.textCategory.text=item
//            Log.d("dfg","chay chay chay"+item)
//        })
//        binding.textCategory.text=viewModel.selected_category.value
//        viewModel.selected_category.observe(viewLifecycleOwner) {
//                binding.textCategory.text=it
//
//        }
        val model = ViewModelProvider(requireActivity()).get(AddProductViewModel::class.java)
        model.selected_category.observe(viewLifecycleOwner, Observer {
            binding.textCategory.text = it
        })

        model.selected_currency.observe(viewLifecycleOwner, Observer {
            binding.TextCurrency.text = it
        })


        binding.choosePicGall.setOnClickListener{

            pickImageFromGallery()
            binding.imagedemo.visibility = View.VISIBLE



        }

        binding.selectDialog.setOnClickListener {

            viewModel.category.observe(viewLifecycleOwner) {
                binding.textCategory.text=it
                Log.d(TAG,"check chay viewLifecycleOwner "+viewModel.category.value)

            }
            openDialogchooseCategory()
            Log.d(TAG,"check chay viewLifecycleOwner "+viewModel.category.value)
            Log.d(TAG,"check data category "+viewModel.category.value )

        }
        binding.selectDialogCurrency.setOnClickListener {
            openDialogchooseCurrenency()
        }
        binding.btnContinue.setOnClickListener {

            model.SetPricing(binding.money.text.toString())
            model.SetStock(binding.stock.text.toString())
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(com.example.thuctapcuoiky.R.id.fragment_container,ReviewProductFragment()).commit()

        }


    }

    private fun openDialogchooseCategory() {
        val  dialog= DialogCategoryFragment()
        dialog.show((activity as AppCompatActivity).supportFragmentManager,"show dialog")
    }
    private fun openDialogchooseCurrenency() {
        val  dialog= DialogCurrencyFragment()
        dialog.show((activity as AppCompatActivity).supportFragmentManager,"show dialog")
    }



    private fun  pickImage() {

    }
    private fun pickImageFromGallery() {
        //Intent to pick image
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }



    companion object {
        //image pick code
        private val IMAGE_PICK_CODE = 1000;
        //Permission code
        private val PERMISSION_CODE = 1001;
    }






}