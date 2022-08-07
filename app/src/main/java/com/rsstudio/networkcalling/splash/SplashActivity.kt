package com.rsstudio.networkcalling.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.databinding.DataBindingUtil
import com.rsstudio.networkcalling.R
import com.rsstudio.networkcalling.databinding.ActivitySplashBinding
import com.rsstudio.networkcalling.main.MainActivity

class SplashActivity : AppCompatActivity() {


    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        //
        initTheme()
        gotoMainActivity()
    }

    private fun initTheme() {
        window.statusBarColor = resources.getColor(R.color.Black)
        window.navigationBarColor = resources.getColor(R.color.lightBlack)
    }

    private fun gotoMainActivity() {
        Handler(Looper.getMainLooper()).postDelayed(
            Runnable {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, 500
        )
    }
}