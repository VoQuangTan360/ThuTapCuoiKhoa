package com.example.thuctapcuoiky.UI

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.thuctapcuoiky.MainActivity
import com.example.thuctapcuoiky.R
import com.example.thuctapcuoiky.UI.Auth.LoginActivity

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }

        val thread: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(3000)
                    startActivity(Intent(this@StartActivity, MainActivity::class.java))
                    finish()
                } catch (e: Exception) {
                }
            }
        }
        thread.start()
    }
}
