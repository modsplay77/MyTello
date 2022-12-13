package com.example.mytello;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class inicio extends AppCompatActivity {
//acciones
    public static final int NEW_ITEM =1;
    public static final int EDIT_ITEM =2;
    public static final int SHOW_ITEM =3;
//elementos seleccionados
    public static DataBaseHelper mDbHelper = null;
    TextView mTView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        Button nuevo = findViewById(R.id.nuevo);
        nuevo.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
            Intent intent = new Intent(nuevo.this,nuevo.class);
            startActivityForResult(intent, NEW_ITEM);
            }
        });
       /* Button cargar = findViewById(R.id.cargar);
        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), cargar.class);
                startActivityForResult(intent, 0);
            }
        });*/

    }


}