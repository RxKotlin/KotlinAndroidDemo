package com.kotlinchina.activitydemo

import android.app.Activity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.kotlinchina.activitydemo.adapter.ShowListAdapter
import java.util.*

/**
 * Created by chenjunjun on 1/8/16.
 */
class ShowListActivity : Activity() {

    var listview: ListView?=null

    fun ArrayList<String>.initData(){

        val name1 = "junjun"
        this.add(name1)

        val name2 = "xueliang"
        this.add(name2)

        val name3 = "jianjian"
        this.add(name3)

        val name4 = "baobao"
        this.add(name4)
    }

    private var data = ArrayList<String>()
    private var adapter: ShowListAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_show_list)

        listview = findViewById(R.id.listview) as? ListView

        data.initData()
        adapter = ShowListAdapter(data,this)

        listview?.adapter = adapter

        listview?.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this,"you click :"+data.get(position)+"",Toast.LENGTH_SHORT).show()
        }
    }
}

