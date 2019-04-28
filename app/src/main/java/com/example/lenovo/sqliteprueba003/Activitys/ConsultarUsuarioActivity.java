package com.example.lenovo.sqliteprueba003.Activitys;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lenovo.sqliteprueba003.R;
import com.example.lenovo.sqliteprueba003.basedatos.ConexionSQLHelper;
import com.example.lenovo.sqliteprueba003.utilidades.Utilidades;

public class ConsultarUsuarioActivity extends AppCompatActivity {

    ConexionSQLHelper conn;

    EditText etIdConsultar,etNombreConsultar,etTelefonoConsultar;
    Button btnBuscar,btnActualizar,btnEliminar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_usuario);

        etIdConsultar=(EditText)findViewById(R.id.etIdConsultar);
        etNombreConsultar=(EditText)findViewById(R.id.etNombreConsultar);
        etTelefonoConsultar=(EditText)findViewById(R.id.etTelefonoConsultar);

        btnBuscar = (Button)findViewById(R.id.btnBuscar);
        btnActualizar = (Button)findViewById(R.id.btnActualizar);
        btnEliminar = (Button)findViewById(R.id.btnEliminar);


        conn = new ConexionSQLHelper(getApplicationContext(),"bd_persona",null,1);


        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                updateinfo();
                clearinfo();


            }
        });



        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                deletInfo();
                clearinfo();

            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                buscarInfo();


            }
        });



    }

    private void updateinfo() {

        SQLiteDatabase db =  conn.getWritableDatabase();

        String[] parametro = {etIdConsultar.getText().toString()};

        ContentValues valu = new ContentValues();

        valu.put(Utilidades.CAMPO_NOMBRE,etNombreConsultar.getText().toString());
        valu.put(Utilidades.CAMPO_TELEFONO,etTelefonoConsultar.getText().toString());

        db.update(Utilidades.TABLA_USUARIO,valu,Utilidades.CAMPO_ID+"=?",parametro);
        Toast.makeText(this, "Actualizado", Toast.LENGTH_SHORT).show();
        db.close();

    }

    private void clearinfo() {

        etIdConsultar.setText("");
        etNombreConsultar.setText("");
        etTelefonoConsultar.setText("");

    }

    private void deletInfo() {

        SQLiteDatabase db =  conn.getWritableDatabase();

        String[] parametro = {etIdConsultar.getText().toString()};

        db.delete(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID+"=?",parametro);
        Toast.makeText(this, "Eliminado", Toast.LENGTH_SHORT).show();

        db.close();

    }

    private void buscarInfo() {

        SQLiteDatabase db = conn.getReadableDatabase();

        String[] paramatros = {etIdConsultar.getText().toString()};
        String[] campos = {Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_TELEFONO};



        try{

            Cursor cursor =  db.query(Utilidades.TABLA_USUARIO,campos,Utilidades.CAMPO_ID+"=?",paramatros,null,null,null);
            cursor.moveToFirst();
            etNombreConsultar.setText(cursor.getString(0));
            etTelefonoConsultar.setText(cursor.getString(1));

            cursor.close();


        }catch (Exception e){

            Toast.makeText(this, "No se encontro", Toast.LENGTH_SHORT).show();

            etNombreConsultar.setText("NO EXISTE");
            etTelefonoConsultar.setText("NO EXISTE");

        }




    }
}
