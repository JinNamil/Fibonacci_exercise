package com.example.administrator.fibonacciactivicy;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
//    private SQLiteActivity sqLiteActivity = new SQLiteActivity(MainActivity.this, "number.db", null, 1);
    private Presenter presenter;
    private MainModel mainModel;
    private Button button, DBbutton, slbutton;
    private EditText editText;
    private SQLiteActivity sqLiteActivity = new SQLiteActivity(MainActivity.this, "number.db", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         button = (Button) findViewById(R.id.btn);
         DBbutton = (Button) findViewById(R.id.db);
         slbutton = (Button) findViewById(R.id.select);
//         editText = (EditText) findViewById(R.id.fb);
//        presenter = new PresenterImpl(MainActivity.this);



/**
 * setOnClickListener -> Lambda
 */
        DBbutton.setOnClickListener(v -> {
                    /**
                     * strings.xml
                     * Insert into Table that SQLite
                     */

                     EditText editText1 = (EditText) findViewById(R.id.fb);
                     String str1 = editText1.getText().toString();
                     int num = Integer.parseInt(str1);
                    Resources resources = getResources();
//                    presenter.DBinsert(num);
                    String insert_str = String.format(resources.getString(R.string.db_insert), num, function(num));
                    sqLiteActivity.insert(insert_str);
                }
        );

        slbutton.setOnClickListener(view -> {
             EditText editText1 = (EditText) findViewById(R.id.fb);
             String str1 = editText1.getText().toString();
             int num = Integer.parseInt(str1);
            TextView textView2 = (TextView)findViewById(R.id.text2);
//            presenter.DBfunction();
            textView2.setText(sqLiteActivity.DBdata());
        });


        button.setOnClickListener(view -> {
             EditText editText1 = (EditText) findViewById(R.id.fb);
             String str1 = editText1.getText().toString();
             int num = Integer.parseInt(str1);
            TextView textView1 = (TextView)findViewById(R.id.text1);
            textView1.setText("값 : "+function(num));
//            presenter.functionbtn(num);
        });
    }

    /**
     * Fibonacci -------------------------------------
     * 대입값이 1과2일때는 1
     * 그 이상부터는 대입값-2의 수와 대입값-1의 수를 더한다.
     */
    public int function(int result2) {
        if (result2 == 1 || result2 == 2) {
            return 1;
        } else {
            return function(result2 - 2) + function(result2 - 1);
        }
    }

//    @Override
//    public void setConfirmText(int a) {
//        button.setText(a);
//    }
}

