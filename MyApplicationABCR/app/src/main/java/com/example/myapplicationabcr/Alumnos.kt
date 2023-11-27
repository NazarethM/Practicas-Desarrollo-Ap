package com.example.myapplicationabcr

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Alumnos() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alumno)

        val et1 = findViewById<EditText>(R.id.et1)
        val et2 = findViewById<EditText>(R.id.et2)
        val et3 = findViewById<EditText>(R.id.et3)
        val boton1 = findViewById<Button>(R.id.btnalta)
        val boton2 = findViewById<Button>(R.id.btndesc)
        val boton3 = findViewById<Button>(R.id.btnbaja)
        val boton5 = findViewById<Button>(R.id.btnmodif)
        val btnregreso = findViewById<Button>(R.id.btnregreso)

        //alta
        boton1.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "ABCR", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("nombre", et1.text.toString())
            registro.put("numero", et2.text.toString())
            registro.put("grupo", et3.text.toString())
            bd.insert("alumnos", null, registro)
            bd.close()
            et1.setText("")
            et2.setText("")
            et3.setText("")
            Toast.makeText(this, "Se cargaron los datos del alumno", Toast.LENGTH_SHORT).show()
        }
        ///Consulta por nombre
        boton2.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "ABCR", null, 1)
            val bd = admin.writableDatabase
            val nombreConsulta = et1.text.toString()

            // Utiliza un query parametrizado para evitar problemas de seguridad y SQL injection
            val fila = bd.rawQuery(
                "SELECT id, nombre, numero, grupo FROM alumnos WHERE nombre=?",
                arrayOf(nombreConsulta)
            )

            if (fila.moveToFirst()) {
                et1.setText(fila.getString(0))
                et2.setText(fila.getString(1))
                et3.setText(fila.getString(2))
            } else {
                Toast.makeText(this, "No existe un alumno con dicho nombre", Toast.LENGTH_SHORT)
                    .show()
            }

            bd.close()
        }

        /// baja por numero de control
        boton3.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "ABCR", null, 1)

            // Use para garantizar que la base de datos se cierre correctamente
            admin.writableDatabase.use { bd ->
                val numeroControl = et1.text.toString().trim()

                if (numeroControl.isNotEmpty()) {
                    try {

                        bd.beginTransaction()

                        bd.execSQL("DELETE FROM alumnos WHERE nombre=?", arrayOf(numeroControl))

                        bd.setTransactionSuccessful()

                        et1.setText("")
                        et2.setText("")
                        et3.setText("")

                        Toast.makeText(this, "Baja del alumno ", Toast.LENGTH_SHORT).show()
                    } catch (e: Exception) {
                        Toast.makeText(
                            this,
                            "Error al dar de baja  al alumno: ${e.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                        e.printStackTrace()
                    } finally {
                        bd.endTransaction()
                    }
                } else {
                    Toast.makeText(
                        this,
                        "Por favor, ingrese un número de control válido",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }


//// boton modificar
        boton5.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "ABCR", null, 1)

            // Use para garantizar que la base de datos se cierre correctamente
            admin.writableDatabase.use { bd ->
                val id = et1.text.toString().trim()
                val nombre = et2.text.toString().trim()
                val numeroControl = et3.text.toString().trim()

                if (id.isNotEmpty() && nombre.isNotEmpty() && numeroControl.isNotEmpty()) {
                    try {
                        val registro = ContentValues()
                        registro.put("nombre", nombre)
                        registro.put("numero", numeroControl)

                        // Utilizar el método update para realizar la actualización
                        val cant = bd.update("alumnos", registro, "id=?", arrayOf(id))

                        if (cant == 1) {
                            Toast.makeText(
                                this,
                                "Se modificaron los datos del alumno",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                this,
                                "No existe un alumno con el ID ingresado",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } catch (e: Exception) {
                        Toast.makeText(
                            this,
                            "Error al modificar el alumno: ${e.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                        e.printStackTrace()
                    }
                } else {
                    Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

        btnregreso.setOnClickListener {
            finish()
        }
    }
}
