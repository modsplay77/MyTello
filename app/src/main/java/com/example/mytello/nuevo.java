package com.example.mytello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class nuevo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevo);

        Button anadir = findViewById(R.id.añadir);
        //Button borrar = findViewById(R.id.borrar);
        //Button ordenar = findViewById(R.id.ordenar);

        anadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), lista_ordenes.class);
                startActivityForResult(intent, 0);
                setContentView(R.layout.lista_ordenes);
            }
        });

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
}
