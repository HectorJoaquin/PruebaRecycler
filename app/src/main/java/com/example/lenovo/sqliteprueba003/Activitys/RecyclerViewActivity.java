package com.example.lenovo.sqliteprueba003.Activitys;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lenovo.sqliteprueba003.R;
import com.example.lenovo.sqliteprueba003.adaptador.ListaPersonaAdapter;
import com.example.lenovo.sqliteprueba003.basedatos.ConexionSQLHelper;
import com.example.lenovo.sqliteprueba003.entidades.Usuario;
import com.example.lenovo.sqliteprueba003.utilidades.Utilidades;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {


    ConexionSQLHelper conn;
    ArrayList<Usuario> listaUsuario;
    RecyclerView recyclerxml;
    Button btnScaner;
    EditText etScaner;
    //BORRAR CREO
    SwipeRefreshLayout swipeRefreshLayout;

    //ListaPersonaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        conn =  new ConexionSQLHelper(getApplicationContext(),"bd_persona",null,1);

        listaUsuario = new ArrayList<>();

        recyclerxml =  (RecyclerView)findViewById(R.id.recyclerxml);
        btnScaner = (Button)findViewById(R.id.btnScaner);
        etScaner = (EditText)findViewById(R.id.etScaner);
        //BORRAR CREO
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);

        recyclerxml.setLayoutManager(new LinearLayoutManager(this));

            cargarRecycler();


        ListaPersonaAdapter adapet = new ListaPersonaAdapter(listaUsuario);
        recyclerxml.setAdapter(adapet);
        //adapet.notifyDataSetChanged();


///EL METODO swipeRefreshLayout AL PARECER NO FUNCIONA BIEN O AUN NO LO APLICO BIEN

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                cargarDatos();
            }
        });
///EL METODO swipeRefreshLayout AL PARECER NO FUNCIONA BIEN O AUN NO LO APLICO BIEN


btnScaner.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        //buscarSql();


    }
});



    }

///EL METODO swipeRefreshLayout AL PARECER NO FUNCIONA BIEN O AUN NO LO APLICO BIEN

    private void cargarDatos() {

        new UnaTarea().execute();


    }

    private class UnaTarea extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(3000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            swipeRefreshLayout.setRefreshing(false);
        }
    }
///HASTA AQUI VAN LOS METODOS DE swipeRefreshLayout




    private void buscarSql() {

        SQLiteDatabase db = conn.getReadableDatabase();

        Usuario usuario = null;

        listaUsuario = new ArrayList<Usuario>();

        Cursor cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_USUARIO+ " WHERE "+ Utilidades.CAMPO_ID +"=?"+ etScaner.getText().toString(),null);

      for (int i =0; i<listaUsuario.size()  ;i++){

      }

            usuario =  new Usuario();

            usuario.setId(cursor.getString(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setTelefono(cursor.getString(2));

            listaUsuario.add(usuario);





    }


    private void cargarRecycler() {

        SQLiteDatabase db = conn.getReadableDatabase();

        Usuario usuario = null;


        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_USUARIO, null);
        while (cursor.moveToNext()){

            usuario =  new Usuario();

            usuario.setId(cursor.getString(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setTelefono(cursor.getString(2));


            listaUsuario.add(usuario);

        }



    }




}
