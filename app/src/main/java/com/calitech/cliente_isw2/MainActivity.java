package com.calitech.cliente_isw2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtCorreo, edtClave;
    private Button btnIniciarSesion, btnRegistrarse;
    private String login_correo, login_clave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtClave = (EditText)findViewById(R.id.edtLoginClave);
        edtCorreo = (EditText)findViewById(R.id.edtLoginCorreo);
        btnIniciarSesion = (Button) findViewById(R.id.btnLoginIniciarSesion);
        btnRegistrarse = (Button) findViewById(R.id.btnLoginRegistrarse);
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserRegistration(v);
            }
        });
        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserLogin(v);
            }
        });
    }


    public void UserLogin(View view){
        login_correo = edtCorreo.getText().toString();
        login_clave = edtClave.getText().toString();
        String method = "login";

        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, login_correo,login_clave);
    }



    public void UserRegistration(View v){
        startActivity(new Intent(this,Registro.class));
    }
}
