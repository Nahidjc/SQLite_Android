package com.example.databasesqlite;

import androidx.appcompat.app.AppCompatActivity;

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
}