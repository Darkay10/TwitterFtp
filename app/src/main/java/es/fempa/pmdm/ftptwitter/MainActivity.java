package es.fempa.pmdm.ftptwitter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText eUsu;
    EditText ePunt;
    Button bEnv;
    MyAsyncTask mat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eUsu = findViewById(R.id.eUsuario);
        ePunt = findViewById(R.id.ePuntuacion);
        bEnv = findViewById(R.id.bEnviar);

    }

    public void enviar (View v) {
        String u = eUsu.getText().toString();
        String p = ePunt.getText().toString();

        if (p.equals("") || u.equals("")) {
            toastRespuesta("Has dejado algún campo vacío");
        }
        else {
            mat = new MyAsyncTask(this, Integer.parseInt(p), u);
            mat.execute();
        }
    }

    public void toastRespuesta (String texto) {
        Toast res = Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_SHORT);
        res.show();
    }

}
