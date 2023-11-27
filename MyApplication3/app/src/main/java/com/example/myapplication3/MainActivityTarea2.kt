package com.example.myapplication3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button

class MainActivityTarea2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tarea2)

        val bundle = intent.extras
        val dato = bundle?.getString("direccion")
        val webView1=findViewById<WebView>(R.id.webView1)
        val boton1=findViewById<Button>(R.id.button)
        webView1.loadUrl("https://${dato}")
        boton1.setOnClickListener {
            finish();
        }
    }
}