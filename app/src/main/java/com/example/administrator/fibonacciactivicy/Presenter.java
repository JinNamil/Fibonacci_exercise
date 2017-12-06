package com.example.administrator.fibonacciactivicy;

/**
 * Created by Administrator on 2017-12-06.
 */

public interface Presenter {

    void setView(Presenter.View view);

    void functionbtn(int result2);

    void DBfunction();

    void DBinsert(int num);

    public interface View{
        void functionbtn(int num);
        void DBfunction();
    }

}


