package com.example.tick_tack_toe;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Millochka on 10/28/16.
 */

public class BetweenGames extends Fragment implements View.OnClickListener{

    Button mPlayAgain;
    Button mExit;
    private Callback callback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.between_games,container, false);
        initialize(view);
        setOnClick();

//        initMoveArray();

        return view;}

    private void setOnClick() {
        mPlayAgain.setOnClickListener(this);
        mExit.setOnClickListener(this);
    }


    private void initialize(View view){
        mPlayAgain=(Button)view.findViewById(R.id.yes);
        mExit=(Button)view.findViewById(R.id.no);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.yes:
//                getFragmentManager().beginTransaction().replace(R.id.activity_start_page,new TickTackToes(),TAG).addToBackStack(null).commit();

                callback.onBack();
                break;
            case R.id.no:
                Intent intent=new Intent(view.getContext(),StartPage.class);
                startActivity(intent);
                break;
        }


    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    interface Callback {
        void onBack();
    }
}
