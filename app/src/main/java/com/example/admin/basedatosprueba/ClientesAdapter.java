package com.example.admin.basedatosprueba;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Creado por Hermosa Programación
 */
public class ClientesAdapter extends RecyclerView.Adapter<ClientesAdapter.ClientesViewHolder> {
    private List<Clientes> items;

    public static class ClientesViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        //public ImageView imagen;
        public TextView nombre;
        public TextView visitas;

        public ClientesViewHolder(View v) {
            super(v);
            //imagen = (ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.cardnombre);
            visitas = (TextView) v.findViewById(R.id.cardcedula);
        }
    }

    public ClientesAdapter(List<Clientes> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ClientesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cliente_card, viewGroup, false);
        return new ClientesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ClientesViewHolder viewHolder, int i) {
        //viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.nombre.setText(items.get(i).getNombre());
        viewHolder.visitas.setText("Cedula:"+String.valueOf(items.get(i).getCedula()));
    }
}
