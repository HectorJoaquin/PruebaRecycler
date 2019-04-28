package com.example.lenovo.sqliteprueba003;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lenovo.sqliteprueba003.Activitys.ConsultarUsuarioActivity;
import com.example.lenovo.sqliteprueba003.Activitys.ListViewConsultaActivity;
import com.example.lenovo.sqliteprueba003.Activitys.RecyclerViewActivity;
import com.example.lenovo.sqliteprueba003.Activitys.RegistrarMascotaActivity;
import com.example.lenovo.sqliteprueba003.Activitys.RegistrarUsuarioActivity;
import com.example.lenovo.sqliteprueba003.Activitys.SpinnerConsultaActivity;

public class MainActivity extends AppCompatActivity {
    Button btnRegistar,btnConsultar,btnSpinner,btnlistView,btnRegistarMascota,btnReciclerView,btnReciclerViewPu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegistar = (Button)findViewById(R.id.btnRegistar);
        btnConsultar = (Button)findViewById(R.id. btnConsultar);
        btnSpinner = (Button)findViewById(R.id. btnSpinner);
        btnlistView = (Button)findViewById(R.id.btnlistView);
        btnRegistarMascota = (Button)findViewById(R.id.btnRegistarMascota);
        btnReciclerView = (Button)findViewById(R.id.btnReciclerView);
        btnReciclerViewPu = (Button)findViewById(R.id.btnReciclerViewPu);


        btnReciclerViewPu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent g = new Intent(MainActivity.this, PruebaActualizarActivity.class);
                startActivity(g);

            }
        });

        btnReciclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent f = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(f);

            }
        });

        btnRegistarMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent e= new Intent(MainActivity.this,RegistrarMascotaActivity.class);
                startActivity(e);


            }
        });

        btnlistView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent d= new Intent(MainActivity.this,ListViewConsultaActivity.class);
                startActivity(d);



            }
        });

        btnSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent c = new Intent(MainActivity.this,SpinnerConsultaActivity.class);
                startActivity(c);

            }
        });


        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent b = new Intent(MainActivity.this,ConsultarUsuarioActivity.class);
                startActivity(b);

            }
        });

        btnRegistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent a = new Intent(MainActivity.this,RegistrarUsuarioActivity.class);
                startActivity(a);

            }
        });



    }
}
