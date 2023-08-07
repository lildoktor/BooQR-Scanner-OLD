package com.example.booqr;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FillActivity extends AppCompatActivity {

    ImageView imageView, imageView2, imageView3, imageView4;
    ImageView c1, c2, c3, c4;
    ImageView w1, w2, w3, w4;
    boolean cc1 = true;
    boolean cc2 = true;
    boolean cc3 = true;
    boolean cc4 = true;

    TextView textView;
    ProgressBar progressBar;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill);
        imageView = findViewById(R.id.button1);
        imageView2 = findViewById(R.id.button2);
        imageView3 = findViewById(R.id.button3);
        imageView4 = findViewById(R.id.button4);

        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);

        w1 = findViewById(R.id.w1);
        w2 = findViewById(R.id.w2);
        w3 = findViewById(R.id.w3);
        w4 = findViewById(R.id.w4);

        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.circularProgressbar);

        View.OnTouchListener touchListener = new View.OnTouchListener() {
            float dX, dY;

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dX = view.getX() - event.getRawX();
                        dY = view.getY() - event.getRawY();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        view.animate()
                                .x(event.getRawX() + dX)
                                .y(event.getRawY() + dY)
                                .setDuration(0)
                                .start();
                        break;
                    case MotionEvent.ACTION_UP:
//                        Toast.makeText(FillActivity.this, "X: " + view.getX() + " Y: " + view.getY(), Toast.LENGTH_SHORT).show();
                        if (view.getX() >= 332 && view.getX() <= 332 + 80 &&
                                view.getY() >= 600 && view.getY() <= 600 + 80) {
                            // The image has been dropped in the target area
                            counter++;
                            progressBar.setProgress(counter);
                            String text = counter + " / 4";
                            textView.setText(text);
                            if(counter == 4) {
                                Toast.makeText(FillActivity.this, "Task Successfully Completed", Toast.LENGTH_SHORT).show();
                            }
                            w2.setVisibility(View.GONE);
                            c2.setVisibility(View.VISIBLE);
                        }
                        if (view.getX() >= 647 && view.getX() <= 647 + 80 &&
                                view.getY() >= 542 && view.getY() <= 542 + 80)
                            w3.setVisibility(View.VISIBLE);
                        if (view.getX() >= 200 && view.getX() <= 200 + 80 &&
                                view.getY() >= 734 && view.getY() <= 734 + 80)
                            w1.setVisibility(View.VISIBLE);
                        if (view.getX() >= 827 && view.getX() <= 827 + 80 &&
                                view.getY() >= 660 && view.getY() <= 660 + 80)
                            w4.setVisibility(View.VISIBLE);
                        break;
                    default:
                        return false;
                }
                return true;
            }
        };

        View.OnTouchListener touchListener2 = new View.OnTouchListener() {
            float dX, dY;

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dX = view.getX() - event.getRawX();
                        dY = view.getY() - event.getRawY();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        view.animate()
                                .x(event.getRawX() + dX)
                                .y(event.getRawY() + dY)
                                .setDuration(0)
                                .start();
                        break;
                    case MotionEvent.ACTION_UP:
//                        Toast.makeText(FillActivity.this, "X: " + view.getX() + " Y: " + view.getY(), Toast.LENGTH_SHORT).show();
                        if (view.getX() >= 647 && view.getX() <= 647 + 80 &&
                                view.getY() >= 542 && view.getY() <= 542 + 80) {
                            // The image has been dropped in the target area
                            counter++;
                            progressBar.setProgress(counter);
                            String text = counter + " / 4";
                            textView.setText(text);
                            if(counter == 4) {
                                Toast.makeText(FillActivity.this, "Task Successfully Completed", Toast.LENGTH_SHORT).show();
                            }
                            w3.setVisibility(View.GONE);
                            c3.setVisibility(View.VISIBLE);
                        }
                        if (view.getX() >= 332 && view.getX() <= 332 + 80 &&
                                view.getY() >= 600 && view.getY() <= 600 + 80)
                            w2.setVisibility(View.VISIBLE);
                        if (view.getX() >= 200 && view.getX() <= 200 + 80 &&
                                view.getY() >= 734 && view.getY() <= 734 + 80)
                            w1.setVisibility(View.VISIBLE);
                        if (view.getX() >= 827 && view.getX() <= 827 + 80 &&
                                view.getY() >= 660 && view.getY() <= 660 + 80)
                            w4.setVisibility(View.VISIBLE);
                        break;
                    default:
                        return false;
                }
                return true;
            }
        };

        View.OnTouchListener touchListener3 = new View.OnTouchListener() {
            float dX, dY;

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dX = view.getX() - event.getRawX();
                        dY = view.getY() - event.getRawY();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        view.animate()
                                .x(event.getRawX() + dX)
                                .y(event.getRawY() + dY)
                                .setDuration(0)
                                .start();
                        break;
                    case MotionEvent.ACTION_UP:
//                        Toast.makeText(FillActivity.this, "X: " + view.getX() + " Y: " + view.getY(), Toast.LENGTH_SHORT).show();
                        if (view.getX() >= 200 && view.getX() <= 200 + 80 &&
                                view.getY() >= 734 && view.getY() <= 734 + 80) {
                            // The image has been dropped in the target area
                            counter++;
                            progressBar.setProgress(counter);
                            String text = counter + " / 4";
                            textView.setText(text);
                            if(counter == 4) {
                                Toast.makeText(FillActivity.this, "Task Successfully Completed", Toast.LENGTH_SHORT).show();
                            }
                            w1.setVisibility(View.GONE);
                            c1.setVisibility(View.VISIBLE);
                        }
                        if (view.getX() >= 332 && view.getX() <= 332 + 80 &&
                                view.getY() >= 600 && view.getY() <= 600 + 80)
                            w2.setVisibility(View.VISIBLE);
                        if (view.getX() >= 647 && view.getX() <= 647 + 80 &&
                                view.getY() >= 542 && view.getY() <= 542 + 80)
                            w3.setVisibility(View.VISIBLE);
                        if (view.getX() >= 827 && view.getX() <= 827 + 80 &&
                                view.getY() >= 660 && view.getY() <= 660 + 80)
                            w4.setVisibility(View.VISIBLE);
                        break;
                    default:
                        return false;
                }
                return true;
            }
        };

        View.OnTouchListener touchListener4 = new View.OnTouchListener() {
            float dX, dY;

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dX = view.getX() - event.getRawX();
                        dY = view.getY() - event.getRawY();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        view.animate()
                                .x(event.getRawX() + dX)
                                .y(event.getRawY() + dY)
                                .setDuration(0)
                                .start();
                        break;
                    case MotionEvent.ACTION_UP:
                        if (view.getX() >= 827 && view.getX() <= 827 + 80 &&
                                view.getY() >= 660 && view.getY() <= 660 + 80) {
                            // The image has been dropped in the target area
                            counter++;
                            progressBar.setProgress(counter);
                            String text = counter + " / 4";
                            textView.setText(text);
                            if(counter == 4) {
                                Toast.makeText(FillActivity.this, "Task Successfully Completed", Toast.LENGTH_SHORT).show();
                            }
                            w4.setVisibility(View.GONE);
                            c4.setVisibility(View.VISIBLE);
                        }
                        if (view.getX() >= 332 && view.getX() <= 332 + 80 &&
                                view.getY() >= 600 && view.getY() <= 600 + 80)
                            w2.setVisibility(View.VISIBLE);
                        if (view.getX() >= 647 && view.getX() <= 647 + 80 &&
                                view.getY() >= 542 && view.getY() <= 542 + 80)
                            w3.setVisibility(View.VISIBLE);
                        if (view.getX() >= 200 && view.getX() <= 200 + 80 &&
                                view.getY() >= 734 && view.getY() <= 734 + 80)
                            w1.setVisibility(View.VISIBLE);
                        break;
                    default:
                        return false;
                }
                return true;
            }
        };

        imageView.setOnTouchListener(touchListener);
        imageView2.setOnTouchListener(touchListener2);
        imageView3.setOnTouchListener(touchListener3);
        imageView4.setOnTouchListener(touchListener4);
    }
}