package com.example.multix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class signup : AppCompatActivity() {

    private lateinit var bname: EditText
    private lateinit var bemail: EditText
    private lateinit var bpassword: EditText
    private lateinit var bsignup: Button
    private lateinit var mauth: FirebaseAuth




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        supportActionBar?.hide()
        bname=findViewById(R.id.name)

        bemail=findViewById(R.id.email)
        bpassword=findViewById(R.id.password)
        bsignup=findViewById(R.id.signup)

        mauth= FirebaseAuth.getInstance()


        bsignup.setOnClickListener {
            val name=bname.text.toString()
            val email=bemail.text.toString()
            val password=bpassword.text.toString()

            sign(name,email,password)
        }

    }
    private fun sign(name:String,email:String,password:String){
        mauth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                        addUserToDataBase(name,email,mauth.currentUser?.uid!!)
                    val int=Intent(this@signup,MainActivity::class.java)
                    startActivity(int)
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this,"some error occured",Toast.LENGTH_SHORT).show()
                   }
            }
    }

   private fun addUserToDataBase(name: String,email: String, uid: String) {
       //bath=FirebaseDatabase.getInstance().getReference()
        //bath.child("user").child(uid).setValue(User(name,email,uid))
       val database = Firebase.database
       val myRef = database.getReference("user").child(uid)
       myRef.setValue(User(name,email,uid))
    }
}