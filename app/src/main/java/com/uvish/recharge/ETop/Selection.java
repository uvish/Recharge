package com.uvish.recharge.ETop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Selection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
    }
    public void mobile(View v)
    {
        Intent i=new Intent(this, com.uvish.recharge.ETop.MainActivity.class);
        startActivity(i);
    }
    public void dth(View v)
    {
        Intent i=new Intent(this, com.uvish.recharge.ETop.dth.class);
        startActivity(i);
    }
    public void care(View v)
    {
        Intent i=new Intent(this, com.uvish.recharge.ETop.cc.class);
        startActivity(i);
    }
    public void custom(View v)
    {
        Intent i=new Intent(this, com.uvish.recharge.ETop.Custom.class);
        startActivity(i);
    }
}
