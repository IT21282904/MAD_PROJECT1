package com.example.mad_project

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Payments : AppCompatActivity() {
    lateinit var radioG:RadioGroup
    lateinit var radioB:RadioButton
    lateinit var pmthd:String
    lateinit var texV : EditText

    lateinit var  database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payments)
        radioG = findViewById(R.id.Rgroup)
        texV = findViewById(R.id.textView4)
        radioB =findViewById(radioG.checkedRadioButtonId)
        pmthd =radioB.text.toString()
        database = Firebase.database("https://mad-project-f38bd-default-rtdb.asia-southeast1.firebasedatabase.app/")
    }
    fun radBtn(v:View){
        radioB =findViewById(radioG.checkedRadioButtonId)
        pmthd =radioB.text.toString()

    }
    fun btn(v:View){
        var lID: Int
        var amt:String = texV.text.toString()
        val sharedPref = this.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        lID = sharedPref.getInt("pID",1)
        var lData = PaymentsDat(amt,pmthd)

        var kei = "P0$lID"
        lID++
        database.getReference("Payment").child(kei).setValue(lData)
        editor.putInt("pID",lID)
        editor.apply()

        val intnt : Intent = Intent(this, PaymentR::class.java)
        startActivity(intnt)
    }
}
data class PaymentsDat(val amt:String,val pmtd:String)