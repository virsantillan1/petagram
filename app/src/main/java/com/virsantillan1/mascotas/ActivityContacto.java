package com.virsantillan1.mascotas;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.virsantillan1.mascotas.javaMail.JavaMailAPI;

public class ActivityContacto extends AppCompatActivity {

    EditText nombre;
    EditText email;
    EditText mensaje;
    TextView asunto;
    Button btn1;
    String sEmail, sPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacto);
        nombre = findViewById(R.id.inputNombre);
        email = findViewById(R.id.inputEmail);
        asunto = findViewById(R.id.asunto);
        mensaje = findViewById(R.id.inputMensaje);
        btn1 = findViewById(R.id.btn1);

        Toolbar toolbar;
        toolbar = findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);


        /* btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String enviarEmail = email.getText().toString();
                String enviarAsunto = asunto.getText().toString();
                String enviarMensaje = mensaje.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);


                intent.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{enviarEmail});

                intent.putExtra(Intent.EXTRA_SUBJECT, enviarAsunto);
                intent.putExtra(Intent.EXTRA_TEXT, enviarMensaje);

                intent.setType("message/rfc822");


                startActivity(Intent.createChooser(intent, "Elije un cliente de Correo"));

                finish();
            }

        }); */


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(ActivityContacto.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

    private void sendMail() {
        String mMail = email.getText().toString().trim();
        String mMensaje = mensaje.getText().toString();
        String mAsunto = nombre.getText().toString().trim();

        JavaMailAPI javaMailAPI = new JavaMailAPI(this, mMail,mMensaje,mAsunto);
        javaMailAPI.execute();
    }
}

