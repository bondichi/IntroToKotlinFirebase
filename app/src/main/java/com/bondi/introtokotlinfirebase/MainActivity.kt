package com.bondi.introtokotlinfirebase

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var firebaseDatabase = FirebaseDatabase.getInstance()
        var myRef = firebaseDatabase.getReference("messages")

        myRef.setValue("Hello Pandrew")

        // read from the database

        myRef.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                //dataSnapshot is the object that has the snapshot of the db
                var value = dataSnapshot.value
                Log.d("VALUE", value.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                // error message if fail to read db
                Log.d("DB read Error:", error.message)

            }

        })
    }
}
