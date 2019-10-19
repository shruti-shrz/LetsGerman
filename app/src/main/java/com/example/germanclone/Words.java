package com.example.germanclone;

public class Words {
    private String englishtrans;
    private String germantrans;
    private int image;
    private int audio;

    public Words(String menglishtrans, String mgermantrans, int gimage,int audio1){
        englishtrans = menglishtrans;
        germantrans = mgermantrans;
        image = gimage;
        audio = audio1;
    }
    public String getEnglishtrans()
    {
        return englishtrans;
    }
    public String getGermantrans(){
        return germantrans;
    }
    public int getImage(){
        return image;
    }
    public int getAudio(){
        return audio;
    }

}
