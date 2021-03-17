package com.example.hello;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity1 extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        Log.d("activity_lifecycle", "onCeate called");
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();
            }
        });
    }

    public void openActivity2() {
        Intent intent = new Intent (this,Activity2.class);
        startActivity(intent);
    }
    public void openActivity3() {
        Intent intent = new Intent (this,Activity3.class);
        startActivity(intent);
    }
    private void openActivity4() {
        Intent intent = new Intent (this,Activity4.class);
        startActivity(intent);

    }
    private void openActivity5() {
        Intent intent = new Intent (this,Activity5.class);
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
