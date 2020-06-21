package com.example.gradu;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class TasteData {

    private String 맛이름;
    private int 점수합;
    private  int 평가개수;
    private int 평균점수;


    public TasteData(String 맛이름, int 점수합, int 평가개수){

        this.맛이름 = 맛이름;
        this.점수합 = 점수합;
        this.평가개수=평가개수;
    }


    public String getTasteName()
    {
        return this.맛이름;
    }

    public int getAddGrade()
    {
        return this.점수합;
    }

    public int getCountGrade(){
        return  this.평가개수;
    }

    public int getAverage(){
        if(평가개수>=1){
            평균점수 = 점수합/평가개수;
            return 평균점수;
        }
        else
            return 0;
    }


}