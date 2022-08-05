package com.example.taskmanagement.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.taskmanagement.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setUpListener()
    }

    private fun setUpListener(){
        uiBtnSignIn.setOnClickListener {
            if (validateProfile()){
                onNavigationMainActivity()
            }
        }
        uiTvSignUp.setOnClickListener{
            onNavigationSignUpActivity()
        }
    }

    private fun validateProfile():Boolean{
        return if (uiEtUserName.text.isNullOrEmpty()){
            Toast.makeText(this, "Enter User Name", Toast.LENGTH_LONG).show()
            false
        } else if (uiEtPassword.text.isNullOrEmpty()) {
            Toast.makeText(this, "Enter Password", Toast.LENGTH_LONG).show()
            false
        } else true
    }

    private fun onNavigationMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun onNavigationSignUpActivity(){
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }
}