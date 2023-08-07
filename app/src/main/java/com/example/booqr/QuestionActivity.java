package com.example.booqr;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionActivity extends AppCompatActivity {

    private Button button1, button2, button3, button4, button5;
    private String correctAnswer = "B";  // set this according to your question

    private ProgressBar mProgressBar;
    private TextView mLoadingText;

    private int mProgressStatus = 0;

    private Handler mHandler = new Handler();
    boolean stop = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        View.OnClickListener clickListener = v -> {
            Button b = (Button) v;
            if (b.getText().equals(correctAnswer)) {
                b.setBackground(getDrawable(R.drawable.rounded_button_green));
                button1.setClickable(false);
                button2.setClickable(false);
                button3.setClickable(false);
                button4.setClickable(false);
                button5.setClickable(false);
                stop = true;
            } else {
                b.setBackground(getDrawable(R.drawable.rounded_button_red));
                button2.setBackground(getDrawable(R.drawable.rounded_button_green));

                button1.setClickable(false);
                button2.setClickable(false);
                button3.setClickable(false);
                button4.setClickable(false);
                button5.setClickable(false);
                stop = true;
            }
        };

        button1.setOnClickListener(clickListener);
        button2.setOnClickListener(clickListener);
        button3.setOnClickListener(clickListener);
        button4.setOnClickListener(clickListener);
        button5.setOnClickListener(clickListener);


        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgressStatus < 10000 && !stop){
                    mProgressStatus++;
                    android.os.SystemClock.sleep(6);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar.setProgress(mProgressStatus);
                        }
                    });
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(!stop)
                            Toast.makeText(QuestionActivity.this, "Time's up!", Toast.LENGTH_SHORT).show();
                        button2.setBackground(getDrawable(R.drawable.rounded_button_green));
                        button1.setClickable(false);
                        button2.setClickable(false);
                        button3.setClickable(false);
                        button4.setClickable(false);
                        button5.setClickable(false);
                    }
                });
            }
        }).start();

    }
}