package com.example.myapplication3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla3)

        val et1=findViewById<EditText>(R.id.et7)
        val et2=findViewById<EditText>(R.id.et2)
        val r1=findViewById<RadioButton>(R.id.r1)
        val r2=findViewById<RadioButton>(R.id.r2)
        val tv1=findViewById<TextView>(R.id.tv1)
        val button2=findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            if (r1.isChecked)
                tv1.text = "Resultado: ${et1.text.toString().toInt() + et2.text.toString().toInt()}"
            if (r2.isChecked)
                tv1.text = "Resultado: ${et1.text.toString().toInt() - et2.text.toString().toInt()}"

        }
    }
}
