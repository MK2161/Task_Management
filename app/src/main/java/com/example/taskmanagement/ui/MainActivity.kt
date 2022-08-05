package com.example.taskmanagement.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.include_main_navigation.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.taskmanagement.R.layout.activity_main)
        setUpListener()
    }

    private fun setUpListener() {
        uiIvNavDrawer.setOnClickListener {
            drawer_layout.openDrawer(GravityCompat.START)
        }
        uiTvLogout.setOnClickListener{
            onLogoutClicked()
        }
        uiTvHome.setOnClickListener{
            onUserClicked()
        }
        uiTvOverview.setOnClickListener{
            navigationOverview()
        }
        uiTvGroups.setOnClickListener{
            navigationGroup()
        }
        uiTvLists.setOnClickListener{
            navigationList()
        }
        uiTvSetting.setOnClickListener{
            navigationSetting()
        }
        uiTvTimeline.setOnClickListener{
            navigationTimeline()
        }
        uiIvCancelImage.setOnClickListener{
            onUserClicked()
        }
        uiFloat.setOnClickListener{
            navigationCreate()
        }
    }

    private fun onUserClicked() {
        drawer_layout.closeDrawer(GravityCompat.START)
    }
    private fun navigationOverview(){
        val intent = Intent(this, OverviewActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun navigationGroup(){
        val intent = Intent(this, GroupsActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun navigationList(){
        val intent = Intent(this, ListActivity::class.java)
        startActivity(intent)
    }

    private fun navigationTimeline(){
        val intent = Intent(this, TimelineActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun navigationLogin(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun navigationSetting(){
        val intent = Intent(this, SettingActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun navigationCreate(){
        val intent = Intent(this, CreateActivity::class.java)
        startActivity(intent)

    }
    private fun onLogoutClicked() {

        val alertDialog = AlertDialog.Builder(this).create()
        alertDialog.setMessage("Are you Sure ,You Want to Exit")

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes"
        ) { dialog, which -> dialog.dismiss() }

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No"
        ) { dialog, which -> dialog.dismiss() }
        alertDialog.show()

        val btnPositive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)
        val btnNegative = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE)

        val layoutParams = btnPositive.layoutParams as LinearLayout.LayoutParams
        layoutParams.weight = 10f
        btnPositive.layoutParams = layoutParams
        btnNegative.layoutParams = layoutParams
        btnPositive.setOnClickListener{
            navigationLogin()
        }

    }

}