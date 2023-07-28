package com.app.contactbookapp.Activty;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.app.contactbookapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Contact_listActivity extends AppCompatActivity {

    FloatingActionButton fab;
    private EditText nametxt, numbertxt;
    private Button add;
    Cursor cursor;
    ArrayList<Contacts_Data> contactList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        fab=findViewById(R.id.fab);
        add=findViewById(R.id.add_btn);

        database db=new database(Contact_listActivity.this);
        showData(db);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog=new Dialog(Contact_listActivity.this);
                dialog.setContentView(R.layout.main_activity);
                nametxt=dialog.findViewById(R.id.name_txt);
                numbertxt=dialog.findViewById(R.id.number_txt);
                add=dialog.findViewById(R.id.add_btn);
                dialog.show();

                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String addname = nametxt.getText().toString();
                        String addnumber = numbertxt.getText().toString();
                        db.addcontact(addname,addnumber);
                        contactList.clear();
                        showData(db);
                        dialog.dismiss();
                    }
                });
            }
        });

    }

    private void showData(database db)
    {
         cursor = db.showcontact();

        while (cursor.moveToNext())
        {
            Contacts_Data contacts_data=new Contacts_Data();
            contacts_data.setId(cursor.getInt(0));
            contacts_data.setName(cursor.getString(1));
            contacts_data.setNumber(cursor.getString(2));
            contactList.add(contacts_data);

        }
    }
}