package com.example.mytello;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper {
    private Context mCtx = null;
    private DataBaseHelperInternal mDbHelper = null;
    private SQLiteDatabase mDb = null;
    private static final String DATABASE_NAME= "PLANES";
    private static final int DATABASE_VERSION = 1;

    //tabla y campos
    private static final String DATABASE_TABLE_PLANES = "Planes";
    public static final String SL_ID ="_id";
    public static final String SL_NOMBRE ="nombre";
    public static final String SL_PIORIDAD ="Prioridad";
    public static final String SL_ORDEN ="orden";
    public static final String SL_VALOR ="valor";

    //SQL de creación de la tabla
    private static final String DATABASE_CREATE_PLANES =
            "create table "+ DATABASE_TABLE_PLANES +" ("+SL_ID+" integer primary key,+"+SL_NOMBRE+" text not null, "+SL_PIORIDAD+" integer not null,"+SL_ORDEN+"text not null, "+SL_VALOR+" integer not null)";

    //constructor
    public DataBaseHelper (Context ctx){
        this.mCtx = ctx;
    }

    //clase privada para control de SQL
    private static class DataBaseHelperInternal extends SQLiteOpenHelper{
        public DataBaseHelperInternal(Context context) {
            super(context,DATABASE_NAME, null, DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            createTables (db);

        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            deleteTables(db);
            createTables(db);

        }

        private void deleteTables(SQLiteDatabase db) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_PLANES);
        }

        private void createTables(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE_PLANES);
        }

    }
    public DataBaseHelper open() throws SQLException{
        mDbHelper = new DataBaseHelperInternal(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }
    public void close(){
        mDbHelper.close();
    }

    //obtener el contenido de todos los campos
    public Cursor getItems(){
        return mDb.query(DATABASE_TABLE_PLANES, new String[] {SL_ID, SL_NOMBRE, SL_PIORIDAD, SL_ORDEN, SL_VALOR
        },null, null, SL_PIORIDAD, null, null);
    }
    //crear elemento
    public long inserItem(String nombre, String prioridad, String orden, String valor, int i){
        ContentValues initialValues = new ContentValues();
        initialValues.put(SL_NOMBRE, nombre);
        initialValues.put(SL_PIORIDAD, prioridad);
        initialValues.put(SL_ORDEN, orden);
        initialValues.put(SL_VALOR, valor);
        return mDb.insert(DATABASE_TABLE_PLANES, null, initialValues);
    }


}
