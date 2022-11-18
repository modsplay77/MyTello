package com.example.mytello;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        Button nuevo = findViewById(R.id.proyecto);
        nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), nuevo.class);
                startActivityForResult(intent, 0);
            }
        });
        Button cargar = findViewById(R.id.cargar);
        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), cargar.class);
                startActivityForResult(intent, 0);
            }
        });

    }


}