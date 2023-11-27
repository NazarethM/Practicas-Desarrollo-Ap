package com.example.myapplicationabcr


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button

class MenuPrincipal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)


        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)


        btn3.setOnClickListener {
            val accion1 = Intent(this, Materias::class.java)
            startActivity(accion1)
        }
        btn2.setOnClickListener {
            val accion2 = Intent(this, Maestros::class.java)
            startActivity(accion2)
        }
        btn1.setOnClickListener {
            val accion3 = Intent(this, Alumnos::class.java)
            startActivity(accion3)
        }
    }
}