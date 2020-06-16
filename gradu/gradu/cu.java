package com.example.gradu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class cu extends maintool implements View.OnClickListener {

    ImageView cukim, cudo, cuham;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cu);

        cukim = findViewById(R.id.cukim);
        cuham = findViewById(R.id.cuham);
        cudo = findViewById(R.id.cudo);

        cukim.setOnClickListener(this);
        cuham.setOnClickListener(this);
        cudo.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.cukim:
                Intent intent = new Intent(this, cumenukim.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;

            case R.id.cuham:
                Intent intent2 = new Intent(this, cumenuham.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;


            case R.id.cudo:
                Intent intent3 = new Intent(this, cumenudo.class);
                startActivity(intent3);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;

            default:

                break;

        }
    }

}