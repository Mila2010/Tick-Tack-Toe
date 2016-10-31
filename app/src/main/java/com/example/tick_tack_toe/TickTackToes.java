package com.example.tick_tack_toe;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Millochka on 10/24/16.
 */
public class TickTackToes extends Fragment implements ViewGroup.OnClickListener{
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

    String [][] mMoveArray=new String[3][3];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.basic_play_field,container, false);

        initialize(view);
        setOnClick();
        initMoveArray();

        mBasicField.setBackground(StartPage.getmFieldBackground());




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

    public String[][] getmMoveArray(){

        return mMoveArray;
    }

    public void fillMoveArray(String move, int id){

        switch (id){

            case R.id.upper_left:
                mMoveArray[0][0]=move;

                break;
            case R.id.upper_right:
                mMoveArray[0][2]=move;
            break;
            case R.id.upper_center:
                mMoveArray[0][1]=move;
            break;
            case R.id.center_left:
                mMoveArray[1][0]=move;
                break;
            case R.id.center:
                mMoveArray[1][1]=move;
            break;
            case R.id.center_right:
                mMoveArray[1][2]=move;
            break;
            case R.id.lower_left:
                mMoveArray[2][0]=move;
            break;
            case R.id.lower_center:
                mMoveArray[2][1]=move;
            break;
            case R.id.lower_right:
                mMoveArray[2][2]=move;
                break;


        }

    }

    public String evaluateGame(View view){
        int m=0;
        int j=0;
        int i=0;
        int n=2;


        for(int l=0;l<3;l++){

                if(mMoveArray[l][j].equals(mMoveArray[l][j+1])&&mMoveArray[l][j+1].equals(mMoveArray[l][j+2])&&!mMoveArray[l][j].equals("*")){

                    //StartPage.getmMoveMap().get(mMoveArray[l][j]);
                    Toast.makeText(view.getContext(), StartPage.getmMoveMap().get(mMoveArray[l][j]) + " - Won",Toast.LENGTH_LONG).show();
                    inflateBetweenGames();
                    return null;

                   }


        }


        for(int k=0;k<3;k++){

                if(mMoveArray[i][k].equals(mMoveArray[i+1][k])&&mMoveArray[i+1][k].equals(mMoveArray[i+2][k])&&!mMoveArray[i][k].equals("*")){

                    Toast.makeText(view.getContext(), StartPage.getmMoveMap().get(mMoveArray[i][k]) + " - Won",Toast.LENGTH_LONG).show();
                    inflateBetweenGames();
                    return null;


        }
        }



            if(mMoveArray[m][m].equals(mMoveArray[m+1][m+1])&&mMoveArray[m+1][m+1].equals(mMoveArray[m+2][m+2])&&!mMoveArray[m][m].equals("*")){

                Toast.makeText(view.getContext(), StartPage.getmMoveMap().get(mMoveArray[m][m]) + " - Won",Toast.LENGTH_LONG).show();
                inflateBetweenGames();

                return null;}

        if(mMoveArray[n-2][n].equals(mMoveArray[n-1][n-1])&&mMoveArray[n-1][n-1].equals(mMoveArray[n][n-2])&&!mMoveArray[n-1][n-1].equals("*")){

            Toast.makeText(view.getContext(), StartPage.getmMoveMap().get(mMoveArray[n-1][n-1]) + " - Won",Toast.LENGTH_LONG).show();
            inflateBetweenGames();
            return null;}


            return null;


    }

 public boolean isGameFinished(){


     for(int i=0;i<3;i++){
         for(int j=0;j<3;j++){
             if (mMoveArray[i][j].equals("*")){

                 return false;
             }
         }
     }

     return true;

 }
    public void initMoveArray(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                mMoveArray[i][j]="*";


                }
            }
        }

    public void processClick(int id, String move, View view){

        Button temptButton=(Button) view.findViewById(id);
        temptButton.setText(move);
        fillMoveArray(move,id);
        mCross=!mCross;

        evaluateGame(view);
    }

    public void inflateBetweenGames(){
        BetweenGames betweenGames = new BetweenGames();
        betweenGames.setCallback((BetweenGames.Callback) getActivity());
        getChildFragmentManager().beginTransaction().add(R.id.basic_play, betweenGames).commit();

    }


    @Override
    public void onClick(View view) {

        int currentButtonId=view.getId();

        switch (currentButtonId){

            case R.id.upper_left:case R.id.upper_right:case R.id.upper_center:case R.id.center_left:
            case R.id.center:case R.id.center_right:case R.id.lower_left:case R.id.lower_center:case R.id.lower_right:


                if(mCross){


                    processClick(currentButtonId,"X",view);

                    if(isGameFinished()){

                        inflateBetweenGames();

                    }


                }else {


                    processClick(currentButtonId,"O",view);
                    if(isGameFinished()){

                        inflateBetweenGames();

                    }

                }



            break;

        }



    }

}

