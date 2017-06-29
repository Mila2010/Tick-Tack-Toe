package com.example.tick_tack_toe.presenter;

import com.example.tick_tack_toe.model.Game;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by mila on 6/27/17.
 */
@Singleton
public class StartPagePresenter {

    private Game mGame;

    @Inject
    public StartPagePresenter(Game game){

        this.mGame=game;

    }

    public Game getmGame() {
        return mGame;
    }

    public void setmGame(Game mGame) {
        this.mGame = mGame;
    }


}
