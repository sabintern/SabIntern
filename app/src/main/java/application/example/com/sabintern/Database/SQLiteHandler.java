package application.example.com.sabintern.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashMap;

import static application.example.com.sabintern.Database.UserContract.UserEntry.COLUMN_EMAIL;
import static application.example.com.sabintern.Database.UserContract.UserEntry.COLUMN_MOBILE;
import static application.example.com.sabintern.Database.UserContract.UserEntry.COLUMN_NAME;
import static application.example.com.sabintern.Database.UserContract.UserEntry.TABLE_NAME;
import static application.example.com.sabintern.Database.UserContract.UserEntry.USER_ID;

/**
 * Created by Dell on 10-01-2018.
 */

public class SQLiteHandler extends SQLiteOpenHelper {
    private static final String TAG = SQLiteHandler.class.getSimpleName();

    public static final String DATABASE_NAME = "user.db";
    public static final int DATABASE_VERSION = 1;
    public SQLiteHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_USER_ENTRIES = " CREATE TABLE " + TABLE_NAME +
                " ( " + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT NOT NULL, "
                + COLUMN_EMAIL + " TEXT NOT NULL, "
                + COLUMN_MOBILE + " TEXT NOT NULL "
                + " );";
        db.execSQL(SQL_CREATE_USER_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);


    }

    public void addUser(String user_id, String user_name, String user_email, String user_mobile){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_ID, user_id);
        contentValues.put(COLUMN_NAME, user_name);
        contentValues.put(COLUMN_EMAIL, user_email);
        contentValues.put(COLUMN_MOBILE, user_mobile);

        long id = db.insert(TABLE_NAME, null, contentValues);
        db.close();
        Log.d(TAG, "Deleted all user info from sqlite: " + id);
    }

    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToFirst();

        if(cursor.getCount() > 0){
            user.put("user_id", cursor.getString(1));
            user.put("user_name", cursor.getString(2));
            user.put("user_email", cursor.getString(3));
            user.put("user_password", cursor.getString(4));
            user.put("user_confirm_password", cursor.getString(5));
            user.put("user_mobile", cursor.getString(6));
        }
        cursor.close();
        db.close();
        Log.d(TAG, "Fetching user from Sqlite: " + user.toString());

        return user;
    }

    public void deleteUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete All Rows
        db.delete(TABLE_NAME, null, null);
        db.close();

        Log.d(TAG, "Deleted all user info from sqlite");
    }

}

