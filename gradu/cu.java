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
        Intent intent = new Intent(this, cumenu.class);
        switch (v.getId()) {

            case R.id.cukim:
                intent.putExtra("dbq","select _id, prodName, prodPrice, img ,grade, taste, tag from CU_김밥");
                intent.putExtra("tbn","CU_김밥");
                break;

            case R.id.cuham:
                intent.putExtra("dbq","select _id, prodName, prodPrice, img ,grade, taste, tag from CU_햄버거");
                intent.putExtra("tbn","CU_햄버거");
                break;


            case R.id.cudo:
                intent.putExtra("dbq","select _id, prodName, prodPrice, img ,grade, taste, tag from CU_도시락");
                intent.putExtra("tbn","CU_도시락");
                break;

            default:

                break;

        }
        startActivity(intent);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

    }

}