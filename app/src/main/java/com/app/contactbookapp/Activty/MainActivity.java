package com.app.contactbookapp.Activty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.app.contactbookapp.Adapter.recycler_Adapter;
import com.app.contactbookapp.DBHelper;
import com.app.contactbookapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editname, editnumber;
    Button btnadd,btnupdate,btndelet;
    RecyclerView recyclerView;
    FloatingActionButton fab;

    ArrayList<Contact_list_data> contactList=new ArrayList<Contact_list_data>();
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab=findViewById(R.id.fab);
        recyclerView=findViewById(R.id.recyclerView);

        LinearLayoutManager manager=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        DBHelper db=new DBHelper(MainActivity.this);
        showData(db);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Dialog dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.activity_main);
                editname = dialog.findViewById(R.id.editname);
                editnumber = dialog.findViewById(R.id.editnumber);
                btnadd=dialog.findViewById(R.id.btnadd);
                btnupdate=dialog.findViewById(R.id.btnupdate);
                btndelet=dialog.findViewById(R.id.btndelet);
                dialog.show();
                btnadd.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        String addname = editname.getText().toString(); // bbb
                        String addnumber = editnumber.getText().toString(); //888
                        db.addcontact(addname,addnumber);//
                        contactList.clear();
                        showData(db);
                        dialog.dismiss();
                    }
                });
            }
        });
    }

    private void showData(DBHelper db)
    {
        cursor=db.showcontact();

        while (cursor.moveToNext())
        {
            Contact_list_data contact_list_data=new Contact_list_data();
            contact_list_data.setId(cursor.getInt(0));
            contact_list_data.setName(cursor.getString(1));
            contact_list_data.setNumber(cursor.getString(2));
            contactList.add(contact_list_data);

        }
        recycler_Adapter recycler_adapter=new recycler_Adapter(MainActivity.this,contactList);
        recyclerView.setAdapter(recycler_adapter);
    }
}