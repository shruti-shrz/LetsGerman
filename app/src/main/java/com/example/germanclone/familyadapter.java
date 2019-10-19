package com.example.germanclone;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class familyadapter extends ArrayAdapter<family> {
    ArrayList<family> mylist2 = new ArrayList<>();
    private int colorresid;
    public familyadapter(Context context, ArrayList<family> mylist2, int colorid){
        super(context,0,mylist2);
        colorresid = colorid;
    }


    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
        View listviewitem = convertView;
        if(listviewitem==null)
        {
            listviewitem = LayoutInflater.from(getContext()).inflate(R.layout.listitem2,parent,false);
        }
        family current = getItem(position);
        TextView english = listviewitem.findViewById(R.id.version_name);
        english.setText(current.getenglish());
        TextView german = listviewitem.findViewById(R.id.version_number);
        german.setText(current.getgerman());
        View textcontainer = listviewitem.findViewById(R.id.roots);
        int color = ContextCompat.getColor(getContext(),colorresid);
        textcontainer.setBackgroundColor(color);
        TextView title = listviewitem.findViewById(R.id.version_head);
        title.setVisibility(View.GONE);
        return listviewitem;
    }
}
