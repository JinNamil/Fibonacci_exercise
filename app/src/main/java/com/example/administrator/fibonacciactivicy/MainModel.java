package com.example.administrator.fibonacciactivicy;

/**
 * Created by Administrator on 2017-12-06.
 */

public class MainModel {


    public String getClickedText() {
        return "Clicked";
    }

    public int function(int result2) {
        if (result2 == 1 || result2 == 2) {
            return 1;
        } else {
            return function(result2 - 2) + function(result2 - 1);
        }
    }
}