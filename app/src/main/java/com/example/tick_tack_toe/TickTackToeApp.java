package com.example.tick_tack_toe;

import android.app.Application;

import com.example.tick_tack_toe.dagger.AppComponent;
import com.example.tick_tack_toe.dagger.DaggerAppComponent;

/**
 * Created by mila on 6/27/17.
 */

public class TickTackToeApp extends Application {

    private static AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    static public AppComponent getAppComponent() {
        if (mAppComponent == null){
            mAppComponent = DaggerAppComponent.builder()
                    .build();
        }
        return mAppComponent;
    }
}
