package com.example.todo

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.row.*

class MyAdapter(var myContext : Context, var resource: Int, var items:ArrayList<Task>)
    : ArrayAdapter<Task>(myContext,resource,items){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val data = getItem(position) as Task
        val layoutInflater:LayoutInflater = LayoutInflater.from(myContext)

        val view: View = layoutInflater.inflate(resource,null)

        val imgeView: ImageView = view.findViewById(R.id.icon)
        val textView1: TextView = view.findViewById(R.id.firstLine)
        val textView2: TextView = view.findViewById(R.id.secondLine)
        val textView3: TextView = view.findViewById(R.id.thirdLine)

        var myItems: Task = items.get(position)

        imgeView.setImageDrawable(myContext.resources.getDrawable(myItems.image))
        textView1.text = myItems.cont
        textView2.text = myItems.description
        textView3.text = myItems.tim

        view.setOnLongClickListener {
            this.remove(getItem(position))
            notifyDataSetChanged()
            true
        }

        return view
    }
}