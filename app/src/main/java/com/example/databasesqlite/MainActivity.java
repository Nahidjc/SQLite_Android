package com.example.databasesqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public DatabaseHelper myDbhelper;
    private String name,email,phone;
    EditText nameEditText,emailEditText,phoneEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDbhelper = new DatabaseHelper(this);
        setContentView(R.layout.activity_main);
        nameEditText=findViewById(R.id.nameID);
        emailEditText = findViewById(R.id.emailID);
        phoneEditText = findViewById(R.id.phoneID);
    }

    public void saveDataFunction(View view) {
        name = nameEditText.getText().toString();
        email= emailEditText.getText().toString();
        phone=phoneEditText.getText().toString();
        String value = myDbhelper.addStudentinfo(name,email,phone);
        if(value.equals("y")){
            Toast.makeText(this, "Data inserted Succesfully", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Failed!!!!", Toast.LENGTH_SHORT).show();
        }

    }
    public void viewAlldataFunction(View view){
        Cursor resultCursor = myDbhelper.getAllData();
        StringBuffer myBuffer = new StringBuffer();
        if(resultCursor.getCount()==0){
            Toast.makeText(this, "There is now Data", Toast.LENGTH_SHORT).show();
        }else{
            while (resultCursor.moveToNext()){
                myBuffer.append("Name"+resultCursor.getString(1));
                myBuffer.append("Email"+resultCursor.getString(2));
                myBuffer.append("Phone"+resultCursor.getString(3));
            }
            Toast.makeText(this, myBuffer.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}