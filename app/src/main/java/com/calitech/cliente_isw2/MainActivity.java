package com.calitech.cliente_isw2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtCorreo;
    private EditText edtClave;

    private Button btnIniciarSesion;
    private Button btnRegistrarse;


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
                UserLogin(v);
            }
        });
    }


    public void UserLogin(View view){
        startActivity(new Intent(this,Registro.class));
    }
    public void UserRegistration(){

    }
}
