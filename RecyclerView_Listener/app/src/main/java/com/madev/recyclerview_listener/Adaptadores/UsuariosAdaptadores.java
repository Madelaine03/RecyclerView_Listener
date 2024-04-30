package com.madev.recyclerview_listener.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import com.madev.recyclerview_listener.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.madev.recyclerview_listener.Clases.Usuarios;
import com.squareup.picasso.Picasso;


import java.util.List;

public class UsuariosAdaptadores extends RecyclerView.Adapter<UsuariosAdaptadores.ViewHolder>{

    private List<Usuarios> datos;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Usuarios usuario);
    }
    public UsuariosAdaptadores(List<Usuarios> datos, OnItemClickListener listener){
        this.datos = datos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public UsuariosAdaptadores.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuarios, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuariosAdaptadores.ViewHolder holder, int position) {
        Usuarios dato = datos.get(position);
        holder.bind(dato);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onItemClick(dato);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_nombre_usuario, txt_pais_usuario, txt_estado;
        ImageView img_usuario;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_pais_usuario = itemView.findViewById(R.id.txt_pais_usuario);
            txt_nombre_usuario = itemView.findViewById(R.id.txt_nombre_usuario);
            txt_estado = itemView.findViewById(R.id.txt_estado);
            img_usuario = itemView.findViewById(R.id.img_usuario);
        }

        public void bind(Usuarios dato){
            txt_nombre_usuario.setText(dato.getNombre());
            txt_pais_usuario.setText(dato.getPais());
            txt_estado.setText(dato.getEstado());

            //img_usuario libreria
            Picasso.get().load(dato.getImagen()).into(img_usuario);

        }
    }
}
