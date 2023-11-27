package com.example.myapplication3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)

        val boton1=findViewById<Button>(R.id.boton1)
        boton1.setOnClickListener {
            val intento1 = Intent(this, AcercaDe::class.java)
            startActivity(intento1)
        }
    }
}
