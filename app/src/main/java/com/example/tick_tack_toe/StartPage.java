package com.example.tick_tack_toe;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class StartPage extends AppCompatActivity implements ViewGroup.OnClickListener, BetweenGames.Callback {

    Button mPlay;
    Button mThemes;
    private String TAG="com.example.tick_tack_toe";
    EditText mPlayer1;
    EditText mPlayer2;
    String mVPlayer1;
    String mVPlayer2;
    Spinner mCrossZero1;
    Spinner mCrossZero2;
    private static Drawable mFieldBackground;
    static Map<String,String> mMoveMap= new HashMap<>();

    public static Drawable getmFieldBackground() {
        return mFieldBackground;
    }


    public static void setmFieldBackground(Drawable mFieldBackground) {
        StartPage.mFieldBackground = mFieldBackground;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
//        mFieldBackground= intent.getIntExtra(ThemeAdapter.DRAWABLE,0);
        setContentView(R.layout.activity_start_page);
        initialize();
        setOnClick();


    }

    public void initialize(){
        mPlay = (Button) findViewById(R.id.play);
        mPlayer1=(EditText)findViewById(R.id.player1);
        mPlayer2=(EditText)findViewById(R.id.player2);
        mCrossZero1=(Spinner) findViewById(R.id.spinner1);
        mCrossZero2=(Spinner)findViewById(R.id.spinner2);
        mThemes=(Button)findViewById(R.id.theme_button);

    }

    public void setOnClick(){
        mPlay.setOnClickListener(this);
        mThemes.setOnClickListener(this);
    }

    public static Map<String, String> getmMoveMap() {
        return mMoveMap;
    }

    public void translateChoice(String choice, String player){

        switch (choice.toLowerCase()){

            case "cross":
                mMoveMap.put("X",player);
                break;
            case "zero":
                mMoveMap.put("O",player);
                break;


        }

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.play:

                if(mPlayer1.getText().toString().trim().length()==0||mPlayer2.getText().toString().trim().length()==0||
                        mCrossZero1.getSelectedItemPosition()==0||mCrossZero2.getSelectedItemPosition()==0){

                    Toast.makeText(this,"Please set the name of both users and pick the move", Toast.LENGTH_LONG).show();

                } else if(mCrossZero1.getSelectedItem().equals(mCrossZero2.getSelectedItem())){

                    Toast.makeText(this,"Please set different moves for the players", Toast.LENGTH_LONG).show();

                }
            else{
                mVPlayer1=mPlayer1.getText().toString();
                mVPlayer2=mPlayer2.getText().toString();


                mPlayer1.setFocusable(false);
                mPlayer2.setFocusable(false);
                translateChoice(mCrossZero1.getSelectedItem().toString(),mPlayer1.getText().toString());
                translateChoice(mCrossZero2.getSelectedItem().toString(),mPlayer2.getText().toString());
                mCrossZero1.setEnabled(false);
                mCrossZero2.setEnabled(false);
                getFragmentManager().beginTransaction().replace(R.id.activity_start_page,new TickTackToes(),TAG)
                        .commit();}


                break;
            case R.id.theme_button:

                Intent intent=new Intent(this, Themes.class);

                startActivity(intent);


                break;

        }

    }


    @Override
    public void onBack() {
//        getFragmentManager().popBackStack();
        getFragmentManager().beginTransaction().replace(R.id.activity_start_page,new TickTackToes(),TAG).addToBackStack(null).commit();
    }
}
