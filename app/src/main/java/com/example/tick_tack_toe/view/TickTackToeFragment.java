package com.example.tick_tack_toe.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.tick_tack_toe.R;
import com.example.tick_tack_toe.TickTackToeApp;
import com.example.tick_tack_toe.presenter.TickTackToePresenter;
import com.example.tick_tack_toe.view.BetweenGamesFragment;
import com.example.tick_tack_toe.view.StartPageActivity;

import javax.inject.Inject;

/**
 * Created by Millochka on 10/24/16.
 */
public class TickTackToeFragment extends Fragment implements ViewGroup.OnClickListener, TickTackToeInterface{
    Button mUpLef;
    Button mUpCent;
    Button mUpRig;
    Button mCenLef;
    Button mCent;
    Button mCentRig;
    Button mLowLef;
    Button mLowCent;
    Button mLowRig;
    boolean mCross=true;
    ViewGroup mBasicField;
    private String mPlayerOne;
    private String mPlayerTwo;
    private String mPlayerOneMove;
    private String mPlayerTwoMove;

    @Inject
    TickTackToePresenter mTickTackToePresenter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.basic_play_field,container, false);
        TickTackToeApp.getAppComponent().inject(this);
        initialize(view);
        setOnClick();
        mTickTackToePresenter.setTickTackToeInterface(this);
        this.setGameValues(mPlayerOne,mPlayerTwo,mPlayerOneMove,mPlayerTwoMove);

        if(StartPageActivity.getmFieldBackground()!=null){
        mBasicField.setBackground(StartPageActivity.getmFieldBackground());
            setTransparancy();

        }




        return view;}

    public void initialize(View view){
        mBasicField=(ViewGroup) view.findViewById(R.id.basic_play);
        mUpLef=(Button) view.findViewById(R.id.upper_left);
        mUpCent=(Button)view.findViewById(R.id.upper_center);
        mUpRig=(Button) view.findViewById(R.id.upper_right);
        mCent=(Button)view.findViewById(R.id.center);
        mCenLef=(Button) view.findViewById(R.id.center_left);
        mCentRig=(Button)view.findViewById(R.id.center_right);
        mLowLef=(Button) view.findViewById(R.id.lower_left);
        mLowCent=(Button)view.findViewById(R.id.lower_center);
        mLowRig=(Button)view.findViewById(R.id.lower_right);

    }

    public void setTransparancy(){
        mUpLef.getBackground().setAlpha(100);
        mUpCent.getBackground().setAlpha(100);
        mUpRig.getBackground().setAlpha(100);
        mCent.getBackground().setAlpha(100);
        mCenLef.getBackground().setAlpha(100);
        mCentRig.getBackground().setAlpha(100);
        mLowLef.getBackground().setAlpha(100);
        mLowCent.getBackground().setAlpha(100);
        mLowRig.getBackground().setAlpha(100);

    }

    public void setOnClick(){
        mUpLef.setOnClickListener(this);
        mUpCent.setOnClickListener(this);
        mUpRig.setOnClickListener(this);
        mCent.setOnClickListener(this);
        mCenLef.setOnClickListener(this);
        mCentRig.setOnClickListener(this);
        mLowLef.setOnClickListener(this);
        mLowCent.setOnClickListener(this);
        mLowRig.setOnClickListener(this);
    }







    public void processClick(int id, String move, View view){

        Button temptButton=(Button) view.findViewById(id);
        temptButton.setText(move);

        mTickTackToePresenter.fillMoveArray(move,id);
        mCross=!mCross;

        mTickTackToePresenter.evaluateGame(view);
    }

    public void inflateBetweenGames(){
        BetweenGamesFragment betweenGamesFragment = new BetweenGamesFragment();
        betweenGamesFragment.setCallback((BetweenGamesFragment.Callback) getActivity());
        getChildFragmentManager().beginTransaction().add(R.id.basic_play, betweenGamesFragment).commit();

    }


    @Override
    public void onClick(View view) {

        int currentButtonId=view.getId();

        switch (currentButtonId){

            case R.id.upper_left:case R.id.upper_right:case R.id.upper_center:case R.id.center_left:
            case R.id.center:case R.id.center_right:case R.id.lower_left:case R.id.lower_center:case R.id.lower_right:


                if(mCross){


                    processClick(currentButtonId,"X",view);

                    if(mTickTackToePresenter.isGameFinished()){

                        inflateBetweenGames();

                    }


                }else {


                    processClick(currentButtonId,"O",view);
                    if(mTickTackToePresenter.isGameFinished()){

                        inflateBetweenGames();

                    }

                }



            break;

        }



    }

    @Override
    public void showWinner(String name) {

        Toast.makeText(getActivity(), name + " - Won",Toast.LENGTH_LONG).show();

        inflateBetweenGames();

    }


    public void setGameValues(String firstPlayer, String secondPlayer,String firstPlayerMove, String secondPlayerMove){

        mTickTackToePresenter.getmGame()
                        .getmFirstPlayer()
                        .setmName(firstPlayer);
        mTickTackToePresenter.getmGame()
                            .getmSecondPlayer()
                            .setmName(secondPlayer);

        mTickTackToePresenter.getmGame()
                            .setmMoveMap(firstPlayerMove,firstPlayer);
        mTickTackToePresenter.getmGame()
                            .setmMoveMap(secondPlayerMove,secondPlayer);

    }


    public void setmPlayerOne(String mPlayerOne) {
        this.mPlayerOne = mPlayerOne;
    }

    public void setmPlayerTwo(String mPlayerTwo) {
        this.mPlayerTwo = mPlayerTwo;
    }

    public void setmPlayerOneMove(String mPlayerOneMove) {
        this.mPlayerOneMove = mPlayerOneMove;
    }

    public void setmPlayerTwoMove(String mPlayerTwoMove) {
        this.mPlayerTwoMove = mPlayerTwoMove;
    }
}


