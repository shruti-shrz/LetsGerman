package com.example.germanclone;


import android.content.Context;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Words> {
    private int colorresid;

    public WordAdapter(Context context, ArrayList<Words> words, int colorid) {

        super(context, 0, words);
        colorresid = colorid;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listviewitem = convertView;
        if (listviewitem == null) {
            listviewitem = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
         Words currentword = getItem(position);
        TextView item = listviewitem.findViewById(R.id.version_name);
        item.setText(currentword.getEnglishtrans());
        TextView item2 = listviewitem.findViewById(R.id.version_number);
        item2.setText(currentword.getGermantrans());
        ImageView imagee = listviewitem.findViewById(R.id.list_item_icon);
        imagee.setImageResource(currentword.getImage());
        ImageView image2 = listviewitem.findViewById(R.id.icon2);
        View textcontainer = listviewitem.findViewById(R.id.textback);
        int color = ContextCompat.getColor(getContext(), colorresid);
        textcontainer.setBackgroundColor(color);
        image2.setBackgroundColor(color);
        return listviewitem;
    }
}
