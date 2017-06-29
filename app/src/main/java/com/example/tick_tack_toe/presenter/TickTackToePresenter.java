package com.example.tick_tack_toe.presenter;

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
@Singleton
public class TickTackToePresenter {

    private Game mGame;
    private GameBoard mGameBoard;
    private TickTackToeInterface mTickTackToeInterface;
    @Inject
    public TickTackToePresenter(Game game,GameBoard gameBoard){

        this.mGame=game;
        this.mGameBoard = gameBoard;

    }

    public Game getmGame() {
        return mGame;
    }

    public void fillMoveArray(String move, int id){

        switch (id){

            case R.id.upper_left:
                mGameBoard.getmMoveArray()[0][0]=move;

                break;
            case R.id.upper_right:
                mGameBoard.getmMoveArray()[0][2]=move;
                break;
            case R.id.upper_center:
                mGameBoard.getmMoveArray()[0][1]=move;
                break;
            case R.id.center_left:
                mGameBoard.getmMoveArray()[1][0]=move;
                break;
            case R.id.center:
                mGameBoard.getmMoveArray()[1][1]=move;
                break;
            case R.id.center_right:
                mGameBoard.getmMoveArray()[1][2]=move;
                break;
            case R.id.lower_left:
                mGameBoard.getmMoveArray()[2][0]=move;
                break;
            case R.id.lower_center:
                mGameBoard.getmMoveArray()[2][1]=move;
                break;
            case R.id.lower_right:
                mGameBoard.getmMoveArray()[2][2]=move;
                break;


        }

    }

    public String evaluateGame(View view){
        int m=0;
        int j=0;
        int i=0;
        int n=2;


        for(int l=0;l<3;l++){

            if(mGameBoard.getmMoveArray()[l][j].equals(mGameBoard.getmMoveArray()[l][j+1])&&mGameBoard.getmMoveArray()[l][j+1].equals(mGameBoard.getmMoveArray()[l][j+2])&&!mGameBoard.getmMoveArray()[l][j].equals("*")){

               mTickTackToeInterface.showWinner(mGame.getmMoveMap().get(mGameBoard.getmMoveArray()[l][j]));


                return null;

            }


        }


        for(int k=0;k<3;k++){

            if(mGameBoard.getmMoveArray()[i][k].equals(mGameBoard.getmMoveArray()[i+1][k])&&mGameBoard.getmMoveArray()[i+1][k].equals(mGameBoard.getmMoveArray()[i+2][k])&&!mGameBoard.getmMoveArray()[i][k].equals("*")){
                mTickTackToeInterface.showWinner(mGame.getmMoveMap().get(mGameBoard.getmMoveArray()[i][k]));


                return null;


            }
        }



        if(mGameBoard.getmMoveArray()[m][m].equals(mGameBoard.getmMoveArray()[m+1][m+1])&&mGameBoard.getmMoveArray()[m+1][m+1].equals(mGameBoard.getmMoveArray()[m+2][m+2])&&!mGameBoard.getmMoveArray()[m][m].equals("*")){

            mTickTackToeInterface.showWinner(mGame.getmMoveMap().get(mGameBoard.getmMoveArray()[m][m]));



            return null;}

        if(mGameBoard.getmMoveArray()[n-2][n].equals(mGameBoard.getmMoveArray()[n-1][n-1])&&mGameBoard.getmMoveArray()[n-1][n-1].equals(mGameBoard.getmMoveArray()[n][n-2])&&!mGameBoard.getmMoveArray()[n-1][n-1].equals("*")){
            mTickTackToeInterface.showWinner(mGame.getmMoveMap().get(mGameBoard.getmMoveArray()[n-1][n-1]));


            return null;}


        return null;


    }

    public void setTickTackToeInterface(TickTackToeInterface tickTackToeInterface) {
        this.mTickTackToeInterface = tickTackToeInterface;
    }

    public boolean isGameFinished(){


        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if (mGameBoard.getmMoveArray()[i][j].equals("*")){

                    return false;
                }
            }
        }

        return true;

    }
}
