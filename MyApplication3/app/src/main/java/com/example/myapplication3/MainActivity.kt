package com.example.myapplication3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<EditText>(R.id.et7)
        val et2=findViewById<EditText>(R.id.et2)
        val tv1=findViewById<TextView>(R.id.tv1)
        val button2=findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            val et1=findViewById<EditText>(R.id.et7)
            val nro1 = et1.text.toString().toInt()
            val nro2 = et2.text.toString().toInt()
            val suma = nro1 + nro2
            et1.text.clear()
            et2.text.clear()
            tv1.text = "Resultant: $suma"
        }
    }
}
