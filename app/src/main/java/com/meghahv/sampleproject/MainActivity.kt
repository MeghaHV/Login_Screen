package com.meghahv.sampleproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //test run

    }
    fun callLoginScreen(view: View) {
        startActivity(Intent(this@MainActivity,LoginScreen::class.java))

    }

    fun UserInfoPage1(view: View) {
        startActivity(Intent(this@MainActivity,UserInfoPage1::class.java))

    }
}