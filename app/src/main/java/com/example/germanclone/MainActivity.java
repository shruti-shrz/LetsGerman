package com.example.germanclone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void openfamily(View view)
    {
        Intent i = new Intent(this,FamilyMembers.class);
        startActivity(i);
    }
public void number(View v)
{
    Intent j = new Intent(this,Numbers.class);
    startActivity(j);
}
public void colors(View u)
{
    Intent k = new Intent(this,Colors.class);
    startActivity(k);
}
public void phrases(View w)
{
    Intent l = new Intent(this,Phases.class);
    startActivity(l);
}
}
