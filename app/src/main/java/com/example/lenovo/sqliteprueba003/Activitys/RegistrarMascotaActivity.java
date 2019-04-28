package com.example.lenovo.sqliteprueba003.Activitys;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.lenovo.sqliteprueba003.R;
import com.example.lenovo.sqliteprueba003.basedatos.ConexionSQLHelper;
import com.example.lenovo.sqliteprueba003.utilidades.Utilidades;

public class RegistrarMascotaActivity extends AppCompatActivity {

    EditText etNombreRegistarMascota,etRazaRegistarMascota;
    Spinner spinnerConsultaMascota;
    Button btnGuardarMascota;
    ConexionSQLHelper conn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_mascota);

        etNombreRegistarMascota = (EditText)findViewById(R.id.etNombreRegistarMascota);
        etRazaRegistarMascota = (EditText)findViewById(R.id.etRazaRegistarMascota);
        spinnerConsultaMascota = (Spinner)findViewById(R.id.spinnerConsultaMascota);
        btnGuardarMascota = (Button)findViewById(R.id.btnGuardarMascota);

        conn = new ConexionSQLHelper(getApplicationContext(),"bd_persona",null,1);

        btnGuardarMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                guardarDatosMascota();

            }
        });



    }

    private void guardarDatosMascota() {


        SQLiteDatabase  db =  conn.getWritableDatabase();

        ContentValues values =  new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE_MASCOTA,etNombreRegistarMascota.getText().toString());
        values.put(Utilidades.CAMPO_RAZA_MASCOTA,etRazaRegistarMascota.getText().toString());



    }
}
