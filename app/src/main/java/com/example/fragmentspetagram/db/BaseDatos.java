package com.example.fragmentspetagram.db;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.fragmentspetagram.R;
import com.example.fragmentspetagram.pojo.Mascota;

import java.util.ArrayList;

import androidx.annotation.Nullable;

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;
    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryTablaMascota="CREATE TABLE "+ConstantesBaseDatos.TABLE_MASCOTA+"("+
                ConstantesBaseDatos.TABLE_MASCOTA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE+" TEXT,"+
                ConstantesBaseDatos.TABLE_MASCOTA_FOTO+" INTEGER,"+
                ConstantesBaseDatos.TABLE_MASCOTA_FAVORITO+" BOOLEAN NOT NULL CHECK("+ConstantesBaseDatos.TABLE_MASCOTA_FAVORITO+
                " IN (0,1))"+ ")";
        String queryTablaLikes="CREATE TABLE "+ConstantesBaseDatos.TABLE_LIKES_MASCOTA+"("+
                ConstantesBaseDatos.TABLE_LIKES_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA+" INTEGER,"+
                ConstantesBaseDatos.TABLE_LIKES_NUMERO+" INTEGER,"+
                "FOREIGN KEY("+ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA+")"+
                "REFERENCES "+ConstantesBaseDatos.TABLE_MASCOTA+"("+ConstantesBaseDatos.TABLE_MASCOTA_ID+")"+
                ")";
        db.execSQL(queryTablaMascota);
        db.execSQL(queryTablaLikes);
        cargarDatos(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ ConstantesBaseDatos.TABLE_MASCOTA);
        db.execSQL("DROP TABLE IF EXISTS "+ ConstantesBaseDatos.TABLE_LIKES_MASCOTA);
        onCreate(db);

    }
    public void cargarDatos(SQLiteDatabase db){
        db.execSQL("INSERT INTO "+ConstantesBaseDatos.TABLE_MASCOTA+" VALUES(NULL,'Gucci',"+ R.drawable.puppy1+",0)");
        db.execSQL("INSERT INTO "+ConstantesBaseDatos.TABLE_MASCOTA+" VALUES(NULL,'Norton',"+ R.drawable.puppy2+",0)");
        db.execSQL("INSERT INTO "+ConstantesBaseDatos.TABLE_MASCOTA+" VALUES(NULL,'Bolt',"+ R.drawable.puppy3+",0)");
        db.execSQL("INSERT INTO "+ConstantesBaseDatos.TABLE_MASCOTA+" VALUES(NULL,'Toby',"+ R.drawable.puppy4+",0)");
        db.execSQL("INSERT INTO "+ConstantesBaseDatos.TABLE_MASCOTA+" VALUES(NULL,'Cora',"+ R.drawable.puppy5+",0)");
        db.execSQL("INSERT INTO "+ConstantesBaseDatos.TABLE_MASCOTA+" VALUES(NULL,'Ro0ny',"+ R.drawable.puppy6+",0)");

    }

    public ArrayList<Mascota> obtenerMascotas(){
        ArrayList<Mascota> mascotas=new ArrayList<>();
        String query="SELECT * FROM "+ConstantesBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        while (cursor.moveToNext()){
            Mascota mascotaActual=new Mascota();
            mascotaActual.setIdMascota(cursor.getInt(0));
            mascotaActual.setNombreMascota(cursor.getString(1));
            mascotaActual.setFotoMascota(cursor.getInt(2));
            mascotaActual.setFavorito(cursor.getInt(3)==1);

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_NUMERO+") as likes " +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA + "=" + mascotaActual.getIdMascota();
            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setCantidadRaiteada(registrosLikes.getInt(0));
            }else {
                mascotaActual.setCantidadRaiteada(0);
            }

            mascotas.add(mascotaActual);
        }
        cursor.close();

        db.close();
        return mascotas;
    }
    public  void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA,null,contentValues);
        db.close();
    }
    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTA, null, contentValues);
        db.close();
    }
    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;

        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_NUMERO+")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA + "="+ mascota.getIdMascota();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor= db.rawQuery(query, null);

        if (cursor.moveToNext()){
            likes = cursor.getInt(0);
        }

        db.close();

        return likes;
    }

    public ArrayList<Integer> obtenerUltimos5Likes() {
        String queryFavoritos="SELECT "+ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA +" FROM "+ConstantesBaseDatos.TABLE_LIKES_MASCOTA+
                                " ORDER BY "+ConstantesBaseDatos.TABLE_LIKES_ID+" DESC LIMIT 5";
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor=db.rawQuery(queryFavoritos,null);
        ArrayList<Integer> id_mascotas=new ArrayList<>();
        while (cursor.moveToNext()){
            id_mascotas.add(cursor.getInt(0));
        }
        db.close();
        return id_mascotas;
    }
    /*
    public void switchFavorito(ContentValues contentValues, Mascota mascota){
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(ConstantesBaseDatos.TABLE_MASCOTA,contentValues,ConstantesBaseDatos.TABLE_MASCOTA_ID+"="+mascota.getIdMascota(),null);
        db.close();
    }*/


}
