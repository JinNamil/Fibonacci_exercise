package com.example.administrator.fibonacciactivicy;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Administrator on 2017-12-06.
 */

public class PresenterImpl extends AppCompatActivity implements Presenter {

    private final MainModel mainModel;
    private Activity activity;
    private Presenter.View view;
    private TextView textView1 = (TextView) activity.findViewById(R.id.text1);
    private TextView textView2 = (TextView) activity.findViewById(R.id.text2);
    private SQLiteActivity sqLiteActivity = new SQLiteActivity(PresenterImpl.this, "number.db", null, 1);
    private Resources resources = Resources.getSystem();

    public PresenterImpl(Activity activity) {
        this.activity = activity;
        this.mainModel = new MainModel();
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void functionbtn(int result2) {
        textView1.setText(mainModel.function(result2));
    }

    @Override
    public void DBfunction() {
        textView2.setText(sqLiteActivity.DBdata());
    }

    @Override
    public void DBinsert(int num) {
        String insert_str = String.format(resources.getString(R.string.db_insert), num, mainModel.function(num));
        sqLiteActivity.insert(insert_str);
    }


}
