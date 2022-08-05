package com.example.taskmanagement.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.taskmanagement.adapter.GroupListAdapter
import com.example.taskmanagement.models.Group
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_group.*
import kotlinx.android.synthetic.main.app_bar_group.*
import kotlinx.android.synthetic.main.app_bar_main.uiIvNavDrawer
import kotlinx.android.synthetic.main.include_main_navigation.*

class GroupsActivity : AppCompatActivity() {

    private val groupListAdapter by lazy {
        GroupListAdapter(
            listItem = mutableListOf(),
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.taskmanagement.R.layout.activity_group)
        setUpUi()
        setUpListener()
        groupListAdapter.setGroupList(getGroupList())
    }

    private fun setUpUi() {
        uiRvGroupList.apply {
            adapter = groupListAdapter

        }
        Log.d("Group", "setUpUi: ${getGroupList()}")
    }

    private fun getGroupList(): MutableList<Group> = Gson().fromJson(
        this.assets.open("groups.json").reader(),
        object : TypeToken<List<Group>>() {}.type
    )

    private fun setUpListener() {
        uiIvNavDrawer.setOnClickListener {
            drawer_layout_group.openDrawer(GravityCompat.START)
        }
        uiTvLogout.setOnClickListener {
            onLogoutClicked()
        }
        uiTvHome.setOnClickListener {
            navigationHome()
        }
        uiTvOverview.setOnClickListener {
            navigationOverview()
        }
        uiTvGroups.setOnClickListener {
            onUserClicked()
        }
        uiTvLists.setOnClickListener {
            navigationList()
        }
        uiTvSetting.setOnClickListener {
            navigationSetting()
        }
        uiTvTimeline.setOnClickListener {
            navigationTimeline()
        }
        uiIvCancelImage.setOnClickListener {
            onUserClicked()
        }
    }

    private fun onUserClicked() {
        drawer_layout_group.closeDrawer(GravityCompat.START)
    }

    private fun navigationOverview() {
        val intent = Intent(this, OverviewActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun navigationHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun navigationList() {
        val intent = Intent(this, ListActivity::class.java)
        startActivity(intent)

    }

    private fun navigationTimeline() {
        val intent = Intent(this, TimelineActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun navigationSetting() {
        val intent = Intent(this, SettingActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun navigationLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun onLogoutClicked() {

        val alertDialog = AlertDialog.Builder(this).create()
        alertDialog.setMessage("Are you Sure ,You Want to Exit")

        alertDialog.setButton(
            AlertDialog.BUTTON_POSITIVE, "Yes"
        ) { dialog, which -> dialog.dismiss() }

        alertDialog.setButton(
            AlertDialog.BUTTON_NEGATIVE, "No"
        ) { dialog, which -> dialog.dismiss() }
        alertDialog.show()

        val btnPositive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)
        val btnNegative = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE)

        val layoutParams = btnPositive.layoutParams as LinearLayout.LayoutParams
        layoutParams.weight = 10f
        btnPositive.layoutParams = layoutParams
        btnNegative.layoutParams = layoutParams
        btnPositive.setOnClickListener {
            navigationLogin()
        }
    }
}