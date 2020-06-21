package com.example.gradu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ms extends maintool implements View.OnClickListener {

    ImageView mskim, msdo, msham, mssan, mspun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ms);

        mskim = findViewById(R.id.mskim);
        msham = findViewById(R.id.msham);
        msdo = findViewById(R.id.msdo);
        mssan = findViewById(R.id.mssan);
        mspun = findViewById(R.id.mspun);

        mskim.setOnClickListener(this);
        msham.setOnClickListener(this);
        msdo.setOnClickListener(this);
        mssan.setOnClickListener(this);
        mspun.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, msmenu.class);
        switch (v.getId()) {

            case R.id.mskim:
                intent.putExtra("dbq", "select _id, prodName, prodPrice, img ,grade, taste, tag from Mini_김밥");
                intent.putExtra("tbn","Mini_김밥");
                break;

            case R.id.msham:
                intent.putExtra("dbq", "select _id, prodName, prodPrice, img ,grade, taste, tag from Mini_햄버거");
                intent.putExtra("tbn","Mini_햄버거");
                break;


            case R.id.msdo:
                intent.putExtra("dbq", "select _id, prodName, prodPrice, img ,grade, taste, tag from Mini_도시락");
                intent.putExtra("tbn","Mini_도시락");
                break;

            case R.id.mssan:
                intent.putExtra("dbq", "select _id, prodName, prodPrice, img ,grade, taste, tag from Mini_샌드위치");
                intent.putExtra("tbn","Mini_샌드위치");
                break;

            case R.id.mspun:
                intent.putExtra("dbq", "select _id, prodName, prodPrice, img ,grade, taste, tag from Mini_삼각김밥");
                intent.putExtra("tbn","Mini_삼각김밥");
                break;

            default:

                break;

        }
        startActivity(intent);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}