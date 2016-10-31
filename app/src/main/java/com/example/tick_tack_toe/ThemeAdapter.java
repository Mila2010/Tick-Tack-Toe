package com.example.tick_tack_toe;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Millochka on 10/28/16.
 */
public class ThemeAdapter extends RecyclerView.Adapter implements ViewGroup.OnClickListener{

    private List<String> mThemeName=new ArrayList<>();
    private List<Integer> mThemeIcons=new ArrayList<>();
   public static String DRAWABLE="ThemeAdapter";

    public ThemeAdapter(){
        initIntList();
        initList();
        notifyDataSetChanged();
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



         final ThemeViewHolder themeViewHolder=(ThemeViewHolder) holder;
         themeViewHolder.getmIcon().setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent=new Intent(view.getContext(), StartPage.class);
                 ImageView tempImageView=(ImageView) view;

                 StartPage.setmFieldBackground(tempImageView.getDrawable());
                 view.getContext().startActivity(intent);

             }
         });
         themeViewHolder.onBind(mThemeIcons.get(position),mThemeName.get(position));



    }



    @Override
    public int getItemCount() {
        return mThemeIcons.size();
    }

    @Override
    public void onClick(View view) {

        Toast.makeText(view.getContext(),"working",Toast.LENGTH_LONG);





    }
}
