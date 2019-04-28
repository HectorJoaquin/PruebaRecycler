package com.example.lenovo.sqliteprueba003.Activitys;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.lenovo.sqliteprueba003.R;
import com.example.lenovo.sqliteprueba003.basedatos.ConexionSQLHelper;
import com.example.lenovo.sqliteprueba003.entidades.Usuario;
import com.example.lenovo.sqliteprueba003.utilidades.Utilidades;

import java.util.ArrayList;

public class SpinnerConsultaActivity extends AppCompatActivity {

    ConexionSQLHelper conn;
    Spinner spinnerConsulta;
    TextView tvIdSpinner,tvNombreSpinner,tvTelefonoSpinner;

    ArrayList<Usuario> listaUsuario;
    ArrayList<String> llenarSpinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_consulta);

        spinnerConsulta = (Spinner)findViewById(R.id.spinnerConsulta);
        tvIdSpinner = (TextView)findViewById(R.id.tvIdSpinner);
        tvNombreSpinner = (TextView)findViewById(R.id.tvNombreSpinner);
        tvTelefonoSpinner = (TextView)findViewById(R.id.tvTelefonoSpinner);

        conn = new ConexionSQLHelper(getApplicationContext(),"bd_persona",null,1);


        cargarSpinner();

        ArrayAdapter<CharSequence> adapter =  new ArrayAdapter(this,android.R.layout.simple_spinner_item,llenarSpinner);
        spinnerConsulta.setAdapter(adapter);


        spinnerConsulta.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i  !=0){

                    tvIdSpinner.setText(listaUsuario.get(i-1).getId().toString());
                    tvNombreSpinner.setText(listaUsuario.get(i-1).getNombre().toString());
                    tvTelefonoSpinner.setText(listaUsuario.get(i-1).getTelefono().toString());


                }else{
                    tvIdSpinner.setText("");
                    tvNombreSpinner.setText("");
                    tvTelefonoSpinner.setText("");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    private void cargarSpinner() {

        SQLiteDatabase db =  conn.getReadableDatabase();

        Usuario usuario = null;

        listaUsuario = new ArrayList<Usuario>();

        Cursor cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_USUARIO,null);
        while (cursor.moveToNext()){

            usuario =  new Usuario();

            usuario.setId(cursor.getString(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setTelefono(cursor.getString(2));

            listaUsuario.add(usuario);

        }

obetenerLista();


    }

    private void obetenerLista() {

        llenarSpinner = new ArrayList<String>();
        llenarSpinner.add("Seleccione");

        for (int i =0; i<listaUsuario.size();i++){

            llenarSpinner.add(listaUsuario.get(i).getId()+"-"+listaUsuario.get(i).getNombre());

        }

    }
}
