package com.example.mytello;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class add_orden extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_orden);

        /*Listado de ordenes posibles
        arriva
        abajo
        giro positivo
        giro negativo
        flip izq
        flip der
        adelante
        atras
        */
        Button up = findViewById(R.id.añadir);

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), add_orden.class);
                startActivityForResult(intent, 0);
                setContentView(R.layout.add_orden);
            }
        });


    }


    }


