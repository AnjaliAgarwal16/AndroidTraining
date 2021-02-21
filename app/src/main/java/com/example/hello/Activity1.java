package com.example.hello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class Activity1 extends Activity {
    private Button button1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        Log.d( "activity_lifecycle","onCeate called");
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }
    public void openActivity2() {
        Intent intent = new Intent (this,Activity2.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d( "activity_lifecycle","onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d( "activity_lifecycle","onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d( "activity_lifecycle","onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d( "activity_lifecycle","onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d( "activity_lifecycle","onDestroy called");
    }
}