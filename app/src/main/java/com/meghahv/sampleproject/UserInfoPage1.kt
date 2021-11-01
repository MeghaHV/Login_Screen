package com.meghahv.sampleproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.datepicker.MaterialDatePicker

class UserInfoPage1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info_page1)
    }

    fun UserInfoPage2(view: View) {
        startActivity(Intent(this@UserInfoPage1,UserInfoPage2::class.java))

    }
}