package com.kotlinchina.activitydemo.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.kotlinchina.activitydemo.R
import java.util.*

/**
 * Created by chenjunjun on 1/8/16.
 */
class ShowListAdapter(var list:ArrayList<String>,val context: Context): BaseAdapter() {

    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        if(convertView != null){
            return convertView
        }

        val showListItemView = View.inflate(context, R.layout.show_list_item, null)
        val holder: ViewHolder = ViewHolder()
        holder.name = showListItemView.findViewById(R.id.item_tv) as TextView?
        holder.name?.text = list[position]
        showListItemView.tag = holder

        holder.name?.text = list[position]

        return showListItemView
    }

    override fun getItem(position: Int): Any? {
        return list.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    class ViewHolder{
        var name: TextView? = null
    }
}
