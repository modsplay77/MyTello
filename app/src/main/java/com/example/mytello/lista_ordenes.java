package com.example.mytello;

import android.content.Intent;
import android.os.Bundle;
import android.provider.BaseColumns;
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


        setContentView(R.id.pro_actual);


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
    public final class FeedReaderContract {
        // To prevent someone from accidentally instantiating the contract class,
        // make the constructor private.
        private FeedReaderContract() {}

        /* Inner class that defines the table contents */
        public class FeedEntry implements BaseColumns {
            public static final String TABLE_NAME = "entry";
            public static final String COLUMN_NAME_TITLE = "title";
            public static final String COLUMN_NAME_SUBTITLE = "subtitle";
        }
    }
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedReaderContract.FeedEntry.TABLE_NAME + " (" +
                    FeedReaderContract.FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE + " TEXT," +
                    FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedReaderContract.FeedEntry.TABLE_NAME;


}