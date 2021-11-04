package com.meghahv.loginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import loginscreen.R
import java.util.regex.Matcher
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login_button = findViewById<MaterialButton>(R.id.login_button)
        val password = findViewById<TextInputEditText>(R.id.login_password)
        val passwordLayout = findViewById<TextInputLayout>(R.id.layout_password)
        val phoneNumber = findViewById<TextInputEditText>(R.id.login_phone_number)
        val phoneNumberLayout = findViewById<TextInputLayout>(R.id.layout_phone_number)

        phoneNumber.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun afterTextChanged(p0: Editable?) {

                if(phoneValidate(phoneNumber.text.toString())) {
                    phoneNumberLayout.error = null
                }
                else{
                    phoneNumberLayout.error = "Invalid phone number"
                }
            }
        })

        password.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun afterTextChanged(p0: Editable?) {

                if(passwordValidate(password.text.toString())) {
                    passwordLayout.error = null
                }
                else{
                    passwordLayout.error = "Invalid Password"
                }
            }
        })

        login_button.addTextChangedListener(object:TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                if (phoneValidate(phoneNumber.text.toString()) && passwordValidate(password.text.toString())) {
                    login_button.isEnabled = true
                }
            }
        })

        login_button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                if(phoneValidate(phoneNumber.text.toString()) && passwordValidate(password.text.toString()) ){
                    login_button.isEnabled = true
                    startActivity(Intent(this@MainActivity,LoginScreen::class.java))
                }
            }
        })

        if (phoneValidate(phoneNumber.text.toString()) && passwordValidate(password.text.toString())) {
            login_button.isEnabled = true
        }
    }


    private fun phoneValidate(text: String?): Boolean{
        val p : Pattern = Pattern.compile("[6-9][0-9]{9}")
        val m : Matcher = p.matcher(text)
        return m.matches()
    }
    private fun passwordValidate(text: String?): Boolean{
        return text!!.length>7
    }

//    fun callLoginScreen(view: View) {
//        startActivity(Intent(this@MainActivity,LoginScreen::class.java))
//
//    }

    fun UserInfoPage1(view: View) {
        startActivity(Intent(this@MainActivity,UserInfoPage1::class.java))
    }
}