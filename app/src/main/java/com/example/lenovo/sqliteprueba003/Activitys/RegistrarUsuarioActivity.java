package com.example.lenovo.sqliteprueba003.Activitys;

import android.content.ContentValues;
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

public class RegistrarUsuarioActivity extends AppCompatActivity {


    EditText etIdRegistar,etNombreRegistar,etTelefonoRegistar;
    Button btnGuardar;

    ConexionSQLHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        etIdRegistar=(EditText)findViewById(R.id.etIdRegistar);
        etNombreRegistar=(EditText)findViewById(R.id.etNombreRegistar);
        etTelefonoRegistar=(EditText)findViewById(R.id.etTelefonoRegistar);
        btnGuardar = (Button)findViewById(R.id.btnGuardar);

             conn =  new ConexionSQLHelper(getApplicationContext(),"bd_persona",null,1);



        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                guardarDatos();
                clearDatos();


            }
        });



    }

    private void clearDatos() {

        etIdRegistar.setText("");
        etNombreRegistar.setText("");
        etTelefonoRegistar.setText("");

    }

    private void guardarDatos() {


        SQLiteDatabase db =  conn.getWritableDatabase();

        ContentValues values =  new ContentValues();

        values.put(Utilidades.CAMPO_ID,etIdRegistar.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE,etNombreRegistar.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO,etTelefonoRegistar.getText().toString());

        Long idResultamte =  db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID,values);

        Toast.makeText(this, "Registrado ID "+idResultamte, Toast.LENGTH_SHORT).show();

        db.close();


    }
}
