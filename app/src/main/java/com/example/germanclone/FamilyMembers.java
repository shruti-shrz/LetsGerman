package com.example.germanclone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_members);
        ArrayList<family> mylist2 = new ArrayList<family>(5);
        mylist2.add(new family("The family","die Familie"));
        mylist2.add(new family("The father","der Vater"));
        mylist2.add(new family("The mother","die Mutter"));
        mylist2.add(new family("The grandparents","die Großeltern"));
        mylist2.add(new family("The grandmother","die Großmutter"));
        mylist2.add(new family("The grandfathe","der Großvater"));
        mylist2.add(new family("The grandchildren","die Enkelkinder"));
        mylist2.add(new family("The granddaughter","die Enkelin"));
        mylist2.add(new family("The grandson","der Enkel"));
        mylist2.add(new family("The child","das Kind"));
        mylist2.add(new family("The children","die Kinder"));
        mylist2.add(new family("The siblings","die Geschwister"));
        mylist2.add(new family("The sister ","die Schwester"));
        mylist2.add(new family("The brother","der Bruder"));
        mylist2.add(new family("The son","der Sohn"));
        mylist2.add(new family("The daughter","die Tochter"));
        mylist2.add(new family("The wife","die Ehefrau"));
        mylist2.add(new family("The husband","der Ehemann"));
        mylist2.add(new family("The half-brother","der Halbbruder"));
        mylist2.add(new family("The half-sister","die Halbschwester"));
        mylist2.add(new family("The uncle","der Onkel"));
        mylist2.add(new family("The aunt","die Tante"));
        mylist2.add(new family("The cousin (male)","der Cousin"));
        mylist2.add(new family("The cousin (female)","die Cousine"));
        mylist2.add(new family("The nephew","der Neffe"));
        mylist2.add(new family("The niece","die Nichte"));
        mylist2.add(new family("Single","Ledig"));
        mylist2.add(new family("Married","Verheiratet"));
        mylist2.add(new family("Divorced","Geschieden"));
        mylist2.add(new family("Widow","Verwitmet"));
        mylist2.add(new family("Separated","Getrennt"));
     familyadapter words = new familyadapter(this,mylist2,R.color.purple);
        ListView listView = findViewById(R.id.familyroot);
        listView.setAdapter(words);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
