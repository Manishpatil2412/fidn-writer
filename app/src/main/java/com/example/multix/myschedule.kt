package com.example.multix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class myschedule : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myschedule)

        val ed1 = findViewById<EditText>(R.id.date)
        val ed2 = findViewById<EditText>(R.id.event)
        val bu4 = findViewById<Button>(R.id.save1)

        bu4.setOnClickListener {
            val inputValue: String = ed1.text.toString()
            val inputValue1: String = ed2.text.toString()
            if (inputValue == null || inputValue.trim() == "" && inputValue1 == null || inputValue1.trim() == ""){
                Toast.makeText(this, "please input data, edit text cannot be blank", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this,"Data saved",Toast.LENGTH_LONG).show()

            }
            }
        }
    }



