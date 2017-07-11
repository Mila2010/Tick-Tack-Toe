package com.example.tick_tack_toe.model;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by mila on 6/20/17.
 */

public class GameBoard {

    private String[][] mMoveArray;

    @Inject
   public GameBoard(){

        initMoveArray();

}


    public void initMoveArray(){

        mMoveArray=new String[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                mMoveArray[i][j]="*";


            }
        }
    }

    public void setmMoveArray(String[][] mMoveArray) {
        this.mMoveArray = mMoveArray;
    }

    public String[][] getmMoveArray() {
        return mMoveArray;
    }
}
