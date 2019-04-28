package com.example.lenovo.sqliteprueba003.adaptador;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.sqliteprueba003.R;
import com.example.lenovo.sqliteprueba003.entidades.Usuario;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListaPersonaAdapter  extends RecyclerView.Adapter<ListaPersonaAdapter.PersonasViewHolder> {



    ArrayList<Usuario> listaUsuario;

    public ListaPersonaAdapter(ArrayList<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    @NonNull
    @Override
    public PersonasViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View vista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.consulta_recycler,null,false);
        RecyclerView.LayoutParams layoutParams1 = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(layoutParams1);


        return new PersonasViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonasViewHolder personasViewHolder, int i) {

        personasViewHolder.tvdocumentorecycler.setText(listaUsuario.get(i).getId().toString());
        personasViewHolder.tvnombrerecycler.setText(listaUsuario.get(i).getNombre().toString());
        personasViewHolder.tvtelefonorecycler.setText(listaUsuario.get(i).getTelefono().toString());

    }

    @Override
    public int getItemCount() {
        return listaUsuario.size();
    }

    public class PersonasViewHolder extends RecyclerView.ViewHolder {

        TextView tvdocumentorecycler,tvnombrerecycler,tvtelefonorecycler;

        public PersonasViewHolder(@NonNull View itemView) {
            super(itemView);

            tvdocumentorecycler = (TextView)itemView.findViewById(R.id.tvdocumentorecycler);
            tvnombrerecycler = (TextView)itemView.findViewById(R.id.tvnombrerecycler);
            tvtelefonorecycler = (TextView)itemView.findViewById(R.id.tvtelefonorecycler);



        }
    }







}
