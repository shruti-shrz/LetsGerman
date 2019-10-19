package com.example.germanclone;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {
   private MediaPlayer mp ;
   private AudioManager ad1;
   private AudioManager.OnAudioFocusChangeListener mAudioFocusChange = new AudioManager.OnAudioFocusChangeListener() {
       @Override
       public void onAudioFocusChange(int focusChange) {
           if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
          mp.pause();
          mp.seekTo(0);
           }else if(focusChange==AudioManager.AUDIOFOCUS_GAIN)
           {
               mp.start();
           }else if(focusChange == AudioManager.AUDIOFOCUS_LOSS){
               mp.release();
           }
       }
   };

    @Override
    protected void onStop() {
        super.onStop();
        mediaplayerrelease();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        ad1 =(AudioManager) getSystemService(Context.AUDIO_SERVICE);
        final ArrayList<Words> mylist = new ArrayList<>(10);
       mylist.add(new Words("Zero","Null", R.drawable.zero,R.raw.zero));
        mylist.add(new Words("One","Eins",R.drawable.one,R.raw.eins));
        mylist.add(new Words("Two","zwei",R.drawable.two,R.raw.zwei));
        mylist.add(new Words("Three","drei",R.drawable.three,R.raw.deei));
        mylist.add(new Words("Four","vier",R.drawable.fourf,R.raw.vier));
        mylist.add(new Words("Five","fünf",R.drawable.five,R.raw.funf));
        mylist.add(new Words("six","sechs",R.drawable.six,R.raw.sechs));
        mylist.add(new Words("Seven","sieben",R.drawable.seven,R.raw.seben));
        mylist.add(new Words("Eight","acht",R.drawable.eight,R.raw.acht));
        mylist.add(new Words("nine","neun",R.drawable.nine,R.raw.neun));
        mylist.add(new Words("Ten","zehn",R.drawable.ten,R.raw.zehn));
        mylist.add(new Words("Eleven","elf",R.drawable.eleven,R.raw.elf));
        mylist.add(new Words("Twelve","zwölf",R.drawable.twelve,R.raw.zwolf));
        mylist.add(new Words("thirteen","dreizehn",R.drawable.thirteenf,R.raw.dreizehn));
        mylist.add(new Words("Fourteen","vierzehn",R.drawable.fourteen,R.raw.vierzehn));
        mylist.add(new Words("Fifteen","fünfzehn",R.drawable.fifteen,R.raw.funfzehn));
        mylist.add(new Words("Sixteen","sechzehn",R.drawable.sixteenf,R.raw.sechszehn));
        mylist.add(new Words("Seventeen","siebzehn",R.drawable.seventeen,R.raw.sebezehn));
        mylist.add(new Words("eighteen","achtzehn",R.drawable.eighteen,R.raw.achtzehn));
        mylist.add(new Words("nineteen","neunzehn",R.drawable.nineteen,R.raw.neunzehn));
        mylist.add(new Words("twenty","zwanzig",R.drawable.twenty,R.raw.zwanzig));


        WordAdapter words = new WordAdapter(this,mylist,R.color.colorblue);
        ListView listView = findViewById(R.id.rootview);
        listView.setAdapter(words);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
               Words word = mylist.get(position);
                mediaplayerrelease();
                int result = ad1.requestAudioFocus(mAudioFocusChange,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
               mp = mp.create(Numbers.this,word.getAudio());
               if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
               { mp.start();
               mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                   @Override
                   public void onCompletion(MediaPlayer mp) {
                       mediaplayerrelease();
                   }
               });
               }
            }
        });
    }
    private  void mediaplayerrelease(){
        if(mp!=null)
        {
            mp.release();
            mp = null;
            ad1.abandonAudioFocus(mAudioFocusChange);
        }
    }

}
