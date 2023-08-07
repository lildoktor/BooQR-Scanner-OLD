package com.example.booqr;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.ResultPoint;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DecoratedBarcodeView barcodeView;
    private Button[] buttons = new Button[7];
    private boolean active = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < buttons.length; i++) {
            String buttonID = "button" + (i);
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i] = findViewById(resID);
        }

        buttons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                active = !active;
                if(active)
                    Toast.makeText(MainActivity.this, "Please Scan a QR Code", Toast.LENGTH_SHORT).show();
            }
        });
        buttons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        buttons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(active) {
                    Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                    startActivity(intent);
                }
            }
        });
        buttons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(active){
                    Intent intent = new Intent(MainActivity.this, ImageActivity.class);
                    startActivity(intent);
                }
            }
        });
        buttons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(active){
                    Intent intent = new Intent(MainActivity.this, AudioActivity.class);
                    startActivity(intent);
                }
            }
        });
        buttons[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(active){
                    Intent intent = new Intent(MainActivity.this, FillActivity.class);
                    startActivity(intent);
                }
            }
        });
        buttons[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(active) {
                    Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
                    startActivity(intent);
                }
            }
        });



        barcodeView = findViewById(R.id.scanner_view);
        barcodeView.setStatusText("");
        barcodeView.decodeContinuous(new BarcodeCallback() {

            @Override
            public void barcodeResult(BarcodeResult result) {
                String scanContent = result.getText();

                Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                intent.putExtra("videoUrl", scanContent);
                startActivity(intent);
            }

            @Override
            public void possibleResultPoints(List<ResultPoint> resultPoints) {
            }
        });


    }


    @Override
    protected void onResume() {
        super.onResume();
        barcodeView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        barcodeView.pause();
    }
}
