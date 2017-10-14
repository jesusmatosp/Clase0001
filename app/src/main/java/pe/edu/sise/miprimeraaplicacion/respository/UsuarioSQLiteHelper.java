package pe.edu.sise.miprimeraaplicacion.respository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by cisco on 13/10/2017.
 */

public class UsuarioSQLiteHelper extends SQLiteOpenHelper {

    // 1. Definir la estructura de las tablas:
    String sqlCreate = "CREATE TABLE Usuario (id Integer, " +
            "nombre TEXT, email TEXT, telefono TEXT, sexo Integer) ";

    public UsuarioSQLiteHelper(Context context,
                               String name,
                               SQLiteDatabase.CursorFactory factory,
                               int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST Usuario");
        db.execSQL(sqlCreate);
    }
}
