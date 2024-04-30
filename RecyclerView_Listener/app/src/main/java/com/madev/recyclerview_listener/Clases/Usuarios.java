package com.madev.recyclerview_listener.Clases;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Usuarios implements Parcelable {

    private String nombre;
    private String imagen;
    private String pais;
    private String estado;

    public Usuarios(String nombre, String imagen, String pais, String estado) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.pais = pais;
        this.estado = estado;
    }

    public static final Creator<Usuarios> CREATOR = new Creator<Usuarios>() {
        @Override
        public Usuarios createFromParcel(Parcel in) {
            return new Usuarios(in);
        }

        @Override
        public Usuarios[] newArray(int size) {
            return new Usuarios[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    protected Usuarios(Parcel in) {
        nombre = in.readString();
        imagen = in.readString();
        pais = in.readString();
        estado = in.readString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(imagen);
        dest.writeString(pais);
        dest.writeString(estado);
    }

}
