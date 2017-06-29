package com.example.tick_tack_toe.presenter;

import com.example.tick_tack_toe.model.Game;

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
    @Inject
    public TickTackToePresenter(Game game){

        this.mGame=game;

    }

    public Game getmGame() {
        return mGame;
    }
}
