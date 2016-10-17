package com.suranjit.lenevo.mynotepad;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by su on 10/12/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyHolder> {
    Context c;
    ArrayList<Student> students;

    public MyAdapter(Context ctx,ArrayList<Student> students)
    {
        //ASSIGN THEM LOCALLY
        this.c=ctx;
        this.students=students;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //VIEW OBJ FROM XML
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,null);

        //holder
        MyHolder holder=new MyHolder(v);

        return holder;
    }

    //BIND DATA TO VIEWS
    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
           holder.posTxt.setText(students.get(position).getPosition());
           holder.nameTxt.setText(students.get(position).getName());

        //HANDLE ITEMCLICKS
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                //OPEN DETAIL ACTIVITY
                //PASS DATA

                //CREATE INTENT
                Intent i=new Intent(c,DetailActivity.class);

                //LOAD DATA
                i.putExtra("NAME",students.get(pos).getName());
                i.putExtra("POSITION",students.get(pos).getPosition());
                i.putExtra("ID",students.get(pos).getId());

                //START ACTIVITY
                c.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return students.size();
    }
}
