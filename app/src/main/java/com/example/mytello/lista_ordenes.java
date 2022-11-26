package com.example.mytello;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;

import java.util.ArrayList;

public class lista_ordenes extends AppCompatActivity {

    private Button up,down,left,right,forward,back,cw,ccw,flip,speed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_ordenes);
//crear ordenes, 1era, 2da..etc.. y mostrarlos en un fragment en este layout,
// confirmar para poder añadirlo en el layout en la activity "Nuevo" con un fragment.




     /*   Button up = findViewById(R.id.guardar_orden);
        Button down = findViewById(R.id.guardar_orden);
        Button left = findViewById(R.id.guardar_orden);
        Button right = findViewById(R.id.guardar_orden);
        Button forward = findViewById(R.id.guardar_orden);
        Button back = findViewById(R.id.guardar_orden);
        Button cw = findViewById(R.id.guardar_orden);
        Button ccw = findViewById(R.id.guardar_orden);
        Button flip = findViewById(R.id.guardar_orden);
        Button speed = findViewById(R.id.guardar_orden);

*/

    }
}