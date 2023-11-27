package com.example.myapplication3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)
        val et1=findViewById<EditText>(R.id.et7)
        val numero = (Math.random() * 100_001).toInt()
        Toast.makeText(this, "Número a recordar: ${numero}", Toast.LENGTH_LONG).show()
        val boton1=findViewById<Button>(R.id.button)
        boton1.setOnClickListener {
            if (numero == et1.text.toString().toInt())
                Toast.makeText(this, "Muy bien recordaste el número mostrado.", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "Lo siento pero no es el número que mostré.", Toast.LENGTH_LONG).show()
        }
    }
}