package com.example.lenovo.sqliteprueba003.utilidades;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.lenovo.sqliteprueba003.entidades.Usuario;

public class Utilidades {


    public static String TABLA_USUARIO ="personas";
    public static String CAMPO_ID = "id";
    public static String CAMPO_NOMBRE="nombre";
    public static String CAMPO_TELEFONO = "telefono";


    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE "+TABLA_USUARIO+" ("+CAMPO_ID+" TEXT, "+CAMPO_NOMBRE+" TEXT, "+CAMPO_TELEFONO+" TEXT)";


    public static String TABLA_MASCOTA= "mascota";
    public static String CAMPO_ID_MASCOTA="id_mascota";
    public static String CAMPO_NOMBRE_MASCOTA ="nombre_mascota";
    public static String CAMPO_RAZA_MASCOTA="raza_mascota";
    public static String CAMPO_ID_DUENIO="id_duenio";

    public static String CREAR_TABLA_MASCOTA = "CREATE TABLE "+TABLA_MASCOTA+" ("+CAMPO_ID_MASCOTA+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_NOMBRE_MASCOTA+" TEXT, "+CAMPO_RAZA_MASCOTA+" TEXT, "+CAMPO_ID_DUENIO+" TEXT)";






}
