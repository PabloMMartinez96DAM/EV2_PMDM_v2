package com.pablo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pablo.R;
import com.pablo.models.UserModel;
import com.pablo.persistence.IDAOUser;

public class LoginActivity extends AppCompatActivity {

    //Componentes de la interfaz
    private EditText userTxt;
    private EditText passTxt;
    private Button loginBtn;

    //Dependencias
    private IDAOUser daoUser = IDAOUser.getInstance();
    private Context _context;



    //Método que se ejecuta al crear esta activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Asignamos el xml que define los componentes de la interfaz
        setContentView(R.layout.activity_login);

        //Indicamos que el contexto de la aplicación va a ser la propia Activity
        _context = this;

        //Asignamos los componentes en funcion del ID que se le ha dado en el xml
        userTxt = findViewById(R.id.txtUsuario);
        passTxt = findViewById(R.id.txtPassword);
        loginBtn = findViewById(R.id.btnLogin);

        //Le damos una implementación a la interfaz View.OnClickListener() cuando pulsamos el botón
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Obtenemos el input del usuario de los EditText correspondientes
                String userName = userTxt.getText().toString();
                String password = passTxt.getText().toString();

                //Intentamos hacer el login
                UserModel user = daoUser.login(userName,password);

                //Si el usuario ha podido loguearse devolverá un usuario, en caso contrario devuelve null
                if(user != null){

                    //Creamos una intención para navegar al MainActivity pasandole el contexto actual de la aplicación
                    Intent mainIntent = new Intent(_context,MainActivity.class);

                    //Añadimos el usuario al intent para poder acceder a el desde la otra actividad
                    mainIntent.putExtra("user",user);

                    //Iniciamos la navegación
                    startActivity(mainIntent);
                }else{
                    //Logueamos dentro de la aplicación para darle feedback al usuario
                    Toast.makeText(LoginActivity.this, "Login o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                 }

            }
        });

    }
}