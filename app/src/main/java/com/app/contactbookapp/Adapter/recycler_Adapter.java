package com.app.contactbookapp.Adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.contactbookapp.Activty.Contact_list_data;
import com.app.contactbookapp.Activty.MainActivity;

import java.util.ArrayList;

public class recycler_Adapter extends RecyclerView.Adapter<recycler_Adapter.User_holder>
{


    public recycler_Adapter(MainActivity mainActivity, ArrayList<Contact_list_data> contactList) {

    }

    @NonNull
    @Override
    public recycler_Adapter.User_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull recycler_Adapter.User_holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class User_holder extends RecyclerView.ViewHolder {
        public User_holder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
