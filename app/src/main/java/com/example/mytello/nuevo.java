package com.example.mytello;

import static com.example.mytello.R.layout.fragment_conf_orden;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class nuevo extends AppCompatActivity {

    private Object guardar;
    private Object nombre;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevo);


           // guardar = view.findViewById(R.id.guardar);
            //nombre = view.findViewById(R.id.nombre);


        Button guardar = findViewById(R.id.guardar);;
            guardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), lista_ordenes.class);
                    startActivityForResult(intent, 0);
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

