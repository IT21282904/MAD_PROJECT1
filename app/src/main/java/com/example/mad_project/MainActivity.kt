package com.example.mad_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun location(V : View){
        val intnt : Intent = Intent(this, Location::class.java)
        startActivity(intnt)
    }
    fun vehicle(V : View){
        val intnt : Intent = Intent(this, Vehicle_Select::class.java)
        startActivity(intnt)
    }
    fun driver(V : View){
        val intnt : Intent = Intent(this, Driver_select::class.java)
        startActivity(intnt)
    }
    fun payments(V : View){
        val intnt : Intent = Intent(this, Payments::class.java)
        startActivity(intnt)
    }
    fun login(V:View){
        val intnt : Intent = Intent(this, Login::class.java)
        startActivity(intnt)
    }

}