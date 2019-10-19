package com.example.germanclone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class Phases extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phases);
        ArrayList<phrases> mylist4 = new ArrayList<phrases>(10);
        mylist4.add(new phrases("Help!","Hilfe!","GERMAN PHRASES FOR EMERGENCY"));
        mylist4.add(new phrases("Police!","Polizei!",""));
        mylist4.add(new phrases("Fire!","Feuer!",""));
        mylist4.add(new phrases("Get a doctor!","Holen Sie einen Arzt!",""));
        mylist4.add(new phrases("I am sick.","Ich bin Krank.",""));
        mylist4.add(new phrases("Hello!","Hallo!","GERMAN PHRASE FOE GREETING"));
        mylist4.add(new phrases("Good day!","Guten Tag!",""));
        mylist4.add(new phrases("Good evening!","Guten Abend!",""));
        mylist4.add(new phrases("Good-bye!","Auf Wiedersehen!",""));
        mylist4.add(new phrases("Please./You’re welcome.","Bitte.",""));
        mylist4.add(new phrases("Thank you.","Danke.",""));
        mylist4.add(new phrases("Excuse me.","Entschuldigung.",""));
        mylist4.add(new phrases("My name is…","Ich heiße….",""));
        mylist4.add(new phrases("Pleased to meet you.","Freut mich.",""));
        mylist4.add(new phrases("Monday","Montag","WEEKS IN GERMAN"));
        mylist4.add(new phrases("Tuesday","Dienstag",""));
        mylist4.add(new phrases("Wednesday","Mittwoch",""));
        mylist4.add(new phrases("Thursday","Donnerstag",""));
        mylist4.add(new phrases("Friday","Freitag",""));
        mylist4.add(new phrases("Saturday","Samstag",""));
        mylist4.add(new phrases("Sunday","Sonntag",""));
        mylist4.add(new phrases("January","Januar","MONTHS IN GERMAN"));
        mylist4.add(new phrases("February","Februar",""));
        mylist4.add(new phrases("March","März",""));
        mylist4.add(new phrases("April","April",""));
        mylist4.add(new phrases("May","Mai",""));
        mylist4.add(new phrases("June","Juni",""));
        mylist4.add(new phrases("July","Juli",""));
        mylist4.add(new phrases("August","August",""));
        mylist4.add(new phrases("September","September",""));
        mylist4.add(new phrases("October","Oktober",""));
        mylist4.add(new phrases("November","November",""));
        mylist4.add(new phrases("December","Dezember",""));
        phrasesadapter word = new phrasesadapter(this,mylist4,R.color.red);
        ListView listView = (ListView)findViewById(R.id.rootphrases);
        listView.setAdapter(word);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
