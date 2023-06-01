package com.app.contactbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editname, editnumber;
    Button btnsub;
    int id;
    String name;
    String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editname = findViewById(R.id.editname);
        editnumber = findViewById(R.id.editnumber);
        btnsub = findViewById(R.id.btnsub);


        if (getIntent().getExtras() != null) {
            id = getIntent().getIntExtra("id", 0);
            name = getIntent().getStringExtra("name");
            number = getIntent().getStringExtra("number");

            editname.setText("" + name);
            editnumber.setText("" + number);
        }
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editname.getText().toString();
                String contact = editnumber.getText().toString();

                if (getIntent().getExtras() == null) {
                    DBHelper dbHelper = new DBHelper(MainActivity.this);
                    dbHelper.insertData(name, contact);
                    Intent intent = new Intent(MainActivity.this, Contact_ListActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    DBHelper dbHelper = new DBHelper(MainActivity.this);
                    dbHelper.updateData(id, name, contact);
                    Intent intent = new Intent(MainActivity.this, Contact_ListActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });

    }
}