package com.example.multix

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.multix.ui.main.SectionsPagerAdapter


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_main)

       val stude=findViewById<Button>(R.id.student)
       val writ=findViewById<Button>(R.id.writer)
       stude.setOnClickListener {
           val intent = Intent(this,student::class.java)
           startActivity(intent)
       }

        writ.setOnClickListener {
            val intent = Intent(this,Writer::class.java)
            startActivity(intent)
        }











    }
}





