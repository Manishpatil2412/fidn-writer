package com.example.multix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Writer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writer)

      val profile=findViewById<Button>(R.id.myprofile)
        val history=findViewById<Button>(R.id.history)
        val active=findViewById<Button>(R.id.active)
        val request=findViewById<Button>(R.id.appect)
        val reward=findViewById<Button>(R.id.point)
        val alert=findViewById<Button>(R.id.alert)
        val review=findViewById<Button>(R.id.review)
        val chat=findViewById<Button>(R.id.chatbox)

        profile.setOnClickListener {
            val intent= Intent(this,myprofile::class.java)
            startActivity(intent)
        }
        history.setOnClickListener {
            val intent= Intent(this,com.example.multix.history::class.java)
            startActivity(intent)
        }
        active.setOnClickListener {
            val intent= Intent(this,com.example.multix.active::class.java)
            startActivity(intent)
        }
        request.setOnClickListener {
            val intent= Intent(this,appect::class.java)
            startActivity(intent)
        }
        reward.setOnClickListener {
            val intent= Intent(this,reward::class.java)
            startActivity(intent)
        }
        alert.setOnClickListener {
            val intent= Intent(this,alert::class.java)
            startActivity(intent)
        }
        review.setOnClickListener {
            val intent= Intent(this,review::class.java)
            startActivity(intent)
        }
        chat.setOnClickListener {
            val intent= Intent(this,Chats::class.java)
            startActivity(intent)
        }

    }
}