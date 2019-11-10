package com.example.yabai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // GETボタンとPOSTボタン取得
        Button getButton = findViewById(R.id.getButton);
        Button postButton = findViewById(R.id.postButton);

        // GETボタンがタップされた時
        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpGet getTask = new OkHttpGet();
                getTask.execute();
            }
        });

        // POSTボタンが押された時
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpPost postTask = new OkHttpPost();
                postTask.execute();
            }

        });
    }
}
