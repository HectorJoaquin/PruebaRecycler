package com.example.lenovo.sqliteprueba003.basedatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lenovo.sqliteprueba003.entidades.Usuario;
import com.example.lenovo.sqliteprueba003.utilidades.Utilidades;

import static com.example.lenovo.sqliteprueba003.utilidades.Utilidades.CAMPO_ID;
import static com.example.lenovo.sqliteprueba003.utilidades.Utilidades.CAMPO_NOMBRE;
import static com.example.lenovo.sqliteprueba003.utilidades.Utilidades.CAMPO_TELEFONO;
import static com.example.lenovo.sqliteprueba003.utilidades.Utilidades.TABLA_USUARIO;

public class ConexionSQLHelper extends SQLiteOpenHelper {



    public ConexionSQLHelper(Context context,String name,SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Utilidades.CREAR_TABLA_USUARIO);
        db.execSQL(Utilidades.CREAR_TABLA_MASCOTA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS personas");
        db.execSQL("DROP TABLE IF EXISTS mascota");
        onCreate(db);

    }




}
