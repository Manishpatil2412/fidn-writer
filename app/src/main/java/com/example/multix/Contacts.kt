package com.example.multix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Contacts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        val retur=findViewById<Button>(R.id.retur)

        retur.setOnClickListener {
            val intent= Intent(this,login::class.java)
            startActivity(intent)
        }
    }
}