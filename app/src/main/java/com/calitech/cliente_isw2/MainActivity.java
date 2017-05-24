package com.calitech.cliente_isw2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

public class MainActivity extends AppCompatActivity
       implements NavigationView.OnNavigationItemSelectedListener {

    private EditText edtCorreo, edtClave;
    private Button btnIniciarSesion, btnRegistrarse, btnOmitirLogin;
    private String login_correo, login_clave;

    private String[] paises={"Argentina","Chile","Paraguay","Bolivia","Peru",
            "Ecuador","Brasil","Colombia","Venezuela","Uruguay"};
    private ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

    //************
/*
        lv1 =(ListView)findViewById(R.id.list1);
        ArrayAdapter <String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, paises);
/*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Agregar lugar a itinerario", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

*/
        //***********

        edtClave = (EditText) findViewById(R.id.edtLoginClave);
        edtCorreo = (EditText) findViewById(R.id.edtLoginCorreo);
        btnIniciarSesion = (Button) findViewById(R.id.btnLoginIniciarSesion);
        btnRegistrarse = (Button) findViewById(R.id.btnLoginRegistrarse);
        btnOmitirLogin = (Button) findViewById(R.id.btnOmitirLogin);
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
        btnOmitirLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Omitir(v);
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
    public void Omitir(View v){
        //startActivity(new Intent(this,resultado_lugares.class));
        setContentView(R.layout.content_main);
        setContentView(R.layout.app_bar_main);
    }

/*
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")

*/
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.perfil) {
            // Handle the camera action
        } else if (id == R.id.ajustes) {

        }
        else if (id == R.id.categoria1) {

        }
        else if (id == R.id.categoria2) {

        }
        else if (id == R.id.categoria3) {

        }
        else if (id == R.id.categoria4) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}

