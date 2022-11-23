package com.example.mytello;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class add_orden extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_orden);
        Button boton = findViewById(R.id.guardar);
        EditText orden;
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
        orden = this.<EditText>findViewById(R.id.op1);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String op1 = orden.getText().toString();

                Intent intent = new Intent(add_orden.this, mostrar_datos.class);

                // añadir funcion para guardar los datos introducidos por el usuario
                intent.putExtra("Orden", op1);
                startActivityForResult(intent, 0);
                Toast.makeText(add_orden.this, "Guardado con éxito", Toast.LENGTH_SHORT).show();
            }
        });



    }


    }

