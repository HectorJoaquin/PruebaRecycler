package com.example.lenovo.sqliteprueba003.Activitys;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lenovo.sqliteprueba003.R;
import com.example.lenovo.sqliteprueba003.basedatos.ConexionSQLHelper;
import com.example.lenovo.sqliteprueba003.entidades.Usuario;
import com.example.lenovo.sqliteprueba003.utilidades.Utilidades;

import java.util.ArrayList;

public class ListViewConsultaActivity extends AppCompatActivity {

    ConexionSQLHelper conn;
    ListView listaView;
    ArrayList<Usuario> listaUsuario;
    ArrayList<String> llenarListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_consulta);

        conn =  new ConexionSQLHelper(getApplicationContext(),"bd_persona",null,1);

        listaView = (ListView)findViewById(R.id.listaView);


        cargarListView();

        ArrayAdapter adapter =  new ArrayAdapter(this,android.R.layout.simple_list_item_1,llenarListview);
        listaView.setAdapter(adapter);


        listaView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Usuario user =  listaUsuario.get(i);

                Intent g = new Intent(ListViewConsultaActivity.this,DetalleUsuarioActivity.class);

                Bundle bundle = new Bundle();

                bundle.putSerializable("person",user);
                g.putExtras(bundle);
                startActivity(g);




            }
        });


    }

    private void cargarListView() {

        SQLiteDatabase db = conn.getReadableDatabase();

        Usuario usuario = null;

        listaUsuario = new ArrayList<Usuario>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_USUARIO, null);
        while (cursor.moveToNext()) {

            usuario = new Usuario();

            usuario.setId(cursor.getString(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setTelefono(cursor.getString(2));

            listaUsuario.add(usuario);


        }

        obtenerLista();
    }

    private void obtenerLista() {

        llenarListview = new ArrayList<String>();

        for (int i =0; i<listaUsuario.size();i++){

            llenarListview.add(listaUsuario.get(i).getId()+"-"+listaUsuario.get(i).getNombre()+"-"+listaUsuario.get(i).getTelefono());

        }

    }
}
