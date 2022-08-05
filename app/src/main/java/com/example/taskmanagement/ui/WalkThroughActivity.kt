package com.example.taskmanagement.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_walkthrough.*

class WalkThroughActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.taskmanagement.R.layout.activity_walkthrough)
        setUpListener()
    }

    private fun setUpListener() {
        uiBtnNext.setOnClickListener {
            navigationMainActivity()
        }
    }

    private fun navigationMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}