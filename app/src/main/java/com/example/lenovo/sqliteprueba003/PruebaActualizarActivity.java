package com.example.lenovo.sqliteprueba003;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lenovo.sqliteprueba003.adaptador.ListaPersonaAdapter;
import com.example.lenovo.sqliteprueba003.adaptador.PruebaAdapter;
import com.example.lenovo.sqliteprueba003.basedatos.ConexionSQLHelper;
import com.example.lenovo.sqliteprueba003.entidades.Usuario;
import com.example.lenovo.sqliteprueba003.utilidades.Utilidades;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.example.lenovo.sqliteprueba003.utilidades.Utilidades.CAMPO_ID;
import static com.example.lenovo.sqliteprueba003.utilidades.Utilidades.CAMPO_NOMBRE;
import static com.example.lenovo.sqliteprueba003.utilidades.Utilidades.CAMPO_TELEFONO;
import static com.example.lenovo.sqliteprueba003.utilidades.Utilidades.TABLA_USUARIO;

public class PruebaActualizarActivity extends AppCompatActivity {
    ConexionSQLHelper conn;
    ArrayList<Usuario> listaPersonas;
    RecyclerView recyclerPu;
    EditText etIdRegistarPu,etNombreRegistarPu,etTelefonoRegistarPu;
    Button btnGuardarPu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_actualizar);

        conn =  new ConexionSQLHelper(getApplicationContext(),"bd_persona",null,1);

        listaPersonas = new ArrayList<>();

        recyclerPu =  (RecyclerView)findViewById(R.id.recyclerPu);
        etIdRegistarPu=(EditText)findViewById(R.id.etIdRegistarPu);
        etNombreRegistarPu=(EditText)findViewById(R.id.etNombreRegistarPu);
        etTelefonoRegistarPu=(EditText)findViewById(R.id.etTelefonoRegistarPu);
        btnGuardarPu = (Button)findViewById(R.id.btnGuardarPu);




        recyclerPu.setLayoutManager(new LinearLayoutManager(this));

        cargarRecyclerPrueba();



        PruebaAdapter adapter = new PruebaAdapter(listaPersonas);
        adapter.notifyDataSetChanged();
        recyclerPu.setAdapter(adapter);



        btnGuardarPu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                guardarPrueba();
                cargarRecyclerPrueba();



            }
        });




    }




    private void guardarPrueba() {

        conn =  new ConexionSQLHelper(getApplicationContext(),"bd_persona",null,1);

        SQLiteDatabase db =  conn.getWritableDatabase();

        ContentValues values =  new ContentValues();

        values.put(Utilidades.CAMPO_ID,etIdRegistarPu.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE,etNombreRegistarPu.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO,etTelefonoRegistarPu.getText().toString());

        Long idResultamte =  db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID,values);

        Toast.makeText(this, "Registrado ID "+idResultamte, Toast.LENGTH_SHORT).show();

        db.close();





    }

    private void cargarRecyclerPrueba() {


        SQLiteDatabase db = conn.getReadableDatabase();

        Usuario usuario = null;




        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_USUARIO, null);


        while (cursor.moveToNext()){

            usuario =  new Usuario();

            usuario.setId(cursor.getString(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setTelefono(cursor.getString(2));


            listaPersonas.add(usuario);

        }





    }

    public void updateContacts(Usuario usuario){
        ContentValues values = new ContentValues();
        values.put(CAMPO_NOMBRE, usuario.getNombre());
        values.put(CAMPO_TELEFONO, usuario.getTelefono());
        SQLiteDatabase db = conn.getWritableDatabase();
        db.update(TABLA_USUARIO, values, CAMPO_ID	+ "	= ?", new String[] { String.valueOf(usuario.getId())});
    }


}
