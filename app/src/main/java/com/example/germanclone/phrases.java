package com.example.germanclone;

public class phrases {
    private String peng;
    private String pger;
    private String headlines;
    public phrases(String eng, String ger, String title)
    {
        peng = eng;
        pger = ger;
        headlines = title;
    }
    public String getPeng(){
        return peng;
    }
    public String getPger(){
        return pger;
    }
    public  String getHeadlines(){
        return headlines;
    }
}
