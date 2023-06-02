package com.app.contactbookapp.Activty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.app.contactbookapp.R;
import com.app.contactbookapp.user;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Contact_ListActivity extends AppCompatActivity
{
    ListView listView;
    FloatingActionButton fab;
    ArrayList<user> userArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        listView=findViewById(R.id.listview);
        getData();
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Contact_ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void getData()
    {

    }
}