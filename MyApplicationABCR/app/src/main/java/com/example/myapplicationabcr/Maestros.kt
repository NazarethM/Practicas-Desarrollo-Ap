package com.example.myapplicationabcr

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplicationabcr.R.id.btnmenu1

class Maestros : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maestro)
        val et1 = findViewById<EditText>(R.id.et1)
        val et2 = findViewById<EditText>(R.id.et2)
        val et3 = findViewById<EditText>(R.id.et3)
        val boton1 = findViewById<Button>(R.id.balta)
        val boton2 = findViewById<Button>(R.id.bconsulta)
        val boton3 = findViewById<Button>(R.id.bbaja)
        val boton5 = findViewById<Button>(R.id.bmodifi)
        val btnregreso = findViewById<Button>(R.id.btnmenu1)


        //alta
        boton1.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "ABCR", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("RFC", et1.text.toString())
            registro.put("nombre", et2.text.toString())
            registro.put("materia", et3.text.toString())
            bd.insert("maestros", null, registro)
            bd.close()
            et1.setText("")
            et2.setText("")
            et3.setText("")
            Toast.makeText(this, "Se cargaron los datos del Docente", Toast.LENGTH_SHORT).show()
        }
        ///Consulta por rfc
        boton2.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "ABCR", null, 1)
            val bd = admin.writableDatabase
            val RFCConsulta = et1.text.toString()

            // Utiliza un query parametrizado para evitar problemas de seguridad y SQL injection
            val fila = bd.rawQuery(
                "SELECT id, RFC, nombre, materia FROM maestros WHERE rfc=?",
                arrayOf(RFCConsulta)
            )

            if (fila.moveToFirst()) {

                et1.setText(fila.getString(0))
                et2.setText(fila.getString(1))
                et3.setText(fila.getString(2))

            } else {
                Toast.makeText(this, "No existe un maestro con dicho RFC", Toast.LENGTH_SHORT)
                    .show()
            }

            fila.close() // Cierra el cursor después de usarlo
            bd.close()
        }


        /// baja por numero de control
        boton3.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "ABCR", null, 1)
            val bd = admin.writableDatabase
            val cant = bd.delete("maestros", "id=${et1.text.toString()}", null)
            bd.close()
            et1.setText("")
            et2.setText("")
            et3.setText("")
            if (cant == 1) {
                Toast.makeText(this, "Se borró el maestro con dicho RFC", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(
                    this,
                    "No existe un alumno con dicho Numero de control",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


        boton5.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "ABCR", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("nombre", et2.text.toString())
            registro.put("edad", et3.text.toString())
            val cant = bd.update("alumnos", registro, "id=${et1.text.toString()}", null)
            bd.close()
            if (cant == 1) {
                Toast.makeText(this, "Se modificaron los datos del alumno", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(this, "No existe un alumno con el ID ingresado", Toast.LENGTH_SHORT)
                    .show()
            }
        }
                btnregreso.setOnClickListener {
                    finish()
                }
            }
        }

