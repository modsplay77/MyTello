package com.example.mytello;

import static android.widget.Toast.*;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class nuevo extends AppCompatActivity {
//referencias a elementos de pantalla
    TextView mNom = null;
    TextView mPrio = null;
    TextView mOrden = null;
    TextView mValor = null;

//identificador de entrada
Integer mRowId = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevo);

        Button guardar = findViewById(R.id.guardar);
        guardar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                saveData();
                finish();
            }
        });
        //obtener referencias
        mNom = (TextView) findViewById(R.id.nombre);
        mPrio = (TextView) findViewById(R.id.prioridad);
        mOrden = (TextView) findViewById(R.id.orden);
        mValor = (TextView) findViewById(R.id.valor);
    }

    protected void saveData() {
        //obtener datos
        String nomText = mNom.getText().toString();
        String prioText = mPrio.getText().toString();
        String ordenText = mOrden.getText().toString();
        String valorText = mValor.getText().toString();

        //insertar
        try{
            inicio.mDbHelper.open();
            inicio.mDbHelper.inserItem(nomText, prioText, ordenText,valorText,Integer.parseInt(ordenText));
            inicio.mDbHelper.close();
        } catch (SQLException e) {
            e.printStackTrace();
            //showMessage(R.id.dataError);
        }
    }
    private void showMessage(int message){
        Toast.makeText(getApplicationContext(), getResources().getString(message),
                LENGTH_SHORT) .show();
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

