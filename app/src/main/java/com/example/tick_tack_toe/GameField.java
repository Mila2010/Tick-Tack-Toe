package com.example.tick_tack_toe;

import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by Millochka on 10/28/16.
 */

public class GameField {

    public static void printMoves(String[][] mMoveArray){


        for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            Log.d(TAG,mMoveArray[i][j]);


        }
    }
    }
}
