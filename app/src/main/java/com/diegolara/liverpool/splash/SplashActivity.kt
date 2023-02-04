package com.diegolara.liverpool.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.diegolara.liverpool.databinding.ActivitySplashBinding
import com.diegolara.liverpool.main.presentation.MainActivity

class SplashActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    //region Override Methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 700)
    }

    //endregion
}