package com.example.myapplication3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioButton
import android.widget.TextView
import android.widget.ArrayAdapter



class Examen : AppCompatActivity() {
    private val historialOperaciones = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_examen)
        val et4= findViewById<EditText>(R.id.et4)
        val et2 = findViewById<EditText>(R.id.et2)
        val et3 = findViewById<EditText>(R.id.et3)
        val r1 = findViewById<RadioButton>(R.id.r1)
        val r2 = findViewById<RadioButton>(R.id.r2)
        val r3 = findViewById<RadioButton>(R.id.r3)
        val r4 = findViewById<RadioButton>(R.id.r4)
        val tv1 = findViewById<TextView>(R.id.tv1)
        val button = findViewById<Button>(R.id.button)
        val listView = findViewById<ListView>(R.id.lista)


        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, historialOperaciones)
        listView.adapter = adapter


        button.setOnClickListener {

            val value1 = et4.text.toString().toIntOrNull() ?: 0
            val value2 = et2.text.toString().toIntOrNull() ?: 0
            val value3 = et3.text.toString().toIntOrNull() ?: 0


            when {
                r1.isChecked -> realizarOperacion("Suma", value1 + value2 + value3)
                r2.isChecked -> realizarOperacion("Resta", value1 - value2 - value3)
                r3.isChecked -> realizarOperacion("Multiplicación", value1 * value2 * value3)
                r4.isChecked -> {
                    if (value2 != 0 && value3 != 0) {
                        realizarOperacion("División", value1 / value2 / value3)
                    } else {
                        tv1.text = "No se puede dividir por cero"
                    }
                }
                else -> tv1.text = "Seleccione una operación"
            }


            et4.text.clear()
            et2.text.clear()
            et3.text.clear()
        }
    }

    private fun realizarOperacion(operacion: String, resultado: Int) {
        val tv1 = findViewById<TextView>(R.id.tv1)
        tv1.text = "Resultado: $resultado"
        val mensaje = "$operacion: ${tv1.text}"
        actualizarHistorial(mensaje)
    }

    private fun actualizarHistorial(operacion: String) {
        historialOperaciones.add(0, operacion)
        val adapter = findViewById<ListView>(R.id.lista).adapter as ArrayAdapter<String>
        adapter.notifyDataSetChanged()
    }
}