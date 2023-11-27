package com.example.myapplication3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        val tv1=findViewById<TextView>(R.id.tv1)
        val boton1=findViewById<ImageButton>(R.id.boton1)
        boton1.setOnClickListener {
            tv1.text="Llamando"
        }
    }
}