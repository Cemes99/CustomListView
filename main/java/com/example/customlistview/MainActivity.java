package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private ListView listView;
    private ArrayList<Item> arrayList = new ArrayList<>();
    private MyAdapter myAdapter = new MyAdapter(MainActivity.this, arrayList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_item);
        listView.setAdapter(myAdapter);

        initData();
        setClickOfListView();
    }

    private void initData(){
        arrayList.add(new Item(R.drawable.who_lauv, "Who", "Lauv"));
        arrayList.add(new Item(R.drawable.parc_ferme_antaine_minot, "Parc Fermé", "Antaine Minot"));
        arrayList.add(new Item(R.drawable.nothing_breaks_like_a_heart, "Nothing breaks like a heart", "Mark Ronson"));
        arrayList.add(new Item(R.drawable.higher_state_of_consciousness, "Higher state of consciousness", "Josh Wink"));
        arrayList.add(new Item(R.drawable.bloodline_arianna_grande, "Bloodline", "Arianna Grande"));
        arrayList.add(new Item(R.drawable.who_lauv, "Who", "Lauv"));
        arrayList.add(new Item(R.drawable.parc_ferme_antaine_minot, "Parc Fermé", "Antaine Minot"));
        arrayList.add(new Item(R.drawable.nothing_breaks_like_a_heart, "Nothing breaks like a heart", "Mark Ronson"));
        arrayList.add(new Item(R.drawable.higher_state_of_consciousness, "Higher state of consciousness", "Josh Wink"));
        arrayList.add(new Item(R.drawable.bloodline_arianna_grande, "Bloodline", "Arianna Grande"));
        arrayList.add(new Item(R.drawable.who_lauv, "Who", "Lauv"));
        arrayList.add(new Item(R.drawable.parc_ferme_antaine_minot, "Parc Fermé", "Antaine Minot"));
        arrayList.add(new Item(R.drawable.nothing_breaks_like_a_heart, "Nothing breaks like a heart", "Mark Ronson"));
        arrayList.add(new Item(R.drawable.higher_state_of_consciousness, "Higher state of consciousness", "Josh Wink"));
        arrayList.add(new Item(R.drawable.bloodline_arianna_grande, "Bloodline", "Arianna Grande"));

        myAdapter.notifyDataSetChanged();
    }

    private void setClickOfListView(){
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        arrayList.remove(position);
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this, ItemActivity.class);
        Bundle bundle = new Bundle();

        bundle.putInt("Image", arrayList.get(position).getImageView());
        bundle.putString("Title", arrayList.get(position).getTitle());
        bundle.putString("Author", arrayList.get(position).getAuthor());

        intent.putExtras(bundle);

        startActivity(intent);

        return true;
    }
}
