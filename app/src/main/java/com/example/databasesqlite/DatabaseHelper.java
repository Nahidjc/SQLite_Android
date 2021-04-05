package com.example.databasesqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static String database_name = "studentdb";
    String studentInfo_Table_name = "studentsInfo";
    String student_column_id="id";
    String student_column_name="name";
    String student_column_email="email";
    String student_column_phone="phone";
    public DatabaseHelper(Context context) {
        super(context,database_name,null,3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL("CREATE TABLE studentsInfo " +"(id integer primary key autoincrement,name text,email text,phone text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL("DROP TABLE IF EXISTS studentsInfo");
     onCreate(db);
    }
    public String addStudentinfo(String nameText,String emailText,String phoneText){
        ContentValues myContent = new ContentValues();
        myContent.put("name",nameText);
        myContent.put("email",emailText);
        myContent.put("phone",phoneText);
        SQLiteDatabase mydb = this.getWritableDatabase();
        mydb.insert("studentsInfo",null,myContent);
        mydb.close();

        return "y";
    }
}
