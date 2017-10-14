package pe.edu.sise.miprimeraaplicacion;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import pe.edu.sise.miprimeraaplicacion.dao.UsuarioDAO;
import pe.edu.sise.miprimeraaplicacion.domain.Usuario;
import pe.edu.sise.miprimeraaplicacion.respository.UsuarioSQLiteHelper;

public class MainActivity extends AppCompatActivity {

    protected Button btn_enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_enviar = (Button) findViewById(R.id.btnGuardar);
        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            guardarDatosUsuario();
            }
        });
    }

    public void guardarDatosUsuario(){
        EditText txtNombre = (EditText) findViewById(R.id.txtName);
        EditText txtEmail = (EditText) findViewById(R.id.txtEmail);
        EditText txtTelefono = (EditText) findViewById(R.id.txtTelefono);
        RadioButton rb_masculino = (RadioButton) findViewById(R.id.rbMasculino);
        RadioButton rb_femenino = (RadioButton) findViewById(R.id.rbFemenino);
        int sexo = 0;
        if(rb_masculino.isChecked()){
            sexo = 1;
        }else if(rb_femenino.isChecked()){
            sexo = 2;
        }
        Usuario usuario = new Usuario();
        usuario.setId(2L);
        usuario.setNombre(txtNombre.getText().toString());
        usuario.setEmail(txtEmail.getText().toString());
        usuario.setTelefono(txtTelefono.getText().toString());
        usuario.setSexo(sexo);
        UsuarioDAO usuarioDAO = new UsuarioDAO(getApplicationContext());
        boolean respuesta = usuarioDAO.insertarUsuario(usuario);
        if(respuesta){
            Toast.makeText(getApplicationContext(),
                    "Datos Guardados Correctamente",
                    Toast.LENGTH_LONG).show();
        }
    }
}
