package com.example.tick_tack_toe.model;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by mila on 6/20/17.
 */

public class Player {

    private String mName;
    private List<Game> mGamesCompleted;
    private List<Game> mCurrentGames;
    private String mMove;

    @Inject
    public Player(){

    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmMove(String move) {

        switch (move.toLowerCase()){

            case "cross":
                this.mMove = "X";
                break;
            case "zero":
                this.mMove = "0";
                break;


        }

    }
}
