package com.kotlinchina.activitydemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast

class FirstActivity : AppCompatActivity() {

    var button1: Button? = null
    var button2: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        button1 = findViewById(R.id.button1) as Button
        button2 = findViewById(R.id.button2) as Button

        button1?.setOnClickListener(View.OnClickListener {
            val intent: Intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        })

        button2?.setOnClickListener(View.OnClickListener {
            this.finish()
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.item_add -> {
                Toast.makeText(this, "Clicked Add", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.item_remove -> {
                Toast.makeText(this, "Clicked Remove", Toast.LENGTH_SHORT).show()
            }
            else -> return false
        }
        return false
    }
}
