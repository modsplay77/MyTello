package com.example.mytello;

import static android.widget.Toast.LENGTH_SHORT;

import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class inicio extends AppCompatActivity {
    private class ListEntry{
        int id;
        String nombre;
        int prioridad;
        String orden;
        int valor;

    }
    //acciones
    public static final int NEW_ITEM=1;
    public static final int EDIT_ITEM=2;
    public static final int SHOW_ITEM=3;

    //elemento seleccionado
    public static DataBaseHelper mDbHelper = null;
    TextView mTextView =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
       mTextView = (TextView) findViewById(R.id.listar);
        //abrir BD
        mDbHelper = new DataBaseHelper(this);
        try {
            fillData();
        } catch (SQLException e) {
            e.printStackTrace();
          //  showMessage(R.string.dataError);
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
                Toast.LENGTH_SHORT) .show();
    }
    private void fillData() throws SQLException{
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
            item = new List();
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
        mTextView.setAdapter(adapter);
        //asignar layoutmanager
        mTextView.setLayoutParams(
                new LinearLayout(this,LinearLayout.VERTICAL, false));


    }



}

public class ItemAdapter implements ListAdapter {
    private class ListEntry{
        int id;
        String nombre;
        int prioridad;
        String orden;
        int valor;

    }
    private ArrayList<ListEntry> mData;
    public ItemAdapter(ArrayList<List> data){

        this.mData = data;
    }
    @Override
    public MenuView.ItemView onCreateView(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_ordenes, parent, false);
        MenuView.ItemView ivh = new MenuView.ItemView(itemView) {
            @Override
            public void initialize(MenuItemImpl menuItem, int i) {

            }

            @Override
            public MenuItemImpl getItemData() {
                return null;
            }

            @Override
            public void setTitle(CharSequence charSequence) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public void setCheckable(boolean b) {

            }

            @Override
            public void setChecked(boolean b) {

            }

            @Override
            public void setShortcut(boolean b, char c) {

            }

            @Override
            public void setIcon(Drawable drawable) {

            }

            @Override
            public boolean prefersCondensedTitle() {
                return false;
            }

            @Override
            public boolean showsIcon() {
                return false;
            }
        };
        return ivh;
    }
            @Override
            public void onBindView(MenuView.ItemView holder, int position) {
                List item = mData.get(position);
                holder.getItemData(item);
            }
            @Override
    public int getItemCount(){
        return mData.size()
            }


}
