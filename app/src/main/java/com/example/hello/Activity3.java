package com.example.hello;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

//This class demonstrates navigation between fragments and pasing of data between them

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
