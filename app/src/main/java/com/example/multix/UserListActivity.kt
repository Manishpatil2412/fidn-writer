package com.example.multix

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class UserListActivity : AppCompatActivity() {

    private lateinit var mansdb : DatabaseReference
    private lateinit var userRecyclerView: RecyclerView

    private lateinit var userArrayList: ArrayList<Userwri>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        userRecyclerView=findViewById(R.id.userlist)
        userRecyclerView.layoutManager=LinearLayoutManager(this)
        userRecyclerView.setHasFixedSize(true)


        userArrayList = arrayListOf<Userwri>()
        getuserData()
    }

    private fun getuserData() {
        mansdb = FirebaseDatabase.getInstance().getReference("writer")
        mansdb.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(userSnapshot in snapshot.children){
                        val user = userSnapshot.getValue(Userwri :: class.java)
                        userArrayList.add(user!!)
                     //   Log.d(TAG,"Value is: " + user)
                    }
                    userRecyclerView.adapter=Userwrius(userArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })
    }
}

