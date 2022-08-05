package com.example.taskmanagement.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmanagement.R
import com.example.taskmanagement.models.Group
import kotlinx.android.synthetic.main.activity_group_list.view.*

class GroupListAdapter(
    private val listItem: MutableList<Group>
    ):RecyclerView.Adapter<GroupListAdapter.GroupListViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_group_list, parent, false)
        return GroupListViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroupListViewHolder, position: Int) {
        val  inputListResponse = listItem[position]
        with(holder){
            uiTvTittle.text = inputListResponse.title
            uiTvItemCount.text = inputListResponse.itemsCount
        }
    }

    override fun getItemCount(): Int {
        return listItem.size
    }
    inner class GroupListViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val uiTvTittle: AppCompatTextView = view.uiTvTittle
        val uiTvItemCount: AppCompatTextView = view.uiTvItemCount
    }

    fun setGroupList(groupListItem:MutableList<Group> ){
        listItem.clear()
        listItem.addAll(groupListItem)
        Log.d("myList", "setGroupList: $groupListItem")
        notifyDataSetChanged()

    }

}



