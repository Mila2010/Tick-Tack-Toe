package com.example.tick_tack_toe.view;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tick_tack_toe.R;
import com.example.tick_tack_toe.presenter.StartPagePresenter;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.tick_tack_toe.TickTackToeApp.getAppComponent;

public class StartPageActivity extends AppCompatActivity implements ViewGroup.OnClickListener, BetweenGamesFragment.Callback {


    @BindView(R.id.play)
    Button mPlay;
    @BindView(R.id.player1)EditText mPlayer1;
    @BindView(R.id.player2)EditText mPlayer2;
    @BindView(R.id.spinner1)Spinner mCrossZero1;
    @BindView(R.id.spinner2)Spinner mCrossZero2;
    @BindView(R.id.theme_button)
    Button mThemes;
    @Inject
    StartPagePresenter mStartPagePresenter;
    private String TAG="com.example.tick_tack_toe";

    String mVPlayer1;
    String mVPlayer2;
    private static Drawable mFieldBackground;


    public static Drawable getmFieldBackground() {
        return mFieldBackground;
    }


    public static void setmFieldBackground(Drawable mFieldBackground) {
        StartPageActivity.mFieldBackground = mFieldBackground;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();

        getAppComponent().inject(this);
//        mFieldBackground= intent.getIntExtra(ThemeAdapter.DRAWABLE,0);
        setContentView(R.layout.activity_start_page);
        ButterKnife.bind(this);
        setOnClick();



    }


    public void setOnClick(){
        mPlay.setOnClickListener(this);
        mThemes.setOnClickListener(this);
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
                mStartPagePresenter.getmGame()
                        .getmFirstPlayer()
                        .setmName(mPlayer1.getText().toString());
//                    mStartPagePresenter.getmGame()
//                            .getmSecondPlayer()
//                            .setmName(mPlayer2.getText().toString());

                    mStartPagePresenter.getmGame()
                            .setmMoveMap(mCrossZero1.getSelectedItem().toString(),mPlayer1.getText().toString());
                    mStartPagePresenter.getmGame()
                            .setmMoveMap(mCrossZero2.getSelectedItem().toString(),mPlayer2.getText().toString());

                mPlayer1.setFocusable(false);
                mPlayer2.setFocusable(false);

                mCrossZero1.setEnabled(false);
                mCrossZero2.setEnabled(false);
                getFragmentManager().beginTransaction().replace(R.id.activity_start_page,new TickTackToeFragment(),TAG)
                        .commit();}


                break;
            case R.id.theme_button:

                Intent intent=new Intent(this, ThemesActivity.class);

                startActivity(intent);


                break;

        }

    }


    @Override
    public void onBack() {
//        getFragmentManager().popBackStack();
        getFragmentManager().beginTransaction().replace(R.id.activity_start_page,new TickTackToeFragment(),TAG).addToBackStack(null).commit();
    }
}
