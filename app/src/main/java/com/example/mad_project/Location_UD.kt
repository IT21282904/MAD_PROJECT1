package com.example.mad_project

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Location_UD : AppCompatActivity() {
    lateinit var location: String
    lateinit var destination: String
    lateinit var malePassenge: String
    lateinit var femalePassenge: String
    lateinit var  database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_ud)
        database = Firebase.database("https://mad-project-f38bd-default-rtdb.asia-southeast1.firebasedatabase.app/")


        val spinner: Spinner = findViewById(R.id.spinner2)

// Create an ArrayAdapter using the string array and a default spinner layout
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.spinner1_items,
            android.R.layout.simple_spinner_item
        )

// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

// Apply the adapter to the spinner
        spinner.adapter = adapter

        spinner.onItemSelectedListener =object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                location = adapter.getItem(p2) as String
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        val spinner2: Spinner = findViewById(R.id.spinner3)

// Create an ArrayAdapter using the string array and a default spinner layout
        val adapter2 = ArrayAdapter.createFromResource(
            this,
            R.array.spinner2_items,
            android.R.layout.simple_spinner_item
        )

// Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

// Apply the adapter to the spinner
        spinner2.adapter = adapter2

        spinner2.onItemSelectedListener =object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                destination = adapter2.getItem(p2) as String
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        val spinner3: Spinner = findViewById(R.id.spinner6)

// Create an ArrayAdapter using the string array and a default spinner layout
        val adapter3 = ArrayAdapter.createFromResource(
            this,
            R.array.spinner3_items,
            android.R.layout.simple_spinner_item
        )

// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

// Apply the adapter to the spinner
        spinner3.adapter = adapter3

        spinner3.onItemSelectedListener =object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                malePassenge = adapter3.getItem(p2) as String
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        val spinner4: Spinner = findViewById(R.id.spinner7)

// Create an ArrayAdapter using the string array and a default spinner layout
        val adapter4 = ArrayAdapter.createFromResource(
            this,
            R.array.spinner3_items,
            android.R.layout.simple_spinner_item
        )

// Specify the layout to use when the list of choices appears
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

// Apply the adapter to the spinner
        spinner4.adapter = adapter4

        spinner4.onItemSelectedListener =object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                femalePassenge = adapter4.getItem(p2) as String
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


    }
    fun btnClk(v : View) {
        var lID: Int

        val sharedPref = this.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        lID = sharedPref.getInt("ID",1)
        var lData = LocationDat(location,destination,malePassenge,femalePassenge)

        var kei = "D0$lID"
        lID++
        database.getReference("Location").child(kei).setValue(lData)
        editor.putInt("ID",lID)
        editor.apply()

    }

}