package com.example.todoapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity()
{
    private lateinit var items: ArrayList<ToDoItem>
    private lateinit var rvItems: RecyclerView
    private lateinit var rvAdapter: RVAdapter


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items = arrayListOf()
        rvItems = findViewById<RecyclerView>(R.id.RVItems)
        rvAdapter = RVAdapter(items)
        rvItems.adapter = rvAdapter
        rvItems.layoutManager = LinearLayoutManager(this)

        val tAdd = findViewById<FloatingActionButton>(R.id.Add)
        tAdd.setOnClickListener ()
        {
            customDialog()
        }
    }

    private fun customDialog(){
        val dialogBuilder = AlertDialog.Builder(this)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL

        val toDolist = EditText(this)
        toDolist.hint = "Enter Work To Do"

        layout.addView(toDolist)

        dialogBuilder.setPositiveButton("ADD", DialogInterface.OnClickListener
        {
                    dialog, id -> items.add(ToDoItem(toDolist.text.toString()))
            })
            .setNegativeButton("CANCEL", DialogInterface.OnClickListener
            {
                    dialog, id -> dialog.cancel()
            })

        val alert = dialogBuilder.create()
        alert.setTitle("TO Do")
        alert.setView(layout)
        alert.show()
    }
}