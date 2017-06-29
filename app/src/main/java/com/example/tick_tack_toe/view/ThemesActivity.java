package com.example.tick_tack_toe.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.tick_tack_toe.R;
import com.example.tick_tack_toe.ThemeAdapter;

public class ThemesActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themes);

        recyclerView=(RecyclerView) findViewById(R.id.theme_field);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(new ThemeAdapter());

    }
}
