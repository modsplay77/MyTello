package com.example.mytello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.w3c.dom.Text;

public class add_orden extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_orden);
        Button boton = findViewById(R.id.guardar);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), add_orden.class);
                startActivityForResult(intent, 0);
                // añadir funcion para guardar los datos introducidos por el usuario
                Toast.makeText(add_orden.this, "Guardado con éxito", Toast.LENGTH_SHORT).show();
            }
        });




            }


    }
