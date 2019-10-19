package com.example.germanclone;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class phrasesadapter extends ArrayAdapter<phrases> {
    ArrayList<phrases> mylist4 = new ArrayList<>();
    private int colorresid;
    public phrasesadapter(Context context, ArrayList<phrases> mylist4, int colorid){
          super(context,0,mylist4);
          colorresid = colorid;
    }


    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        View phaseview = convertView;
        if(phaseview==null)
        {
          phaseview = LayoutInflater.from(getContext()).inflate(R.layout.listitem2,parent,false);
        }
        phrases currentword = getItem(position);
        TextView listh = (TextView)phaseview.findViewById(R.id.version_head);
        listh.setText(currentword.getHeadlines());
        TextView list = (TextView)phaseview.findViewById(R.id.version_name);
        list.setText(currentword.getPeng());
        TextView list2 = (TextView) phaseview.findViewById(R.id.version_number);
        list2.setText(currentword.getPger());
        View textcontainer = phaseview.findViewById(R.id.roots);
        int color = ContextCompat.getColor(getContext(),colorresid);
        textcontainer.setBackgroundColor(color);
        return phaseview;
    }
}
