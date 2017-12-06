package com.example.administrator.fibonacciactivicy;

import org.junit.Test;

/**
 * Created by Administrator on 2017-12-06. Test----
 */

public class sumActivity_test {
    @Test
    public void testAdd(){
        sumActivity sumActivity = new sumActivity();
        int example = sumActivity.add(20,20);
        int result = 20+20;
        assert (example == result);
    }
}
