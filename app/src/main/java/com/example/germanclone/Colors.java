package com.example.germanclone;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {
private MediaPlayer mp2;
    private AudioManager ad;
    private AudioManager.OnAudioFocusChangeListener mAudioFocusChange = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mp2.pause();
                mp2.seekTo(0);
            }else if(focusChange==AudioManager.AUDIOFOCUS_GAIN)
            {
                mp2.start();
            }else if(focusChange == AudioManager.AUDIOFOCUS_LOSS){
                mp2.release();
            }
        }
    };


    @Override
    protected void onStop() {
        super.onStop();
        relesemedia();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        ad = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        final ArrayList<Words> mylist3 = new ArrayList<>(5);
        mylist3.add(new Words("Color","Farbe",R.drawable.color,R.raw.farbe));
        mylist3.add(new Words("Red","Rot",R.drawable.red,R.raw.rot));
        mylist3.add(new Words("Pink","Rosa",R.drawable.pink,R.raw.rosa));
        mylist3.add(new Words("Blue","Blau",R.drawable.bluef,R.raw.blau));
        mylist3.add(new Words("Light blue","Hell-blau",R.drawable.lightf,R.raw.hell));
        mylist3.add(new Words("Green","Grün",R.drawable.green,R.raw.grun));
        mylist3.add(new Words("Yellow","Gelb",R.drawable.yellow,R.raw.gelb));
        mylist3.add(new Words("Orange","Orange",R.drawable.orange,R.raw.orange));
        mylist3.add(new Words("Brown","Braun",R.drawable.brown,R.raw.braun));
        mylist3.add(new Words("Beige","Beige",R.drawable.beige,R.raw.beige));
        mylist3.add(new Words("Violet","Violett",R.drawable.voilet,R.raw.violett));
        mylist3.add(new Words("White","Weiß",R.drawable.white,R.raw.white));
        mylist3.add(new Words("Black","Schwarz",R.drawable.black,R.raw.black));
        mylist3.add(new Words("Gray","Grau",R.drawable.gray,R.raw.gray));
        mylist3.add(new Words("Silver","Silber",R.drawable.silver,R.raw.silver));
        mylist3.add(new Words("Gold","Gold",R.drawable.goldf,R.raw.gold));
    WordAdapter color = new WordAdapter(this,mylist3,R.color.gray);
        ListView listView = findViewById(R.id.rootcolor);
        listView.setAdapter(color);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
               Words word = mylist3.get(position);
               relesemedia();
               int result = ad.requestAudioFocus(mAudioFocusChange,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                       mp2 = mp2.create(Colors.this,word.getAudio());
               if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
               { mp2.start();
                      mp2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                          @Override
                          public void onCompletion(MediaPlayer mp) {
                              relesemedia();
                          }
                      });
           }}
       });

    }
    private void relesemedia(){
        if(mp2!= null)
        {
            mp2.release();
            mp2 = null;
            ad.abandonAudioFocus(mAudioFocusChange);
        }
    }}
