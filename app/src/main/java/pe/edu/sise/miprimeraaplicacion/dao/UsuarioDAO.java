package pe.edu.sise.miprimeraaplicacion.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import pe.edu.sise.miprimeraaplicacion.domain.Usuario;
import pe.edu.sise.miprimeraaplicacion.respository.UsuarioSQLiteHelper;

/**
 * Created by cisco on 13/10/2017.
 */

public class UsuarioDAO {

    private Context context;

    public  UsuarioDAO(Context context){
        this.context = context;
    }

    public UsuarioSQLiteHelper conectarUsuarioHelper(){
        UsuarioSQLiteHelper usuarioHelper =
                new UsuarioSQLiteHelper(context,
                        "db_usuarios", null, 1);
        return usuarioHelper;
    }

    public boolean insertarUsuario(Usuario usuario){
        // Guardar la información en la Base de datos.
        SQLiteDatabase db = conectarUsuarioHelper().getWritableDatabase();
        if(db != null){
            db.execSQL("INSERT INTO Usuario (id, nombre, email," +
                    "telefono, sexo) VALUES (" +
                    "'"+usuario.getId()+"','"+usuario.getNombre()+"'" +
                    ",'"+usuario.getEmail()+"','"+usuario.getTelefono()+"'," +
                    "'"+usuario.getSexo()+"') ");
            db.close();
            return true;
        }
        return false;
    }
}
