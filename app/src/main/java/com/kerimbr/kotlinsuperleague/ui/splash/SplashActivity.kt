package com.kerimbr.kotlinsuperleague.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.airbnb.lottie.LottieDrawable
import com.kerimbr.kotlinsuperleague.core.SPLASH_SCREEN_DELAY
import com.kerimbr.kotlinsuperleague.databinding.ActivitySplashBinding
import com.kerimbr.kotlinsuperleague.ui.base.BaseActivity
import com.kerimbr.kotlinsuperleague.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : BaseActivity() {

    private lateinit var binding : ActivitySplashBinding

    override fun initBinding() {
        binding = ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.splashAnimation.playAnimation()
        binding.splashAnimation.repeatCount = LottieDrawable.INFINITE
        navigateToApp()
    }

    private fun navigateToApp() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_SCREEN_DELAY)
    }

}