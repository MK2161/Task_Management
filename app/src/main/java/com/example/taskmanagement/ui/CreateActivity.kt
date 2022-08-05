package com.example.taskmanagement.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_create.*

class CreateActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.taskmanagement.R.layout.activity_create)
        setUpListener()
    }

    private fun setUpListener() {
        uiIvClose.setOnClickListener {
            finish()
        }
    }
}