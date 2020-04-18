package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private EditText num ;

    private TextView opt1;
    private TextView opt2;
    private TextView opt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        num = findViewById(R.id.ques);

        opt1 = findViewById(R.id.option1);
        opt2 = findViewById(R.id.option2);
        opt3 = findViewById(R.id.option3);

        Log.d(TAG, "onCreate: Hello!");
    }

    public boolean checkSquare(int n){
        double sq = Math.sqrt(n);

        return ((sq - Math.floor(sq)) == 0);
    }

    public int factor(int n, boolean x){
        int f, a, b;
        a = (int) Math.ceil(Math.sqrt(n));
        while (true){
            b = (a * a) - n;
            if(checkSquare(b)){
                break;
            }
            a++;
        }
        f = (int) (x? (a+Math.sqrt(b)):(a-Math.sqrt(b)));
        return f;

    }

    public int nonFactor(int n, int f, boolean x){
        int a;
        Random Rn = new Random();
        a = Rn.nextInt(f);
        while(n%a != 0 && a==f){
            if(x) --a;
            else ++a;
        }
        return a;
    }

    public void ok(View view) {
        game();
    }

    public void next(View view) {
        num.setText("");

        opt1.setVisibility(View.GONE);
        opt2.setVisibility(View.GONE);
        opt3.setVisibility(View.GONE);

        opt1.setBackground(getResources().getDrawable(R.drawable.left_border));
        opt2.setBackground(getResources().getDrawable(R.drawable.left_border));
        opt3.setBackground(getResources().getDrawable(R.drawable.left_border));

        opt1.setTextColor(getResources().getColor(R.color.text));
        opt2.setTextColor(getResources().getColor(R.color.text));
        opt3.setTextColor(getResources().getColor(R.color.text));
        Log.d(TAG, "onClick: NEXT");
    }

    public void game(){
        try{

            boolean x =  (0.5 - Math.random())>0;
            int inp = Integer.parseInt(String.valueOf(num.getText()));
            int fac = factor(inp, x);

            opt1.setVisibility(View.VISIBLE);
            opt2.setVisibility(View.VISIBLE);
            opt3.setVisibility(View.VISIBLE);

            final int c = (int) Math.ceil(Math.random()*10);
            int b = nonFactor(inp, fac, x);
            if(c%3==0){
                opt3.setText(String.valueOf(fac));
                opt2.setText(String.valueOf(b));
                opt1.setText(String.valueOf(nonFactor(inp, b, x)));
            }
            else if(c%3==1){
                opt1.setText(String.valueOf(fac));
                opt3.setText(String.valueOf(b));
                opt2.setText(String.valueOf(nonFactor(inp, b, x)));

            }
            else {
                opt2.setText(String.valueOf(fac));
                opt1.setText(String.valueOf(b));
                opt3.setText(String.valueOf(nonFactor(inp, b, x)));
            }

            opt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(c%3==0){
                        opt1.setBackgroundColor(getResources().getColor(R.color.wrong));
                        opt1.setTextColor(getResources().getColor(R.color.wrong_text));

                        opt3.setBackgroundColor(getResources().getColor(R.color.right));
                        opt3.setTextColor(getResources().getColor(R.color.right_text));
                    }
                    else if(c%3==1){
                        //opt1.setBackgroundColor(getResources().getColor(R.color.wrong));
                        //opt1.setTextColor(getResources().getColor(R.color.wrong_text));

                        opt1.setBackgroundColor(getResources().getColor(R.color.right));
                        opt1.setTextColor(getResources().getColor(R.color.right_text));
                    }
                    else{
                        opt1.setBackgroundColor(getResources().getColor(R.color.wrong));
                        opt1.setTextColor(getResources().getColor(R.color.wrong_text));

                        opt2.setBackgroundColor(getResources().getColor(R.color.right));
                        opt2.setTextColor(getResources().getColor(R.color.right_text));
                    }
                }
            });

            opt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(c%3==0){
                        opt2.setBackgroundColor(getResources().getColor(R.color.wrong));
                        opt2.setTextColor(getResources().getColor(R.color.wrong_text));

                        opt3.setBackgroundColor(getResources().getColor(R.color.right));
                        opt3.setTextColor(getResources().getColor(R.color.right_text));
                    }
                    else if(c%3==1){
                        opt2.setBackgroundColor(getResources().getColor(R.color.wrong));
                        opt2.setTextColor(getResources().getColor(R.color.wrong_text));

                        opt1.setBackgroundColor(getResources().getColor(R.color.right));
                        opt1.setTextColor(getResources().getColor(R.color.right_text));
                    }
                    else{
                        //opt2.setBackgroundColor(getResources().getColor(R.color.wrong));
                        //opt2.setTextColor(getResources().getColor(R.color.wrong_text));

                        opt2.setBackgroundColor(getResources().getColor(R.color.right));
                        opt2.setTextColor(getResources().getColor(R.color.right_text));
                    }

                }
            });

            opt3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(c%3==0){
                        //opt1.setBackgroundColor(getResources().getColor(R.color.wrong));
                        //opt1.setTextColor(getResources().getColor(R.color.wrong_text));

                        opt3.setBackgroundColor(getResources().getColor(R.color.right));
                        opt3.setTextColor(getResources().getColor(R.color.right_text));
                    }
                    else if(c%3==1){
                        opt3.setBackgroundColor(getResources().getColor(R.color.wrong));
                        opt3.setTextColor(getResources().getColor(R.color.wrong_text));

                        opt1.setBackgroundColor(getResources().getColor(R.color.right));
                        opt1.setTextColor(getResources().getColor(R.color.right_text));
                    }
                    else{
                        opt3.setBackgroundColor(getResources().getColor(R.color.wrong));
                        opt3.setTextColor(getResources().getColor(R.color.wrong_text));

                        opt2.setBackgroundColor(getResources().getColor(R.color.right));
                        opt2.setTextColor(getResources().getColor(R.color.right_text));
                    }

                }
            });




            Log.d(TAG, "ok: "+inp);
        } catch(Exception e){
            Toast toast = Toast.makeText(this, "Not an Integer", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
