package com.example.booqr;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class ImageActivity extends AppCompatActivity {

    private ImageView imageView2;
    private ImageView imageView;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    TextView likes;
    private TextInputEditText editText;
    ImageView send;
    TextView text1;
    TextView text2;
    TextView text3;
    TextView qq;

    boolean t = true;

    boolean i = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        qq = findViewById(R.id.qq);
        imageView5 = findViewById(R.id.imageView5);

        likes = findViewById(R.id.likes);

        editText = findViewById(R.id.text);
        send = findViewById(R.id.send);

        text1 = findViewById(R.id.comments);
        text2 = findViewById(R.id.comments2);
        text3 = findViewById(R.id.comments3);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                editText.setText("");
                text1.setText(" All of 3 comments:");
                text2.setText(" Anonymous_1c32a:\n Anonymous_e53bl:\n Anonymous_1c32a:");
                text3.setText(" Great!\nWhy didnt you like it than\n idk");
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t){
                    imageView4.setImageResource(R.drawable.black_comment);
                    text1.setVisibility(View.VISIBLE);
                    text2.setVisibility(View.VISIBLE);
                    text3.setVisibility(View.VISIBLE);
                    editText.setVisibility(View.VISIBLE);
                    send.setVisibility(View.VISIBLE);
                    qq.setVisibility(View.VISIBLE);
                    t = false;

                }
                else{
                    text1.setVisibility(View.INVISIBLE);
                    text2.setVisibility(View.INVISIBLE);
                    text3.setVisibility(View.INVISIBLE);
                    editText.setVisibility(View.INVISIBLE);
                    send.setVisibility(View.INVISIBLE);
                    qq.setVisibility(View.INVISIBLE);
                    imageView4.setImageResource(R.drawable.baseline_mode_comment_24);
                    t = true;
                }
            }
        });

        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView5.setImageResource(R.drawable.black_share);
                // The path to the image, this can be from anywhere.
                // This should be the path to the image resource in your app
                Uri imageUri = Uri.parse("android.resource://your.package.name/" + R.drawable.ureme);  // Replace with your image resource
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
                shareIntent.setType("image/jpeg");
                startActivity(shareIntent);


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // This code will run after 1 second
                        imageView5.setImageResource(R.drawable.baseline_share_24);

                    }
                }, 1000);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i){
                    likes.setText("2 Likes");
                    imageView3.setImageResource(R.drawable.red_heart);
                    i = false;
                }
                else{
                    likes.setText("1 Likes");
                    imageView3.setImageResource(R.drawable.baseline_favorite_border_24);
                    i = true;
                }
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView2.setImageResource(R.drawable.black_cloud);
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ureme);  // Replace with your image resource
                String savedImageURL = MediaStore.Images.Media.insertImage(
                        getContentResolver(),
                        bitmap,
                        "Ureme",  // The title of the image
                        "Ureme gorsel"  // The description of the image
                );

                // Parse the gallery image url to uri
                Uri savedImageURI = Uri.parse(savedImageURL);

                // Display the saved image to the user
                Toast.makeText(getApplicationContext(), "Saved image to: " + savedImageURI, Toast.LENGTH_LONG).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // This code will run after 1 second
                        imageView2.setImageResource(R.drawable.baseline_cloud_download_24);
                    }
                }, 1000);

            }
        });
    }
}