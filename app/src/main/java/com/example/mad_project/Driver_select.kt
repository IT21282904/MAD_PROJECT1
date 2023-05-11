package com.example.mad_project

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Driver_select : AppCompatActivity() {
    lateinit var Age:String
    lateinit var Gender: String
    lateinit var  database: FirebaseDatabase
    lateinit var bttn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        database = Firebase.database("https://mad-project-f38bd-default-rtdb.asia-southeast1.firebasedatabase.app/")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_select)

        val spinner: Spinner = findViewById(R.id.spinner4)

// Create an ArrayAdapter using the string array and a default spinner layout
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.spinner5_items,
            android.R.layout.simple_spinner_item
        )

// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

// Apply the adapter to the spinner
        spinner.adapter = adapter

        spinner.onItemSelectedListener =object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Age = adapter.getItem(p2) as String
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
    fun btn(v:View){
        var ID: Int

        val sharedPref = this.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        ID = sharedPref.getInt("dID",1)
        var lData = DriverDat(Age, Gender)

        var kei = "D0$ID"
        ID++
        database.getReference("Driver").child(kei).setValue(lData)
        editor.putInt("dID",ID)
        editor.apply()

        val intnt : Intent = Intent(this, DriverR::class.java)
        startActivity(intnt)
    }
    fun btn1(v:View){
        Gender ="Male"
    }
    fun btn2(v:View){
        Gender ="Female"
    }
}
data class DriverDat(val Age:String, val Gender:String)