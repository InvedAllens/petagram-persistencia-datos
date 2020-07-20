package com.example.fragmentspetagram.db;

public final class ConstantesBaseDatos {
    public static final String DATABASE_NAME ="mascotas";
    public static final int DATABASE_VERSION=1;

    public static final String TABLE_MASCOTA="mascota";
    public static final String TABLE_MASCOTA_ID="id";
    public static final String TABLE_MASCOTA_NOMBRE="nombre";
    public static final String TABLE_MASCOTA_FOTO="foto";
    public static final String TABLE_MASCOTA_FAVORITO = "favorito";

    public static final String TABLE_LIKES_MASCOTA = "mascota_likes";
    public static final String TABLE_LIKES_ID = "id";
    public static final String TABLE_LIKES_ID_MASCOTA ="id_mascota" ;
    public static final String TABLE_LIKES_NUMERO = "numero_likes";

    public static Boolean DATOS_INSERTADOS=false;
}
