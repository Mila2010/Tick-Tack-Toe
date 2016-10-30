package com.example.tick_tack_toe;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Millochka on 10/29/16.
 */
public class ThemeViewHolder extends RecyclerView.ViewHolder {

    View mView;
    ImageView mIcon;
    TextView mName;

    public ThemeViewHolder(ViewGroup parent) {
        super(parent);

        mView=itemView;

        mIcon = (ImageView) mView.findViewById(R.id.picture);
        mName=(TextView)mView.findViewById(R.id.name);

    }

    public static View inflateView(ViewGroup parent){
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());

        return inflater.inflate(R.layout.theme, parent,false);

    }
    public void onBind(Integer themeIcon){

        mIcon.setImageResource(themeIcon);
        //mName.setText(themeName);

    }

}
