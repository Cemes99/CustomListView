package com.example.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Item> item;

    public MyAdapter(Context context, ArrayList<Item> item) {
        this.context = context;
        this.item = item;
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        return item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        convertView = layoutInflater.inflate(R.layout.layout_item, parent, false);

        ImageView imageView = convertView.findViewById(R.id.image);
        TextView title = convertView.findViewById(R.id.title);
        TextView author = convertView.findViewById(R.id.author);

        imageView.setImageResource(item.get(position).getImageView());
        title.setText(item.get(position).getTitle());
        author.setText(item.get(position).getAuthor());

        return convertView;
    }
}
