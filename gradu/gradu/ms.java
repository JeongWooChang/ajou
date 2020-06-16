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
        switch (v.getId()) {

            case R.id.mskim:
                Intent intent = new Intent(this, msmenukim.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;

            case R.id.msham:
                Intent intent2 = new Intent(this, msmenuham.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;


            case R.id.msdo:
                Intent intent3 = new Intent(this, msmenudo.class);
                startActivity(intent3);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;

            case R.id.mssan:
                Intent intent4 = new Intent(this, msmenusan.class);
                startActivity(intent4);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;

            case R.id.mspun:
                Intent intent5 = new Intent(this, msmenupun.class);
                startActivity(intent5);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;

            default:

                break;

        }
    }

}