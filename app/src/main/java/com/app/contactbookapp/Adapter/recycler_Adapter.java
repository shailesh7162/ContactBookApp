package com.app.contactbookapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.contactbookapp.Activty.Contact_list_data;
import com.app.contactbookapp.Activty.MainActivity;
import com.app.contactbookapp.DBHelper;
import com.app.contactbookapp.R;

import java.util.ArrayList;

public class recycler_Adapter extends RecyclerView.Adapter<recycler_Adapter.User_holder>
{
    Context context;
    ArrayList<Contact_list_data> contactList;


    public recycler_Adapter(MainActivity context, ArrayList<Contact_list_data> contactList) {
        this.context=context;
        this.contactList=contactList;
    }

    @NonNull
    @Override
    public recycler_Adapter.User_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.contact_list_iteam,parent,false);
        User_holder userHolder=new User_holder(view);
        return userHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull recycler_Adapter.User_holder holder, int position) {
        holder.textname.setText(""+contactList.get(position).getName());
        holder.textnumber.setText(""+contactList.get(position).getNumber());
        holder.contactImg.setOnClickListener(new View.OnClickListener() {
             DBHelper db=new DBHelper(context);
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context,holder.optionMenu);
                popupMenu.getMenuInflater().inflate(R.menu.menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if(menuItem.getItemId()==R.id.delete)
                        {
                            db.deletconcact(contactList.get(holder.getAdapterPosition()).getId());
                            contactList.remove(holder.getAdapterPosition());
                            notifyDataSetChanged();
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class User_holder extends RecyclerView.ViewHolder {
        public View optionMenu;
        TextView textname,textnumber;
        ImageView contactImg;
        public User_holder(@NonNull View itemView)
        {
            super(itemView);
            textname=itemView.findViewById(R.id.textname);
            textnumber=itemView.findViewById(R.id.textnumber);
            contactImg=itemView.findViewById(R.id.contactImg);
        }
    }
}
