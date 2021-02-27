package com.virsantillan1.mascotas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EnviarComentario extends AppCompatActivity {
    Button btn1;
    EditText nombre;
    EditText email;
    EditText mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacto);

        nombre = findViewById(R.id.inputNombre);
        email = findViewById(R.id.inputEmail);
        mensaje =  findViewById(R.id.inputMensaje);

    }


        public void onClick(View v)
        {
            String enviarCorreo = email.getText().toString();
            String enviarMensaje = mensaje.getText().toString();

            // Defino mi Intent y hago uso del objeto ACTION_SEND
            Intent intent = new Intent(Intent.ACTION_SEND);

            // Defino los Strings Email, Asunto y Mensaje con la función putExtra
            intent.putExtra(Intent.EXTRA_EMAIL,
                    new String[] { enviarCorreo });
            intent.putExtra(Intent.EXTRA_TEXT, enviarMensaje);

            // Establezco el tipo de Intent
            intent.setType("message/rfc822");

            // Lanzo el selector de cliente de Correo
            startActivity(
                    Intent
                            .createChooser(intent,
                                    "Elije un cliente de Correo:"));
        }
    }
