package com.example.lenovo.sqliteprueba003.Activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.lenovo.sqliteprueba003.R;
import com.example.lenovo.sqliteprueba003.entidades.Usuario;

public class DetalleUsuarioActivity extends AppCompatActivity {
    TextView tvIdDetalle,tvNombreDetalle,tvTelefonoDetalle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_usuario);

        tvIdDetalle = (TextView)findViewById(R.id.tvIdDetalle);
        tvNombreDetalle = (TextView)findViewById(R.id.tvNombreDetalle);
        tvTelefonoDetalle = (TextView)findViewById(R.id.tvTelefonoDetalle);


        Bundle ff = getIntent().getExtras();
        Usuario use = null;

        if (ff !=null){

            use = (Usuario) ff.getSerializable("person");

            tvIdDetalle.setText(use.getId().toString());
            tvNombreDetalle.setText(use.getNombre().toString());
            tvTelefonoDetalle.setText(use.getTelefono().toString());


        }




    }
}
