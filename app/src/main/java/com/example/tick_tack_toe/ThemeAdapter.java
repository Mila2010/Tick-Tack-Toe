package com.example.tick_tack_toe;

import android.support.v4.util.ArrayMap;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Millochka on 10/28/16.
 */
public class ThemeAdapter extends RecyclerView.Adapter {

    private List<String> mThemeName=new ArrayList<>();
    private List<Integer> mThemeIcons=new ArrayList<>();

    public ThemeAdapter(){
        super();
        initIntList();
        initList();
        notifyDataSetChanged();
    }

    private Map<String,Integer> mThemes= new ArrayMap<>();


    public void initMap(){
        mThemes.put("Beach",R.drawable.beach);
        mThemes.put("Helloween",R.drawable.helloween);
        mThemes.put("Forest",R.drawable.forest);
        mThemes.put("Christmas",R.drawable.christmas);
        mThemes.put("Universe",R.drawable.universe);
        mThemes.put("Trump",R.drawable.trump);

    }


    public void initList(){
        mThemeName.add("Beach");
        mThemeName.add("Helloween");
        mThemeName.add("Forest");
        mThemeName.add("Christmas");
        mThemeName.add("Universe");
        mThemeName.add("Trump");

    }


    public void initIntList(){
        mThemeIcons.add(R.drawable.beach);
        mThemeIcons.add(R.drawable.helloween);
        mThemeIcons.add(R.drawable.forest);
        mThemeIcons.add(R.drawable.christmas);
        mThemeIcons.add(R.drawable.universe);
        mThemeIcons.add(R.drawable.trump);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ThemeViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //initMap();


        ThemeViewHolder themeViewHolder=(ThemeViewHolder) holder;
        themeViewHolder.onBind(mThemeIcons.get(position));

    }

    @Override
    public int getItemCount() {
        return mThemes.size();
    }
}
