package es.fempa.pmdm.ftptwitter;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;

import org.apache.commons.net.ftp.FTPClient;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyAsyncTask extends AsyncTask<Integer, String, Boolean> {

    FTPClient ftp;
    String user, pass, ip, tw;
    int puntos;
    MainActivity ma;
    TwitPuntos tp;

    public MyAsyncTask(MainActivity a, int p, String u){
        ma = a;
        ftp= new FTPClient();
        ip = "files.000webhost.com";
        user = "ftptwit";
        pass = "12345678a";
        puntos=p;
        tw=u;

    }

    @Override
    protected void onPostExecute(Boolean b) {

        super.onPostExecute(b);
    }

    @Override
    protected void onPreExecute() {

        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(String... values) {
        Toast.makeText(this.ma.getApplicationContext(), values[0], Toast.LENGTH_SHORT).show();
        super.onProgressUpdate(values);
    }

    @Override
    protected Boolean doInBackground(Integer... integers) {
        try {
            ftp.connect(ip, 21);
            Boolean login=ftp.login(user,pass);
            ftp.changeWorkingDirectory("/ftptwit");
            publishProgress("Comprobando puntuación...");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String archivo = "puntuacion.txt";
        String puntuacion = "";
        try {
            ByteArrayOutputStream fs = new ByteArrayOutputStream();
            ftp.retrieveFile(archivo, fs);
            puntuacion = new String(fs.toByteArray());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int puntosInt = Integer.parseInt(puntuacion);

        if(puntosInt<puntos){
            publishProgress("¡Ganaste! Echa un vistazo a Twitter");
            String puntosString = Integer.toString(puntos);
            InputStream targetStream = new ByteArrayInputStream(puntosString.getBytes());
            try {
                boolean uploadFile = ftp.storeFile(archivo,targetStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            tp= new TwitPuntos();
            tp.tweetPoints(puntos, tw);
        }
        else{
            publishProgress("No superaste el máximo, vuelve a intentarlo");
        }


        return true;
    }
}