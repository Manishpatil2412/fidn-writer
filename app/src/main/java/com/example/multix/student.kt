package com.example.multix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class student : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)


        val profi1=findViewById<Button>(R.id.myprofile1)
        val languag=findViewById<Button>(R.id.language)
        val location=findViewById<Button>(R.id.location)
        val findwritter=findViewById<Button>(R.id.findwriter)
        val chat1=findViewById<Button>(R.id.chat1)
        val voice=findViewById<Button>(R.id.voice)
        val myschedu=findViewById<Button>(R.id.schedule)
        val update=findViewById<Button>(R.id.update)

        profi1.setOnClickListener {
            val intent= Intent(this,studentprofile::class.java)
            startActivity(intent)
        }
        languag.setOnClickListener {
            val intent= Intent(this,language::class.java)
            startActivity(intent)
        }
        location.setOnClickListener {
            val intent= Intent(this,Loa1::class.java)
            startActivity(intent)
        }
        findwritter.setOnClickListener {
            val intent= Intent(this,findwriter::class.java)
            startActivity(intent)
        }
        chat1.setOnClickListener {
            val intent= Intent(this,Chats1::class.java)
            startActivity(intent)
        }
        voice.setOnClickListener {
            val intent= Intent(this,voice::class.java)
            startActivity(intent)
        }
        myschedu.setOnClickListener {
            val intent= Intent(this,myschedule::class.java)
            startActivity(intent)
        }
        update.setOnClickListener {
            val intent= Intent(this,com.example.multix.update::class.java)
            startActivity(intent)
        }
    }
}