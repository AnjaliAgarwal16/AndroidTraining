package com.example.hello;

import android.app.Fragment;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class Activity3 extends AppCompatActivity implements fragment1.Fragment1Listener, fragment2.Fragment2Listener{

    private fragment1 Fragment1;
    private fragment2 Fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);



        Fragment1 = new fragment1();
        Fragment2= new fragment2();

        getSupportFragmentManager().beginTransaction()
                                   .replace(R.id.container1,Fragment1)
                                   .replace(R.id.container2,Fragment2)
                                   .commit();


    }

    @Override
    public void onInput1Sent(CharSequence input) {
        Fragment1.updateEditText(input);

    }

    @Override
    public void onInput2Sent(CharSequence input) {
        Fragment2.updateEditText(input);

    }
}