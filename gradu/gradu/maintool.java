package com.example.gradu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

public class maintool extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintool);
    }


    @Override
    public void setContentView(int layoutResID){
        LinearLayout fullView = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_maintool, null);
        FrameLayout activityContainer = (FrameLayout) fullView.findViewById(R.id.activity_content);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);
        super.setContentView(fullView);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        //툴바 사용여부 결정(기본적으로 사용)
        if(useToolbar()){
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.logo2);

            setTitle("");

        } else {

            toolbar.setVisibility(View.GONE);
        }

    }

    //툴바를 사용할지 말지 정함
    protected boolean useToolbar(){
        return true;
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }




    //앱바 메뉴 클릭 이벤트
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                Intent intent2 = new Intent(this, MainActivity.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                return true;

            case R.id.customer:
                Intent intent = new Intent(this, customer.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }

}
