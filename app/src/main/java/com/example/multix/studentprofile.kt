package com.example.multix

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.database.DatabaseError

import com.google.firebase.database.DataSnapshot

import com.google.firebase.database.ValueEventListener

import com.google.firebase.database.DatabaseReference

import com.google.firebase.database.FirebaseDatabase




class studentprofile : AppCompatActivity() {
  // private lateinit var ed1 : EditText
  //  private lateinit var ed2 : EditText
  //  private lateinit var ed3 : EditText
 //   private lateinit var ed4 : EditText
  //  private lateinit var ed5 : EditText
  //  private lateinit var ed6 : EditText
  //  private lateinit var ed7 : EditText
  //  private lateinit var ed8 : EditText
  //  private lateinit var ed9 : EditText
  //  private lateinit var bu1 : EditText
    private lateinit var dbRef2 : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_studentprofile)

       val ed1= findViewById<EditText>(R.id.name1)
        val ed2= findViewById<EditText>(R.id.name13)
        val ed3= findViewById<EditText>(R.id.phone1)
        val ed4= findViewById<EditText>(R.id.addre)
        val ed5= findViewById<EditText>(R.id.email1)
        val ed6= findViewById<EditText>(R.id.phone2)
        val ed7= findViewById<EditText>(R.id.educ)
        val ed8= findViewById<EditText>(R.id.date)
        val  ed9= findViewById<EditText>(R.id.sex)
        val  bu1=findViewById<Button>(R.id.save)
        val ed10=findViewById<EditText>(R.id.aadhar)


        dbRef2= FirebaseAuth.getInstance()



       bu1.setOnClickListener(){
                val inputValue : String = ed1.text.toString()
                val inputValue1 : String= ed2.text.toString()
                val inputValue2 : String= ed3.text.toString()
                val inputValue3 : String = ed4.text.toString()
                val inputValue4 : String= ed5.text.toString()
                val inputValue5 : String= ed6.text.toString()
                val inputValue6 : String= ed7.text.toString()
                val inputValue7 : String = ed8.text.toString()
                val inputValue8 : String= ed9.text.toString()
                val inputValue9:String=ed10.text.toString()


           if ((inputValue == null || inputValue.trim() == "") && (inputValue1 == null || inputValue1.trim() == "")&& (inputValue2 == null || inputValue2.trim() == "")
               &&( inputValue3 == null || inputValue3.trim() == "")&& (inputValue4 == null || inputValue4.trim() == "")&& (inputValue5 == null || inputValue5.trim() == "")
               && (inputValue6 == null || inputValue6.trim() == "")&& (inputValue9 == null || inputValue9.trim() == "")&& (inputValue7 == null || inputValue7.trim() == "")&& (inputValue8 == null || inputValue8.trim() == "")) {
               Toast.makeText(
                   this,
                   "please input data, edit text cannot be blank",
                   Toast.LENGTH_LONG
               ).show()

           }
           else {

               addUserToDataBase(inputValue,inputValue1,inputValue2,inputValue3,inputValue4,inputValue5,
                   inputValue6,inputValue7,inputValue8,inputValue9,dbRef2.currentUser?.uid!!)
               ed1.setText("").toString()
               ed2.setText("").toString()
               ed3.setText("").toString()
               ed4.setText("").toString()
               ed5.setText("").toString()
               ed6.setText("").toString()
               ed7.setText("").toString()
               ed8.setText("").toString()
               ed9.setText("").toString()
               ed10.setText("").toString()

           }

       }




    }

    private fun addUserToDataBase(
        inputValue: String,
        inputValue1: String,
        inputValue2: String,
        inputValue3: String,
        inputValue4: String,
        inputValue5: String,
        inputValue6: String,
        inputValue7: String,
        inputValue8: String,
        inputValue9: String,
        uid: String
    ) {
        val data=Firebase.database
        val myRef = data.getReference("student").child(inputValue)
        val eventListener: ValueEventListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (!dataSnapshot.exists()) {
                    myRef.setValue(Stama(
                        inputValue,inputValue1,inputValue2,inputValue3,inputValue4,inputValue5,inputValue6,inputValue7,inputValue8,inputValue9,uid
                    ))
                    Toast.makeText(this@studentprofile,"data saved",Toast.LENGTH_LONG).show()

                }else {
                    Toast.makeText(
                        this@studentprofile,
                        "this username already so please enter diffrent name",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {

                Log.d(TAG, databaseError.message) //Don't ignore errors!


            }
        }
        myRef.addListenerForSingleValueEvent(eventListener)




    }


}