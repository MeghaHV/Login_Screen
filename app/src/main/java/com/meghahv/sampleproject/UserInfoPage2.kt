package com.meghahv.sampleproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class UserInfoPage2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info_page2)
    }

    fun AccountCreatedPage(view: View) {
        startActivity(Intent(this@UserInfoPage2,AccountCreatedPage::class.java))

    }
}