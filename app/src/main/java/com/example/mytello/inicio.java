package com.example.mytello;

import static android.widget.Toast.LENGTH_SHORT;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class inicio extends AppCompatActivity {
//acciones
    public static final int NEW_ITEM =1;
    public static final int EDIT_ITEM =2;
    public static final int SHOW_ITEM =3;
//elementos seleccionados
    public static DataBaseHelper mDbHelper = null;
    TextView mTView = null;
    private DataBaseHelper mDHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
       mTView = (TextView) findViewById(R.id.listar);
        //abrir BD
        mDHelper = new DataBaseHelper(this);
        try {
            fillData();
        } catch (SQLException e) {
            e.printStackTrace();
            showMessage(R.string.dataError);
        }

        Button nuevo = findViewById(R.id.nuevo);
        nuevo.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
            Intent intent = new Intent(inicio.this,nuevo.class);
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
    private void showMessage(int message){
        Toast.makeText(getApplicationContext(), getResources().getString(message),
                LENGTH_SHORT) .show();
    }
    private <ListEntry> void fillData() throws SQLException{
        //se abre la BD y se obtienen los elementos
        mDbHelper.open();
        Cursor itemCursor = mDbHelper.getItems();
        ListEntry item = null;
        ArrayList<ListEntry> resultList = new ArrayList<ListEntry>();
        //se procesa el resultado
        while (itemCursor.moveToNext()){
            int id = itemCursor.getInt(itemCursor.getColumnIndex(DataBaseHelper.SL_ID));
            String nombre = itemCursor.getString(itemCursor.getColumnIndex(DataBaseHelper.SL_NOMBRE));
            int prioridad = itemCursor.getInt(itemCursor.getColumnIndex(DataBaseHelper.SL_PIORIDAD));
            String orden = itemCursor.getString(itemCursor.getColumnIndex(DataBaseHelper.SL_ORDEN));
            int valor = itemCursor.getInt(itemCursor.getColumnIndex(DataBaseHelper.SL_VALOR));
            item = new ListEntry();
            item.id = id;
            item.nombre = nombre;
            item.prioridad = prioridad;
            item.orden = orden;
            item.valor = valor;
            resultList.add(item);
        }
        //cerramos la BD
        itemCursor.close();
        mDbHelper.close();

        //se genera el adaptador
        final ItemAdapter adapter = new ItemAdapter(resultList);
        //asignar adaptador a la lista
        mTView.setAdapter(adapter);
        //asignar layoutmanager
        mTView.setLayoutParams(
                new LinearLayout(this,LinearLayout.VERTICAL, false));


    }



}