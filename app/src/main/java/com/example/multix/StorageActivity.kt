package com.example.multix

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.storage.FirebaseStorage
import java.net.URI
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*

class StorageActivity : AppCompatActivity() {
    lateinit var firebase:ImageView
    lateinit var ImageUri: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage)
        var selectbtn=findViewById<Button>(R.id.selectimage)
        var uploadbtn=findViewById<Button>(R.id.uploadimage)
        selectbtn.setOnClickListener{

            selectImage()
        }
        uploadbtn.setOnClickListener{

            uploadImage()

        }

    }

    private fun uploadImage() {
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("uploading file...")
        progressDialog.setCancelable(false)
        progressDialog.show()

        val formatter=SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault())
        val now=Date()
      //  val fileName=formatter.format(now)
        val ed1= findViewById<EditText>(R.id.name2)
        val inputValue : String = ed1.text.toString()
        val storageReference=FirebaseStorage.getInstance().getReference("writer/$inputValue")

        storageReference.putFile(ImageUri).addOnSuccessListener{
            firebase=findViewById(R.id.firebaseimage)
            firebase.setImageURI(null)
            Toast.makeText(this,"Successfully uploaded",Toast.LENGTH_SHORT).show()
            if(progressDialog.isShowing)progressDialog.dismiss()
        }.addOnFailureListener{
            if(progressDialog.isShowing)progressDialog.dismiss()
            Toast.makeText(this,"failed",Toast.LENGTH_SHORT).show()
        }
    }

    private fun selectImage() {
        val intent= Intent()
        intent.type = "image/*"
        intent.action=Intent.ACTION_GET_CONTENT

        startActivityForResult(intent,100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        firebase=findViewById(R.id.firebaseimage)
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==100 && resultCode== RESULT_OK){
             ImageUri = data?.data!!
            firebase.setImageURI(ImageUri)

        }
    }
}