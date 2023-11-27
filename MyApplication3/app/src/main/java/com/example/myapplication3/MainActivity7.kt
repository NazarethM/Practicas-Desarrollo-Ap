package com.example.myapplication3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        val et1=findViewById<EditText>(R.id.et1)
        val et2=findViewById<EditText>(R.id.et2)
        val boton1=findViewById<Button>(R.id.boton1)
        boton1.setOnClickListener {
            if (et2.text.toString().length == 0)
                Toast.makeText(this, "La clave no puede quedar vacía", Toast.LENGTH_LONG).show()

        }
    }
}

