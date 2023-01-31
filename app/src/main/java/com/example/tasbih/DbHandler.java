package com.example.tasbih;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

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
                + COLUMN_Astaghfar + " TEXT,"
                + COLUMN_Astaghfar_Count +" TEXT,"
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
    public List<Tasbih> selectAllTasbih() {
        List<Tasbih> tasbih = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);


        if (cursor.moveToFirst()) {
            do {

                @SuppressLint("Range") String kalma = cursor.getString(cursor.getColumnIndex(COLUMN_Kalma));
                @SuppressLint("Range") String kalmaCount = cursor.getString(cursor.getColumnIndex(COLUMN_Kalma_Count));
                @SuppressLint("Range") String darood = cursor.getString(cursor.getColumnIndex(COLUMN_Darood));
                @SuppressLint("Range") String daroodCount = cursor.getString(cursor.getColumnIndex(COLUMN_Darood_Count));
                @SuppressLint("Range") String astaghfar = cursor.getString(cursor.getColumnIndex(COLUMN_Astaghfar));
                @SuppressLint("Range") String astaghfarCount = cursor.getString(cursor.getColumnIndex(COLUMN_Astaghfar_Count));
                @SuppressLint("Range") String myDate = cursor.getString(cursor.getColumnIndex(COLUMN_Date));

                tasbih.add(new Tasbih(kalma,kalmaCount,darood,daroodCount,astaghfar,astaghfarCount,myDate));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return tasbih;
    }

}
