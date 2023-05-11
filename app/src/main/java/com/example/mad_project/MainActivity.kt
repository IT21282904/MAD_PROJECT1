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
        val intnt : Intent = Intent(this, Location::class.java).also {
            it.putExtra("edi",false)
            startActivity(it)}
    }
    fun vehicle(V : View){
        val intnt : Intent = Intent(this, Vehicle_Select::class.java).also {
            it.putExtra("edi",false)
            startActivity(it)}
    }
    fun driver(V : View){
        val intnt : Intent = Intent(this, Driver_select::class.java).also {
            it.putExtra("edi",false)
            startActivity(it)}
    }
    fun payments(V : View){
        val intnt : Intent = Intent(this, Payments::class.java).also {
            it.putExtra("edi",false)
            startActivity(it)}
    }
    fun login(V:View){
        val intnt : Intent = Intent(this, Login::class.java).also {
            it.putExtra("edi",false)
            startActivity(it)}
    }

}