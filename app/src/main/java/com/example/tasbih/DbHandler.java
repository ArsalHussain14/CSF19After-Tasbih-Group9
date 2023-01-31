package com.example.tasbih;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "tasbih.db";
    private static final String TABLE_NAME = "tasbih";

    private static final String COLUMN_Kalma = "kalma";
    private static final String COLUMN_Kalma_Count = "kalmaCount";
    private static final String COLUMN_Darood = "darood";
    private static final String COLUMN_Darood_Count = "daroodCount";
    private static final String COLUMN_Astaghfar = "astaghfar";
    private static final String COLUMN_Astaghfar_Count = "astaghfarCount";
    private static final String COLUMN_Date = "date";


    public DbHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + COLUMN_Kalma + " TEXT,"
                + COLUMN_Kalma_Count + " TEXT,"
                + COLUMN_Darood + " TEXT,"
                + COLUMN_Darood_Count + " TEXT,"
                + COLUMN_Astaghfar + "TEXT,"
                + COLUMN_Astaghfar_Count +"INETEGER,"
                + COLUMN_Date +" TEXT"
                + ")";
        sqLiteDatabase.execSQL(query);

    }

    public void insertTasbih(Tasbih tasbih)
    {
        SQLiteDatabase db= this.getWritableDatabase();  //first we have to do this
        //then create content vlaues
        ContentValues values= new ContentValues();
        // insert teacher's data in values variable

        values.put(COLUMN_Kalma, tasbih.getKalm());
        values.put(COLUMN_Kalma_Count, tasbih.getKalmaCount());
        values.put(COLUMN_Darood, tasbih.getDarood());
        values.put(COLUMN_Darood_Count, tasbih.getDaroodCount());
        values.put(COLUMN_Astaghfar, tasbih.getAstaghfar());
        values.put(COLUMN_Astaghfar_Count, tasbih.getAstaghfarCount());
        values.put(COLUMN_Date, tasbih.getDate());


        //now run insert command
        db.insert(TABLE_NAME,null, values);
        db.close();



    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
