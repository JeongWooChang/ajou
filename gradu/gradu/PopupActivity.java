package com.example.gradu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class PopupActivity extends Activity implements View.OnClickListener{

    TextView menuname;
    ImageView gr1,gr2,gr3;
    int k= 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_popup);

        //데이터 가져오기
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        menuname=findViewById(R.id.menuname);
        menuname.setText(data);

        gr1=findViewById(R.id.gr1);
        gr2=findViewById(R.id.gr2);
        gr3=findViewById(R.id.gr3);

        gr1.setOnClickListener(this);
        gr2.setOnClickListener(this);
        gr3.setOnClickListener(this);

    }

    //확인 버튼 클릭
    public void mOnClose(View v){
        //데이터 전달하기

        Intent intent = new Intent();
        intent.putExtra("grade", k);
        setResult(RESULT_OK, intent);

        //액티비티(팝업) 닫기
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if(event.getAction()== MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.gr1:
                gr1.setImageResource(R.drawable.lightstar);
                gr2.setImageResource(R.drawable.blackstar);
                gr3.setImageResource(R.drawable.blackstar);
                k=1;
                break;

            case R.id.gr2:
                gr1.setImageResource(R.drawable.lightstar);
                gr2.setImageResource(R.drawable.lightstar);
                gr3.setImageResource(R.drawable.blackstar);
                k=2;
                break;


            case R.id.gr3:
                gr1.setImageResource(R.drawable.lightstar);
                gr2.setImageResource(R.drawable.lightstar);
                gr3.setImageResource(R.drawable.lightstar);
                k=3;
                break;

            default:

                break;

        }
    }
}


