package com.example.germanclone;

public class family {
    private String fenglish;
    private String fgerman;
    public family(String english, String german)
    {
        fenglish = english;
        fgerman = german;
    }
    public String getenglish(){
        return fenglish;
    }
    public String getgerman(){
        return fgerman;
    }
}
