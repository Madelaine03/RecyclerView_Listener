package com.madev.recyclerview_listener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.madev.recyclerview_listener.Adaptadores.UsuariosAdaptadores;
import com.madev.recyclerview_listener.Clases.Usuarios;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UsuariosAdaptadores.OnItemClickListener {

    RecyclerView rcv_usuarios;
    List<Usuarios> listaUsuarios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv_usuarios = findViewById(R.id.rcv_usuarios);


        Usuarios user1 = new Usuarios("Madelaine", "https://cdn-icons-png.flaticon.com/512/1828/1828384.png", "Italia", "Activo");
        Usuarios user2 = new Usuarios("Melissa", "https://cdn-icons-png.flaticon.com/512/1828/1828384.png", "Canadá", "Activo");
        Usuarios user3 = new Usuarios("Mayte", "https://cdn-icons-png.flaticon.com/512/1828/1828384.png", "Paris", "Inactivo");
        Usuarios user4 = new Usuarios("Cristian", "https://cdn-icons-png.flaticon.com/512/1828/1828384.png", "Japón", "Activo");
        Usuarios user5 = new Usuarios("Esteban", "https://cdn-icons-png.flaticon.com/512/1828/1828384.png", "Rusia", "Inactivo");
        Usuarios user6 = new Usuarios("Eydrem", "https://cdn-icons-png.flaticon.com/512/1828/1828384.png", "México", "Inactivo");

        listaUsuarios.add(user1);
        listaUsuarios.add(user2);
        listaUsuarios.add(user3);
        listaUsuarios.add(user4);
        listaUsuarios.add(user5);
        listaUsuarios.add(user6);


        rcv_usuarios.setLayoutManager(new LinearLayoutManager(this));
        UsuariosAdaptadores adaptador = new UsuariosAdaptadores(listaUsuarios, this);
        rcv_usuarios.setAdapter(adaptador);

    }

    public void onItemClick(Usuarios usuario) {
        Intent intent = new Intent(MainActivity.this, Info_Users.class);
        intent.putExtra("Nombre", usuario.getNombre());
        intent.putExtra("Pais", usuario.getPais());
        intent.putExtra("Estado", usuario.getEstado());
        startActivity(intent);
    }

}