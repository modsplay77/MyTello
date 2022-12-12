package com.example.mytello;

import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class lista_ordenes extends AppCompatActivity {
    TextView pro_actual;
     String nombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_ordenes);
        datos();

    }

    private void datos() {
        Bundle extras = getIntent().getExtras();

        String datos= extras.putString(nombre);
        pro_actual = (TextView) findViewById(R.id.proyecto);
        pro_actual.setText(datos);
    }





}