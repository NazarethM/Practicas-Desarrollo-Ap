package com.example.myapplicationabcr;

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AdminSQLiteOpenHelper(context: Context, name: String, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {

        override fun onCreate(db: SQLiteDatabase) {

        db.execSQL("create table alumnos(id integer primary key autoincrement, nombre text,numero integer, grupo text)")


        db.execSQL("create table maestros(id integer primary key autoincrement, RFC integer, nombre text, materia text)")


        db.execSQL("create table materias(id integer primary key autoincrement, nombre text, profesor text, aula text)")
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        }
}

