package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences mPreferences;
    private String sharedPrefFile = "com.example.android.myapplication";
    private static final String TAG = "MainActivity";
    private EditText num;
    private TextView current;
    private TextView best;
    private int current_count = 0;
    private int best_count;
    private Vibrator vib;

    private TextView opt1;
    private TextView opt2;
    private TextView opt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        num = findViewById(R.id.ques);

        opt1 = findViewById(R.id.option1);
        opt2 = findViewById(R.id.option2);
        opt3 = findViewById(R.id.option3);

        current = findViewById(R.id.current);
        best = findViewById(R.id.best);

        Log.d(TAG, "onCreate: Hello!");

        best_count = mPreferences.getInt("BEST", 0);
        best.setText(String.valueOf(best_count));
        current.setText(String.valueOf(current_count));

        if (savedInstanceState != null) {
            boolean isVisible = savedInstanceState.getBoolean("isVisible");
            current_count = savedInstanceState.getInt("current");
            current.setText(String.valueOf(current_count));

            if (isVisible) {
                final int a, b, c, n;
                a = savedInstanceState.getInt("option1");
                b = savedInstanceState.getInt("option2");
                c = savedInstanceState.getInt("option3");
                n = Integer.parseInt(savedInstanceState.getString("text"));

                opt1.setVisibility(View.VISIBLE);
                opt2.setVisibility(View.VISIBLE);
                opt3.setVisibility(View.VISIBLE);

                opt1.setText(String.valueOf(a));
                opt2.setText(String.valueOf(b));
                opt3.setText(String.valueOf(c));

                opt1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (n % c == 0) {
                            opt1.setBackgroundColor(getResources().getColor(R.color.wrong));
                            opt1.setTextColor(getResources().getColor(R.color.wrong_text));

                            opt3.setBackgroundColor(getResources().getColor(R.color.right));
                            opt3.setTextColor(getResources().getColor(R.color.right_text));
                            current_count = 0;
                            vibe();
                        } else if (n % a == 0) {
                            //opt1.setBackgroundColor(getResources().getColor(R.color.wrong));
                            //opt1.setTextColor(getResources().getColor(R.color.wrong_text));

                            opt1.setBackgroundColor(getResources().getColor(R.color.right));
                            opt1.setTextColor(getResources().getColor(R.color.right_text));
                            current_count++;
                        } else if (n % b == 0) {
                            opt1.setBackgroundColor(getResources().getColor(R.color.wrong));
                            opt1.setTextColor(getResources().getColor(R.color.wrong_text));

                            opt2.setBackgroundColor(getResources().getColor(R.color.right));
                            opt2.setTextColor(getResources().getColor(R.color.right_text));
                            current_count = 0;
                            vibe();
                        }
                        opt1.setClickable(false);
                        opt2.setClickable(false);
                        opt3.setClickable(false);
                    }
                });

                opt2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (n % c == 0) {
                            opt2.setBackgroundColor(getResources().getColor(R.color.wrong));
                            opt2.setTextColor(getResources().getColor(R.color.wrong_text));

                            opt3.setBackgroundColor(getResources().getColor(R.color.right));
                            opt3.setTextColor(getResources().getColor(R.color.right_text));
                            current_count = 0;
                            vibe();
                        } else if (n % a == 0) {
                            opt2.setBackgroundColor(getResources().getColor(R.color.wrong));
                            opt2.setTextColor(getResources().getColor(R.color.wrong_text));

                            opt1.setBackgroundColor(getResources().getColor(R.color.right));
                            opt1.setTextColor(getResources().getColor(R.color.right_text));
                            current_count = 0;
                            vibe();
                        } else if (n % b == 0) {
                            //opt2.setBackgroundColor(getResources().getColor(R.color.wrong));
                            //opt2.setTextColor(getResources().getColor(R.color.wrong_text));

                            opt2.setBackgroundColor(getResources().getColor(R.color.right));
                            opt2.setTextColor(getResources().getColor(R.color.right_text));
                            current_count++;
                        }
                        opt1.setClickable(false);
                        opt2.setClickable(false);
                        opt3.setClickable(false);

                    }
                });

                opt3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (n % c == 0) {
                            //opt1.setBackgroundColor(getResources().getColor(R.color.wrong));
                            //opt1.setTextColor(getResources().getColor(R.color.wrong_text));

                            opt3.setBackgroundColor(getResources().getColor(R.color.right));
                            opt3.setTextColor(getResources().getColor(R.color.right_text));
                            current_count++;
                        } else if (n % a == 0) {
                            opt3.setBackgroundColor(getResources().getColor(R.color.wrong));
                            opt3.setTextColor(getResources().getColor(R.color.wrong_text));

                            opt1.setBackgroundColor(getResources().getColor(R.color.right));
                            opt1.setTextColor(getResources().getColor(R.color.right_text));
                            current_count = 0;
                            vibe();
                        } else if (n % b == 0) {
                            opt3.setBackgroundColor(getResources().getColor(R.color.wrong));
                            opt3.setTextColor(getResources().getColor(R.color.wrong_text));

                            opt2.setBackgroundColor(getResources().getColor(R.color.right));
                            opt2.setTextColor(getResources().getColor(R.color.right_text));
                            current_count = 0;
                            vibe();
                        }
                        opt1.setClickable(false);
                        opt2.setClickable(false);
                        opt3.setClickable(false);

                    }
                });

                current.setText(String.valueOf(current_count));
            }
        }
    }

    public void vibe(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vib.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
        }
        else {
            vib.vibrate(500);
        }
        num.setHint("Wrong answer");
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt("BEST", best_count);
        preferencesEditor.apply();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("current", current_count);

        if (opt1.getVisibility() == View.VISIBLE) {
            outState.putBoolean("isVisible", true);
            outState.putInt("option1", Integer.parseInt(opt1.getText().toString()));
            outState.putInt("option2", Integer.parseInt(opt2.getText().toString()));
            outState.putInt("option3", Integer.parseInt(opt3.getText().toString()));
            outState.putString("text", num.getText().toString());
        }

    }


    public Vector<Integer> factors(int n) {
        Vector<Integer> ret = new Vector<>();
        int i = 1;
        while (i * i <= n) {
            if (n % i == 0) {
                if (i != n / i) {
                    ret.addElement(i);
                    ret.addElement((n / i));
                } else {
                    ret.addElement(i);
                }
            }


            i++;
        }
        return ret;
    }

    public int randomfactor(Vector<Integer> v) {
        Random Rn = new Random();
        int a = Rn.nextInt(v.size());

        return v.get(a);

    }

    public int nonFactor(int n, int f) {
        int a;
        Random Rn = new Random();
        a = Rn.nextInt(n);
        while ((n % a == 0) || (a == f)) {
            a++;
        }
        return a;
    }

    public void ok(View view) {
        opt1.setBackground(getResources().getDrawable(R.drawable.left_border));
        opt2.setBackground(getResources().getDrawable(R.drawable.left_border));
        opt3.setBackground(getResources().getDrawable(R.drawable.left_border));

        opt1.setTextColor(getResources().getColor(R.color.text));
        opt2.setTextColor(getResources().getColor(R.color.text));
        opt3.setTextColor(getResources().getColor(R.color.text));

        num.setHintTextColor(getResources().getColor(R.color.text));
        num.setHint(R.string.ques);
        game();
        if (current_count > best_count) {
            best_count = current_count;
            best.setText(String.valueOf(best_count));
        }
    }

    public void next(View view) {
        current.setText(String.valueOf(current_count));
        if (current_count > best_count) {
            best_count = current_count;
            best.setText(String.valueOf(best_count));
        }
        num.setText("");
        num.setHintTextColor(getResources().getColor(R.color.text));
        num.setHint(R.string.ques);

        opt1.setVisibility(View.GONE);
        opt2.setVisibility(View.GONE);
        opt3.setVisibility(View.GONE);

        opt1.setBackground(getResources().getDrawable(R.drawable.left_border));
        opt2.setBackground(getResources().getDrawable(R.drawable.left_border));
        opt3.setBackground(getResources().getDrawable(R.drawable.left_border));

        opt1.setTextColor(getResources().getColor(R.color.text));
        opt2.setTextColor(getResources().getColor(R.color.text));
        opt3.setTextColor(getResources().getColor(R.color.text));
        num.setTextColor(getResources().getColor(R.color.text));
        Log.d(TAG, "onClick: NEXT");
    }

    public void game() {
        try {
            int inp = Integer.parseInt(String.valueOf(num.getText()));
            int fac = randomfactor(factors(inp));

            opt1.setVisibility(View.VISIBLE);
            opt2.setVisibility(View.VISIBLE);
            opt3.setVisibility(View.VISIBLE);

            final int c = (int) Math.ceil(Math.random() * 10);
            int b = nonFactor(inp, fac);
            if (c % 3 == 0) {
                opt3.setText(String.valueOf(fac));
                opt2.setText(String.valueOf(b));
                opt1.setText(String.valueOf(nonFactor(inp, fac)));
            } else if (c % 3 == 1) {
                opt1.setText(String.valueOf(fac));
                opt3.setText(String.valueOf(b));
                opt2.setText(String.valueOf(nonFactor(inp, fac)));

            } else {
                opt2.setText(String.valueOf(fac));
                opt1.setText(String.valueOf(b));
                opt3.setText(String.valueOf(nonFactor(inp, fac)));
            }



            opt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (c % 3 == 0) {
                        opt1.setBackgroundColor(getResources().getColor(R.color.wrong));
                        opt1.setTextColor(getResources().getColor(R.color.wrong_text));

                        opt3.setBackgroundColor(getResources().getColor(R.color.right));
                        opt3.setTextColor(getResources().getColor(R.color.right_text));
                        current_count = 0;
                        vibe();
                    } else if (c % 3 == 1) {
                        //opt1.setBackgroundColor(getResources().getColor(R.color.wrong));
                        //opt1.setTextColor(getResources().getColor(R.color.wrong_text));

                        opt1.setBackgroundColor(getResources().getColor(R.color.right));
                        opt1.setTextColor(getResources().getColor(R.color.right_text));
                        current_count++;
                    } else {
                        opt1.setBackgroundColor(getResources().getColor(R.color.wrong));
                        opt1.setTextColor(getResources().getColor(R.color.wrong_text));

                        opt2.setBackgroundColor(getResources().getColor(R.color.right));
                        opt2.setTextColor(getResources().getColor(R.color.right_text));
                        current_count = 0;
                        vibe();
                    }

                    opt1.setClickable(false);
                    opt2.setClickable(false);
                    opt3.setClickable(false);
                }
            });


            opt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (c % 3 == 0) {
                        opt2.setBackgroundColor(getResources().getColor(R.color.wrong));
                        opt2.setTextColor(getResources().getColor(R.color.wrong_text));

                        opt3.setBackgroundColor(getResources().getColor(R.color.right));
                        opt3.setTextColor(getResources().getColor(R.color.right_text));
                        current_count = 0;
                        vibe();
                    } else if (c % 3 == 1) {
                        opt2.setBackgroundColor(getResources().getColor(R.color.wrong));
                        opt2.setTextColor(getResources().getColor(R.color.wrong_text));

                        opt1.setBackgroundColor(getResources().getColor(R.color.right));
                        opt1.setTextColor(getResources().getColor(R.color.right_text));
                        current_count = 0;
                        vibe();
                    } else {
                        //opt2.setBackgroundColor(getResources().getColor(R.color.wrong));
                        //opt2.setTextColor(getResources().getColor(R.color.wrong_text));

                        opt2.setBackgroundColor(getResources().getColor(R.color.right));
                        opt2.setTextColor(getResources().getColor(R.color.right_text));
                        current_count++;
                    }
                    opt1.setClickable(false);
                    opt2.setClickable(false);
                    opt3.setClickable(false);

                }
            });


            opt3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (c % 3 == 0) {
                        //opt1.setBackgroundColor(getResources().getColor(R.color.wrong));
                        //opt1.setTextColor(getResources().getColor(R.color.wrong_text));

                        opt3.setBackgroundColor(getResources().getColor(R.color.right));
                        opt3.setTextColor(getResources().getColor(R.color.right_text));
                        current_count++;
                    } else if (c % 3 == 1) {
                        opt3.setBackgroundColor(getResources().getColor(R.color.wrong));
                        opt3.setTextColor(getResources().getColor(R.color.wrong_text));

                        opt1.setBackgroundColor(getResources().getColor(R.color.right));
                        opt1.setTextColor(getResources().getColor(R.color.right_text));
                        current_count = 0;
                        vibe();
                    } else {
                        opt3.setBackgroundColor(getResources().getColor(R.color.wrong));
                        opt3.setTextColor(getResources().getColor(R.color.wrong_text));

                        opt2.setBackgroundColor(getResources().getColor(R.color.right));
                        opt2.setTextColor(getResources().getColor(R.color.right_text));
                        current_count = 0;
                        vibe();
                    }
                    opt1.setClickable(false);
                    opt2.setClickable(false);
                    opt3.setClickable(false);

                }
            });

            current.setText(String.valueOf(current_count));

            Log.d(TAG, "ok: " + inp);
        } catch (Exception e) {
            num.setText("");
            num.setHintTextColor(getResources().getColor(R.color.wrong_toast));
            num.setHint("Invalid number");
            opt1.setVisibility(View.GONE);
            opt2.setVisibility(View.GONE);
            opt3.setVisibility(View.GONE);
            Toast toast = Toast.makeText(this, "Try again", Toast.LENGTH_SHORT);
            toast.show();
        }
    }



}