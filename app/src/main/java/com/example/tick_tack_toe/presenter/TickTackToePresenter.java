package com.example.tick_tack_toe.presenter;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.tick_tack_toe.R;
import com.example.tick_tack_toe.model.Game;
import com.example.tick_tack_toe.model.GameBoard;
import com.example.tick_tack_toe.view.TickTackToeInterface;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by mila on 6/20/17.
 */

public class TickTackToePresenter {

    private Game mGame;

    private TickTackToeInterface mTickTackToeInterface;
    @Inject
    public TickTackToePresenter(Game game,GameBoard gameBoard){

        this.mGame=game;


    }

    public Game getmGame() {
        return mGame;
    }

    public void fillMoveArray(String move, int id){

        switch (id){

            case R.id.upper_left:
                mGame.getmGameBoard().getmMoveArray()[0][0]=move;

                break;
            case R.id.upper_right:
                mGame.getmGameBoard().getmMoveArray()[0][2]=move;
                break;
            case R.id.upper_center:
                mGame.getmGameBoard().getmMoveArray()[0][1]=move;
                break;
            case R.id.center_left:
                mGame.getmGameBoard().getmMoveArray()[1][0]=move;
                break;
            case R.id.center:
                mGame.getmGameBoard().getmMoveArray()[1][1]=move;
                break;
            case R.id.center_right:
                mGame.getmGameBoard().getmMoveArray()[1][2]=move;
                break;
            case R.id.lower_left:
                mGame.getmGameBoard().getmMoveArray()[2][0]=move;
                break;
            case R.id.lower_center:
                mGame.getmGameBoard().getmMoveArray()[2][1]=move;
                break;
            case R.id.lower_right:
                mGame.getmGameBoard().getmMoveArray()[2][2]=move;
                break;


        }

    }

    public String evaluateGame(View view){
        int m=0;
        int j=0;
        int i=0;
        int n=2;


        for(int l=0;l<3;l++){

            if(mGame.getmGameBoard().getmMoveArray()[l][j].equals(mGame.getmGameBoard().getmMoveArray()[l][j+1])&&mGame.getmGameBoard().getmMoveArray()[l][j+1].equals(mGame.getmGameBoard().getmMoveArray()[l][j+2])&&!mGame.getmGameBoard().getmMoveArray()[l][j].equals("*")){

               mTickTackToeInterface.showWinner(mGame.getmMoveMap().get(mGame.getmGameBoard().getmMoveArray()[l][j]));


                return null;

            }


        }


        for(int k=0;k<3;k++){

            if(mGame.getmGameBoard().getmMoveArray()[i][k].equals(mGame.getmGameBoard().getmMoveArray()[i+1][k])&&mGame.getmGameBoard().getmMoveArray()[i+1][k].equals(mGame.getmGameBoard().getmMoveArray()[i+2][k])&&!mGame.getmGameBoard().getmMoveArray()[i][k].equals("*")){
                mTickTackToeInterface.showWinner(mGame.getmMoveMap().get(mGame.getmGameBoard().getmMoveArray()[i][k]));


                return null;


            }
        }



        if(mGame.getmGameBoard().getmMoveArray()[m][m].equals(mGame.getmGameBoard().getmMoveArray()[m+1][m+1])&&mGame.getmGameBoard().getmMoveArray()[m+1][m+1].equals(mGame.getmGameBoard().getmMoveArray()[m+2][m+2])&&!mGame.getmGameBoard().getmMoveArray()[m][m].equals("*")){

            mTickTackToeInterface.showWinner(mGame.getmMoveMap().get(mGame.getmGameBoard().getmMoveArray()[m][m]));

            Log.d("mGameAddress",mGame.toString());
            Log.d("mGameBoardAddress",mGame.getmGameBoard().toString());



            return null;}

        if(mGame.getmGameBoard().getmMoveArray()[n-2][n].equals(mGame.getmGameBoard().getmMoveArray()[n-1][n-1])
                &&mGame.getmGameBoard().getmMoveArray()[n-1][n-1].equals(mGame.getmGameBoard().getmMoveArray()[n][n-2])
                &&!mGame.getmGameBoard().getmMoveArray()[n-1][n-1].equals("*")){
            mTickTackToeInterface.showWinner(mGame.getmMoveMap().get(mGame.getmGameBoard().getmMoveArray()[n-1][n-1]));


            return null;}


        return null;


    }

    public void setTickTackToeInterface(TickTackToeInterface tickTackToeInterface) {
        this.mTickTackToeInterface = tickTackToeInterface;
    }

    public boolean isGameFinished(){


        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if (mGame.getmGameBoard().getmMoveArray()[i][j].equals("*")){

                    return false;
                }
            }
        }

        return true;

    }
}
