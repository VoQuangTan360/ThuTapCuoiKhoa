package com.example.thuctapcuoiky.UI.Home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.example.thuctapcuoiky.R
import com.example.thuctapcuoiky.databinding.ActivityHomeBinding
import com.example.thuctapcuoiky.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class  HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())
        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_home->replaceFragment(HomeFragment())
                R.id.nav_search->replaceFragment(SearchFragment())
                R.id.nav_add->replaceFragment(NotificationFragment())
                R.id.nav_heart->replaceFragment(PostFragment())
                R.id.nav_profile->replaceFragment(ProfileFragment())

                else ->{
                    replaceFragment(HomeFragment())
                }
            }

            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentMa =supportFragmentManager
        val fragmentransaction= fragmentMa.beginTransaction()
        fragmentransaction.replace(R.id.fragment_container,fragment)
        fragmentransaction.commit()
    }
}