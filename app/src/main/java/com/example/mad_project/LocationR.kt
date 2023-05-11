package com.example.mad_project

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class LocationR : AppCompatActivity() {

   lateinit var textV1: TextView
   lateinit var textV2: TextView
   lateinit var textV3: TextView
   lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_r)
        textV1 =findViewById(R.id.textView4)
        textV2 =findViewById(R.id.textView5)
        textV3 =findViewById(R.id.textView6)

        val sharedPref = this.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)

        var lc: String = sharedPref.getString("lc"," ").toString()
        var dD: String = sharedPref.getString("dD"," ").toString()
        var mP: Int = sharedPref.getInt("mP",0)
        var fP: Int = sharedPref.getInt("fP",0)
        var tp =mP+fP


        textV1.setText(lc)
        textV2.setText(dD)
        textV3.setText("$tp")


    }
    fun button(V : View){
        val intnt : Intent = Intent(this, Location::class.java).also{ it.putExtra("edi",true)

        startActivity(it)}
    }
    fun btnn(V : View){
        val intnt : Intent = Intent(this, MainActivity::class.java)
        startActivity(intnt)
    }
}