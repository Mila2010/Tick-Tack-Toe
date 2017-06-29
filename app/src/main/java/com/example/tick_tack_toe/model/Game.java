package com.example.tick_tack_toe.model;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by mila on 6/20/17.
 */
@Singleton
public class Game {

    private Player mFirstPlayer;
    private Player mSecondPlayer;
    private Boolean mIsCompleted;
    private GameBoard mGameBoard;
    private String mFirstPlayerPlays;
    private String mSecondPlayerPlays;
    private Map<String,String> mMoveMap;

    @Inject
    public Game(Player firstPlayer, Player secondPlayer){

        this.mFirstPlayer=firstPlayer;
        this.mFirstPlayer=secondPlayer;
        mMoveMap=new HashMap<>();

    }

    public Map<String, String> getmMoveMap() {
        return mMoveMap;
    }



    public void setmMoveMap(String choice, String player){

        switch (choice.toLowerCase()){

            case "cross":
                mMoveMap.put("X",player);
                break;
            case "zero":
                mMoveMap.put("O",player);
                break;


        }

    }

    public Player getmFirstPlayer() {
        return mFirstPlayer;
    }

    public Player getmSecondPlayer() {
        return mSecondPlayer;
    }

    public Boolean getmIsCompleted() {
        return mIsCompleted;
    }

    public GameBoard getmGameBoard() {
        return mGameBoard;
    }

    public String getmFirstPlayerPlays() {
        return mFirstPlayerPlays;
    }

    public String getmSecondPlayerPlays() {
        return mSecondPlayerPlays;
    }

    public void setmFirstPlayer(Player mFirstPlayer) {
        this.mFirstPlayer = mFirstPlayer;
    }

    public void setmSecondPlayer(Player mSecondPlayer) {
        this.mSecondPlayer = mSecondPlayer;
    }

    public void setmIsCompleted(Boolean mIsCompleted) {
        this.mIsCompleted = mIsCompleted;
    }

    public void setmGameBoard(GameBoard mGameBoard) {
        this.mGameBoard = mGameBoard;
    }

    public void setmFirstPlayerPlays(String mFirstPlayerPlays) {
        this.mFirstPlayerPlays = mFirstPlayerPlays;
    }

    public void setmSecondPlayerPlays(String mSecondPlayerPlays) {
        this.mSecondPlayerPlays = mSecondPlayerPlays;
    }
}
