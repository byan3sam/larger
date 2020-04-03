package com.example.largerthanlobster;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class myadabter2 extends ArrayAdapter {
    private Context context;
    private ArrayList<add_story> arrayList;

    public myadabter2(@NonNull Context context, ArrayList arrayList) {
        super(context,0,arrayList);
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row =convertView;
        if (row==null){
            row= LayoutInflater.from(getContext()).inflate(R.layout.list_story,parent,false);
        }
        final add_story r= arrayList.get(position);
        final TextView text=row.findViewById(R.id.storyrow);
        text.setText(r.getName());

        return row;
    }



}
