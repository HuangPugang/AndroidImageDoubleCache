package com.example.paul.cache;

import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.paul.cache.util.DoubleCache;
import com.example.paul.cache.util.ImageLoader;
import com.example.paul.cache.util.ImageLoaderConfig;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private ImageView imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.image);
        imageView2 = (ImageView) findViewById(R.id.image2);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageLoader.Builder builder = new ImageLoader.Builder(MainActivity.this);
                builder.setImageCache(new DoubleCache(MainActivity.this));
                ImageLoader loader = builder.create();
                loader.displayImage("http://img.my.csdn.net/uploads/201407/26/1406383299_1976.jpg", imageView);
//                ImageLoader.getInstance(MainActivity.this).displayImage("http://img.my.csdn.net/uploads/201407/26/1406383299_1976.jpg", imageView);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                ImageLoader.getInstance(MainActivity.this).displayImage("http://img.my.csdn.net/uploads/201407/26/1406383299_1976.jpg", imageView2);
            }
        });

    }
}
