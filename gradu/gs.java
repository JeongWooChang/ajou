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
        Intent intent = new Intent(this, gsmenu.class);
        switch (v.getId()) {

            case R.id.gskim:
                intent.putExtra("dbq","select _id, prodName, prodPrice, img ,grade, taste, tag from GS_김밥");
                intent.putExtra("tbn","GS_김밥");
                break;

            case R.id.gsham:
                intent.putExtra("dbq","select _id, prodName, prodPrice, img ,grade, taste, tag from GS_샌드위치햄벅");
                intent.putExtra("tbn","GS_샌드위치햄벅");
                break;


            case R.id.gsdo:
                intent.putExtra("dbq","select _id, prodName, prodPrice, img ,grade, taste, tag from GS_도시락");
                intent.putExtra("tbn","GS_도시락");
                break;

            case R.id.gsgan:
                intent.putExtra("dbq","select _id, prodName, prodPrice, img ,grade, taste, tag from GS_간편식");
                intent.putExtra("tbn","GS_간편식");
                break;

            default:

                break;

        }
        startActivity(intent);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

    }

}