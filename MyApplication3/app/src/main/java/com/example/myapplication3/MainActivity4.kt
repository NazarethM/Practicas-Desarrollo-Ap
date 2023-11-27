package com.example.myapplication3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        val tv1=findViewById<TextView>(R.id.tv1)
        val list1=findViewById<ListView>(R.id.list1)
        val paises = arrayOf( "Argentina", "Chile", "Paraguay", "Bolivia", "Peru", "Ecuador", "Brasil", "Colombia", "Venezuela", "Uruguay")
        var habitantes = arrayOf(40_000_000, 17_000_000, 6_500_000, 10_000_000, 30_000_000, 14_000_000, 183_000_000, 44_000_000, 31_000_000, 3_500_000)
        val adaptador1 = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, paises)
        list1.adapter = adaptador1
        list1.setOnItemClickListener { adapterView, view, i, l ->
            tv1.text = "Población de: ${habitantes[i]}"
        }
    }
}