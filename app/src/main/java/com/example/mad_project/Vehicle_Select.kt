package com.example.mad_project

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Switch
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Vehicle_Select : AppCompatActivity() {
    lateinit var type_: String
    lateinit var switch:Switch
    lateinit var ac: String
    lateinit var  database: FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_select)
        switch = findViewById(R.id.switch1)
        if(switch.isChecked()){
            ac = "AC"
        }
        else{
            ac = "NonAC"
        }

        database = Firebase.database("https://mad-project-f38bd-default-rtdb.asia-southeast1.firebasedatabase.app/")

    }
    fun btn1(v:View){
        type_ ="Tuk Tuk"
    }
    fun btn2(v:View){
        type_ ="Car"
    }
    fun btn3(v:View){
        type_ ="Van"
    }
    fun btn4(v:View){
        type_ ="Suv"
    }
    fun switchClk(v:View){
        if(switch.isChecked()){
            ac = "AC"
        }
        else{
            ac = "NonAC"
        }
    }
    fun btn5(v: View){
        var lID: Int

        val sharedPref = this.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        lID = sharedPref.getInt("vID",1)
        var lData = VehicleDat(type_,ac)

        var kei = "V0$lID"
        lID++
        database.getReference("Vehicle").child(kei).setValue(lData)
        editor.putInt("vID",lID)
        editor.apply()

        val intnt : Intent = Intent(this, VehicleR::class.java)
        startActivity(intnt)
    }
}