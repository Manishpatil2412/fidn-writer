package com.example.multix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {

    private lateinit var bemail: EditText
    private lateinit var bpassword: EditText
    private lateinit var blogin: Button
    private lateinit var bsignup: Button
    private lateinit var bforgot: TextView
    private lateinit var bauth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        bemail=findViewById(R.id.email)
        bpassword=findViewById(R.id.password)
        blogin=findViewById(R.id.login)
        bsignup=findViewById(R.id.signup)
        bforgot=findViewById(R.id.forgot)

        bauth= FirebaseAuth.getInstance()

        bsignup.setOnClickListener {
            val intent = Intent(this,signup::class.java)
            startActivity(intent)
        }

        blogin.setOnClickListener {
            val email=bemail.text.toString()
            val password=bpassword.text.toString()

            logn(email,password)
        }

        bforgot.setOnClickListener {
            val intent = Intent(this,Contacts::class.java)
            startActivity(intent)
        }
    }
    private fun logn(email:String,password:String){
        bauth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val intent=Intent(this@login,MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // If sign in fails, display a message to the user.
                Toast.makeText(this,"User does not exist",Toast.LENGTH_SHORT).show()
                }
            }


    }
}