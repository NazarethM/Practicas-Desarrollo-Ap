package com.example.myapplication3


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivityTarea : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tarea)
        val et1=findViewById<EditText>(R.id.et1)
        val boton1=findViewById<Button>(R.id.boton1)
        boton1.setOnClickListener {
            val intento1 = Intent(this, MainActivityTarea2::class.java)
            intento1.putExtra("direccion", et1.text.toString())
            startActivity(intento1)
        }
    }
}