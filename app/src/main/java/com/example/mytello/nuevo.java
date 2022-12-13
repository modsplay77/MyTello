package com.example.mytello;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class nuevo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevo);

        Button guardar = findViewById(R.id.guardar);
            guardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText nombre = (EditText) findViewById(R.id.nombre);
                    Log.d("nombre",nombre.getText().toString());

                }
            });

        }

        //Button borrar = findViewById(R.id.borrar);
        //Button ordenar = findViewById(R.id.ordenar);



    /*    borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), nuevo.class);
                startActivityForResult(intent, 0);
                setContentView(R.id.fragment);
            }
        });
        ordenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), nuevo.class);
                startActivityForResult(intent, 0);
                setContentView(R.layout.nuevo);
            }
        });*/
    }

