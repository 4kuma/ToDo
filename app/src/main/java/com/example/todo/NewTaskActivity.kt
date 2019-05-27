package com.example.todo

import android.app.Activity
import android.app.TimePickerDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.new_task.*
import java.util.*

class NewTaskActivity : AppCompatActivity() {
    var hou = "12"
    var min = "30"
//    private var selected_date: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.new_task)
        super.onCreate(savedInstanceState)

        val mycolor =Color.parseColor("#a4d246")
        radioButton.setBackgroundColor(mycolor)
        radioButton2.setBackgroundColor(mycolor)
        radioButton3.setBackgroundColor(mycolor)
        radioButton4.setBackgroundColor(mycolor)
        radioButton5.setBackgroundColor(mycolor)


        add_button.setOnClickListener {
            var titleofrow = edit_title.text.toString()
            var description = editDescription.text.toString()
            val intent = Intent()
            intent.putExtra("resulttitle", titleofrow)

            if(radioButton.isChecked){
                intent.putExtra("icon", R.drawable.icon0)
            }
            else if(radioButton2.isChecked){
                intent.putExtra("icon", R.drawable.icon1)
            }
            else if(radioButton3.isChecked){
                intent.putExtra("icon", R.drawable.icon2)
            }
            else if(radioButton4.isChecked){
                intent.putExtra("icon", R.drawable.icon3)
            }
            else if(radioButton5.isChecked){
                intent.putExtra("icon", R.drawable.icon4)
            }

            var tim = "$hou:$min"

            intent.putExtra("hour",tim)
            intent.putExtra("description", description)
            setResult(Activity.RESULT_OK, intent)
            finish()


        }
        date_button.setOnClickListener{
            val c = Calendar.getInstance()
            val hour = c.get(Calendar.HOUR)
            val minute = c.get(Calendar.MINUTE)

            val tpd = TimePickerDialog(this,R.style.DialogTheme,TimePickerDialog.OnTimeSetListener(function ={view, h, m ->
                Toast.makeText(this, h.toString() + " : " + m  , Toast.LENGTH_LONG).show()
                hou = h.toString()
                min = m.toString()

            } ),hour,minute,false)

            tpd.show()
        }


    }
}