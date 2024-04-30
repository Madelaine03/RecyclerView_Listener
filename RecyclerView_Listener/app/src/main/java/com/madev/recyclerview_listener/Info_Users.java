package com.madev.recyclerview_listener;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Info_Users extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_users);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("Nombre");
        String pais = intent.getStringExtra("Pais");
        String estado = intent.getStringExtra("Estado");

        TextView txtNombre = findViewById(R.id.txt_nombre);
        TextView txtPais = findViewById(R.id.txt_pais);
        TextView txtEstado = findViewById(R.id.txt_Estado);

        txtNombre.setText(nombre);
        txtPais.setText(pais);
        txtEstado.setText(estado);
    }
}