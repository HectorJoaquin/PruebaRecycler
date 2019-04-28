package com.example.lenovo.sqliteprueba003.adaptador;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.sqliteprueba003.R;
import com.example.lenovo.sqliteprueba003.entidades.Usuario;

import java.util.ArrayList;

public class PruebaAdapter extends RecyclerView.Adapter<PruebaAdapter.PruebaViewHolder> {

    ArrayList<Usuario> listaPersonas;




    public PruebaAdapter(ArrayList<Usuario> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }




    @NonNull
    @Override
    public PruebaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View vista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_prueba,null,false);
        RecyclerView.LayoutParams layoutParams1 = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(layoutParams1);


        return new PruebaViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull PruebaViewHolder pruebaViewHolder, int i) {

        pruebaViewHolder.tvdocumentorecyclerPu.setText(listaPersonas.get(i).getId().toString());
        pruebaViewHolder.tvnombrerecyclerPu.setText(listaPersonas.get(i).getNombre().toString());
        pruebaViewHolder.tvtelefonorecyclerPu.setText(listaPersonas.get(i).getTelefono().toString());



    }

    @Override
    public int getItemCount() {

        return listaPersonas.size();
    }

    public class PruebaViewHolder extends RecyclerView.ViewHolder {

        TextView tvdocumentorecyclerPu,tvnombrerecyclerPu,tvtelefonorecyclerPu;


        public PruebaViewHolder(@NonNull View itemView) {
            super(itemView);

            tvdocumentorecyclerPu = (TextView)itemView.findViewById(R.id.tvdocumentorecyclerPu);
            tvnombrerecyclerPu = (TextView)itemView.findViewById(R.id.tvnombrerecyclerPu);
            tvtelefonorecyclerPu = (TextView)itemView.findViewById(R.id.tvtelefonorecyclerPu);

        }
    }
}
