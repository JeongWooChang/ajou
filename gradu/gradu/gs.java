package com.example.gradu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class gs extends maintool implements View.OnClickListener {

    ImageView gskim, gsdo, gsham, gsgan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gs);

        gskim = findViewById(R.id.gskim);
        gsham = findViewById(R.id.gsham);
        gsdo = findViewById(R.id.gsdo);
        gsgan = findViewById(R.id.gsgan);

        gskim.setOnClickListener(this);
        gsham.setOnClickListener(this);
        gsdo.setOnClickListener(this);
        gsgan.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.gskim:
                Intent intent = new Intent(this, gsmenukim.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;

            case R.id.gsham:
                Intent intent2 = new Intent(this, gsmenuham.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;


            case R.id.gsdo:
                Intent intent3 = new Intent(this, gsmenudo.class);
                startActivity(intent3);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;

            case R.id.gsgan:
                Intent intent4 = new Intent(this, gsmenugan.class);
                startActivity(intent4);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;

            default:

                break;

        }
    }

}