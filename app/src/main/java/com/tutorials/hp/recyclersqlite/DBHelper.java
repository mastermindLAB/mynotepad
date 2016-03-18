package com.tutorials.hp.recyclersqlite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Hp on 3/17/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, Contants.DB_NAME, null, Contants.DB_VERSION);
    }

    //WHEN TB IS CREATED
    @Override
    public void onCreate(SQLiteDatabase db) {
        try
        {
            db.execSQL(Contants.CREATE_TB);

        }catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    //UPGRADE TB
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS"+Contants.TB_NAME);
        onCreate(db);
    }
}
