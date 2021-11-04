package com.meghahv.loginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Matcher
import java.util.regex.Pattern

class UserInfoPage2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info_page2)
        val phoneNumber = findViewById<TextInputEditText>(R.id.login_phone_number)
        val phoneNumberLayout = findViewById<TextInputLayout>(R.id.layout_phone_number)
        val password = findViewById<TextInputEditText>(R.id.login_password)
        val passwordLayout = findViewById<TextInputLayout>(R.id.layout_password)
        val cpassword = findViewById<TextInputEditText>(R.id.confirm_pw_login)
        val cpasswordLayout = findViewById<TextInputLayout>(R.id.confirm_pw_layout)
        val email = findViewById<TextInputEditText>(R.id.input_email)
        val emailLayout = findViewById<TextInputLayout>(R.id.layout_email)

        phoneNumber.addTextChangedListener(object: TextWatcher {
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
                if(isValidPassword(password.text.toString())) {
                    passwordLayout.error = null
                }
                    else{
                        passwordLayout.error="Must contain a number[0-9] and a letter[a-z]"
                    }

                }
            })

        cpassword.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun afterTextChanged(p0: Editable?) {
                if(password.getText().toString().equals(cpassword.getText().toString())){
                    cpasswordLayout.error = null
                }
                else{
                    cpasswordLayout.error="Password doesn't match"
                }

            }
        })

        email.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun afterTextChanged(p0: Editable?) {
                if (Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()){
                    emailLayout.error = null
                }
                else{
                    emailLayout.error="Invalid e-mail"
                }

            }
        })
    }


    private fun phoneValidate(text: String?): Boolean{
        val p : Pattern = Pattern.compile("[6-9][0-9]{9}")
        val m : Matcher = p.matcher(text)
        return m.matches()
    }
    private fun isValidPassword(password: String?) : Boolean {
        password?.let {
            val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,}$"
            val passwordMatcher = Regex(passwordPattern)

            return passwordMatcher.find(password) != null
        } ?: return false
    }

    fun AccountCreatedPage(view: View) {
        startActivity(Intent(this@UserInfoPage2,AccountCreatedPage::class.java))

    }
}