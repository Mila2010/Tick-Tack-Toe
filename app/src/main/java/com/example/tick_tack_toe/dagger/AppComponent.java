package com.example.tick_tack_toe.dagger;

import com.example.tick_tack_toe.model.Game;
import com.example.tick_tack_toe.model.Player;
import com.example.tick_tack_toe.presenter.StartPagePresenter;
import com.example.tick_tack_toe.view.StartPageActivity;
import com.example.tick_tack_toe.view.TickTackToeFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mila on 6/27/17.
 */

@Singleton
@Component(
        modules = {
                PlayerModule.class

        }
)
public interface AppComponent {
    void inject(StartPageActivity activity);
    void inject(TickTackToeFragment fragment);
    @FirstPlayer
    Player getFirstPlayer();
    @SecondPlayer Player getSecondPlayer();

}
