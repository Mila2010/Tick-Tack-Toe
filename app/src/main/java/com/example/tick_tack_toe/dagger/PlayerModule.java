package com.example.tick_tack_toe.dagger;

import com.example.tick_tack_toe.model.Player;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mila on 6/28/17.
 */
@Module
public class PlayerModule {

@Provides @Singleton @FirstPlayer
public Player providesFirstPlayer(){

    return new Player();
}

    @Provides @Singleton @SecondPlayer
    public Player providesSecondPlayer(){

        return new Player();
    }
}


