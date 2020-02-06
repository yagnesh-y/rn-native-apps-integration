package com.example.native_android;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.LinkedHashMap;


public class MainActivity extends AppCompatActivity {

    private static final int OVERLAY_PERMISSION_REQ_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btReactView1 = (Button) findViewById(R.id.open_rn_activity_1);
        btReactView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // go to react view
                Intent intent = ActivityOne.createIntent(MainActivity.this);
                intent.putExtra("screen","one");
                startActivity(intent);
            }
        });

        Button btReactView2 = (Button) findViewById(R.id.open_rn_activity_2);
        btReactView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // go to react view
                Intent intent = ActivityOne.createIntent(MainActivity.this);
                intent.putExtra("screen","two");
                startActivity(intent);
            }
        });
    }
}