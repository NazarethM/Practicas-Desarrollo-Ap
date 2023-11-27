package com.example.myapplicationabcr

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class Materias : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materia)
        val et1 = findViewById<EditText>(R.id.et1)
        val et2 = findViewById<EditText>(R.id.et2)
        val et3 = findViewById<EditText>(R.id.et3)
        val boton1 = findViewById<Button>(R.id.balta)
        val boton2 = findViewById<Button>(R.id.bconsult)
        val boton3 = findViewById<Button>(R.id.bbaja)
        val boton5 = findViewById<Button>(R.id.bmodifi)
        val btnregreso = findViewById<Button>(R.id.boton5)


//altas
        boton1.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "ABCR", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("nombre", et1.text.toString())
            registro.put("profesor", et2.text.toString())
            registro.put("aula", et3.text.toString())
            bd.insert("materias", null, registro)
            bd.close()
            et1.setText("")
            et2.setText("")
            et3.setText("")
            Toast.makeText(this, "Se cargaron los datos de la materia", Toast.LENGTH_SHORT).show()
        }

        ///Consulta por profesor
        boton2.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "ABCR", null, 1)
            val bd = admin.writableDatabase
            val profeConsulta = et1.text.toString()

            // Utiliza un query parametrizado para evitar problemas de seguridad y SQL injection
            val fila = bd.rawQuery("SELECT id, nombre, profesor, aula FROM materias WHERE nombre=?", arrayOf(profeConsulta))

            if (fila.moveToFirst()) {
                et1.setText(fila.getString(0))
                et2.setText(fila.getString(1))
                et3.setText(fila.getString(2))
            } else {
                Toast.makeText(this, "No existe dicha clase", Toast.LENGTH_SHORT).show()
            }

            bd.close()
        }

// baja por nombre de materia
        boton3.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "ABCR", null, 1)


            admin.writableDatabase.use { bd ->
                val nombre = et1.text.toString().trim()

                if (nombre.isNotEmpty()) {
                    try {

                        val cant = bd.delete("materias", "nombre=?", arrayOf(nombre))

                        et1.setText("")
                        et2.setText("")
                        et3.setText("")

                        if (cant == 1) {
                            Toast.makeText(this, "Se borró la materia con dicho nombre", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "No existe una materia con dicho nombre", Toast.LENGTH_SHORT).show()
                        }
                    } catch (e: Exception) {
                        Toast.makeText(this, "Error al borrar la materia: ${e.message}", Toast.LENGTH_SHORT).show()
                        e.printStackTrace()
                    }
                } else {
                    Toast.makeText(this, "Por favor, ingrese el nombre de la materia", Toast.LENGTH_SHORT).show()
                    btnregreso.setOnClickListener {
                        finish()
                    }
                }
            }
        }
        boton5.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "ABCR", null, 1)

            //se cierre correctamente de base
            admin.writableDatabase.use { bd ->
                val id = et1.text.toString().trim()
                val nombre = et2.text.toString().trim()
                val numeroControl = et3.text.toString().trim()

                if (id.isNotEmpty() && nombre.isNotEmpty() && numeroControl.isNotEmpty()) {
                    try {
                        val registro = ContentValues()
                        registro.put("nombre", nombre)
                        registro.put("profesor", numeroControl)

                        val cant = bd.update("alumnos", registro, "id=?", arrayOf(id))

                        if (cant == 1) {
                            Toast.makeText(
                                this,
                                "Se modificaron los datos del Docente",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                this,
                                "No existe un Docente con el ID ingresado",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } catch (e: Exception) {
                        Toast.makeText(
                            this,
                            "Error al modificar los datos: ${e.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                        e.printStackTrace()
                    }
                } else {
                    Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            btnregreso.setOnClickListener {
                finish()
            }
        }
    }
}