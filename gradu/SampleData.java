package com.example.gradu;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

public class SampleData {
    private byte[] menuimg;
    private String prodName;
    private String prodPrice;
    private int grade;
    private String[] tag;


    public SampleData(byte[] menuimg, String prodName, String prodPrice, int grade, String[] tag) {
        this.menuimg = menuimg;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.grade = grade;
        this.tag=tag;
    }

    public static Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

    public Bitmap getMenuimg() {
        return getImage(this.menuimg);
    }

    public String getProdName() {
        return this.prodName;
    }

    public String getProdPrice() {
        return this.prodPrice;
    }

    public int getGrade() {
        return this.grade;
    }
    public String[] getTag(){

        return this.tag;
    }


}

