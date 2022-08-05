package com.example.taskmanagement.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sign_up.*

class ListActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.taskmanagement.R.layout.activity_list)
        setUpListener()
    }

    private fun setUpListener() {
        uiIvBack.setOnClickListener {
            finish()
        }
    }
}
