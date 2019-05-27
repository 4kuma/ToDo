package com.example.todo

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var list = ArrayList<Task>()
    //    private val taskList = ArrayList<Task>()
    private val Request_Row = 666

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        listView.adapter = MyAdapter(this, R.layout.row, list)

        bytype.setOnClickListener{
            list.sortBy { it.image }
            listView.adapter = MyAdapter(this, R.layout.row, list)
        }


        addButton.setOnClickListener {
            val i = Intent(this, NewTaskActivity::class.java)
            startActivityForResult(i,Request_Row)
        }

//        addButton.setOnClickListener {
//            val i = Intent(this, NewTaskActivity::class.java)
//            startActivityForResult(i,Request_Row)
//        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null){
            if (resultCode == Activity.RESULT_OK) {
                var title = data.getStringExtra("resulttitle")
                var icon = data.getIntExtra("icon",R.drawable.icon0)
                var hour = data.getStringExtra("hour")
                var desc = data.getStringExtra("description")
                val task = Task(title,hour,icon,desc)
                list.add(task)
                listView.adapter = MyAdapter(this, R.layout.row, list)


            } else {

            }
        }
    }

}
