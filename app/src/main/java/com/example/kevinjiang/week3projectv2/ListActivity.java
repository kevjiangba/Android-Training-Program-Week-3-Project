package com.example.kevinjiang.week3projectv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<TrumpCard> trumpCards = new ArrayList<TrumpCard>();

        TrumpCard iceCream = new TrumpCard("iceCream", "Trump's head is photoshopped as an ice cream.", R.drawable.icecream);
        trumpCards.add(iceCream);

        TrumpCard dignified = new TrumpCard("dignified", "Make America great again!", R.drawable.dignified);
        trumpCards.add(dignified);

        TrumpCard angry = new TrumpCard("angry", "The other GOP candidates are kinda derpy.", R.drawable.angry);
        trumpCards.add(angry);

        TrumpCard corn = new TrumpCard("corn", "His hair looks like corn don't it?", R.drawable.corn);
        trumpCards.add(corn);

        TrumpAdapter trumpAdapter = new TrumpAdapter(getApplicationContext(), trumpCards);

        recyclerView.setAdapter(trumpAdapter);

    }
}
