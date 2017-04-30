package com.calitech.cliente_isw2;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by jquin on 30-04-2017.
 */

public class BackgroundTask extends AsyncTask<String, Void, String> {

    Context ctx;

    public BackgroundTask( Context ctx){
        this.ctx = ctx;
    }
    @Override
    protected String doInBackground(String... params) {

        //Se deben cambiar las URLs actualmente estan conectadas al localhost.
        String registro_url = "http://10.0.2.2/ProyectosXampp/ClienteIsw2Services/cliente_registro.php";
        String login_url = "http://10.0.2.2/ProyectosXampp/ClienteIsw2Services/cliente_login.php";

        String method = params[0];

        if(method.equals("register")){
            String nombre = params[1];
            String usuario = params[2];
            String clave = params[3];
            String correo = params[4];

            try {
                URL url = new URL(registro_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("nombre","UTF-8") +
                        "=" + URLEncoder.encode(nombre, "UTF-8")
                        + "&" + URLEncoder.encode("usuario","UTF-8") +
                        "=" + URLEncoder.encode(usuario, "UTF-8")
                        + "&" + URLEncoder.encode("clave","UTF-8") +
                        "=" + URLEncoder.encode(clave, "UTF-8")
                        + "&" + URLEncoder.encode("correo","UTF-8") +
                        "=" + URLEncoder.encode(correo, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Resgitration Succes...";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
    }
}
