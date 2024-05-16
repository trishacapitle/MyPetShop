package com.example.mypetshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<ListItem> {
    private final ArrayList<ListItem> dataList;
    private final Context mContext;

    public ListAdapter(Context context, ArrayList<ListItem> listItems) {
        super(context, 0, listItems);
        mContext = context;
        dataList = listItems;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        }

        ListItem currentItem = dataList.get(position);

        ImageView imageView = convertView.findViewById(R.id.listImage);
        TextView textView = convertView.findViewById(R.id.listName);

        imageView.setImageResource(currentItem.getImageResourceId());
        textView.setText(currentItem.getName());

        return convertView;
    }
}
