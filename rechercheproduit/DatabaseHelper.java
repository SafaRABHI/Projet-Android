package com.example.packardbell.rechercheproduit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by packard bell on 19/11/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATEBASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    static final String COLUMN_ID = "id";
    static final String COLUMN_NAME = "name";
    static final String COLUMN_EMAIL = "email";
    static final String COLUMN_UNAME = "uname";
    static final String COLUMN_PASS = "pass";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table contacts ( id integer primary key not null auto_increment , " + " name text not null , email text not null , uname text not null , pass text not null);";

    public DatabaseHelper(Context context) {
        super(context,DATEBASE_NAME,null,DATABASE_VERSION);
    }

    public void insertContact(Contact c)
    {

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,c.getName());
        values.put(COLUMN_EMAIL,c.getEmail());
        values.put(COLUMN_UNAME,c.getUname());
        values.put(COLUMN_PASS,c.getPass());
        db.insert(TABLE_NAME,null,values);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public String searchPass(String uname)
    {
        db = this.getReadableDatabase();
        String query = "select uname,pass from" +TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a,b;
        b="not found";
        if (cursor.moveToFirst())
        {
            do
            {
                a=cursor.getString(0);
                if (a.equals(uname))
                {
                    b=cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = " DROP TABLE IF EXISTS " +TABLE_NAME ;
        db.execSQL(query);
        this.onCreate(db);

    }
}
