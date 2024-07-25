package com.example.todolist

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var todoListView: ListView
    private lateinit var todoEditText: EditText
    private lateinit var addButton: Button

    private val tasks = mutableListOf<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoListView = findViewById(R.id.todoListView)
        todoEditText = findViewById(R.id.todoEditText)
        addButton = findViewById(R.id.addButton)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tasks)
        todoListView.adapter = adapter

        addButton.setOnClickListener {
            val task = todoEditText.text.toString()
            if (task.isNotEmpty()) {
                tasks.add(task)
                adapter.notifyDataSetChanged()
                todoEditText.text.clear()
            }
        }

        todoListView.setOnItemLongClickListener { _, _, position, _ ->
            tasks.removeAt(position)
            adapter.notifyDataSetChanged()
            true
        }
    }
}
