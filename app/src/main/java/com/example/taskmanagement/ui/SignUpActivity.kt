package com.example.taskmanagement.ui

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.taskmanagement.R
import kotlinx.android.synthetic.main.activity_login.uiEtPassword
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.view.*
import java.text.SimpleDateFormat
import java.util.*

class SignUpActivity : AppCompatActivity() {

    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setUpListener()

    }

    private fun updateLable(myCalendar: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        uiEtBirthday.setText(sdf.format(myCalendar.time))
    }

    private fun setUpListener() {
        val myCalender = Calendar.getInstance()

        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            myCalender.set(Calendar.YEAR, year)
            myCalender.set(Calendar.MONTH, month)
            myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLable(myCalender)
        }
        uiEtBirthday.setOnClickListener {
            DatePickerDialog(
                this, datePicker, myCalender.get(Calendar.YEAR), myCalender.get(Calendar.MONTH),
                myCalender.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        uiBtnJoin.setOnClickListener {
            if (validateProfile()) {
                navigationWalkThrough()
            }
        }

        uiIvBack.setOnClickListener {
            finish()
        }
        uiTvSignIn.setOnClickListener {
            finish()
        }
    }

    private fun validateProfile(): Boolean {
        return if (uiEtName.text.isNullOrEmpty()) {
            Toast.makeText(this, "Enter Your Name", Toast.LENGTH_LONG).show()
            false
        } else if (uiEtPassword.text.isNullOrEmpty()) {
            Toast.makeText(this, "Enter Password", Toast.LENGTH_LONG).show()
            false
        } else if (uiEtBirthday?.text.isNullOrEmpty()) {
            Toast.makeText(this, "Enter Birthday Date", Toast.LENGTH_LONG).show()
            false
        } else if (!uiEtEmail.text.toString().matches(emailPattern.toRegex())) {
            Toast.makeText(this, "Enter Valid Email", Toast.LENGTH_LONG).show()
            false
        } else true
    }

    private fun navigationWalkThrough() {
        val intent = Intent(this, WalkThroughActivity::class.java)
        startActivity(intent)
        finish()
    }


}
