package com.example.gradu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class AfterActivity1 extends maintool implements View.OnClickListener{

    ImageView cubtn;
    ImageView gsbtn;
    ImageView msbtn;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afterlogin1);

        cubtn=findViewById(R.id.cubtn);
        gsbtn=findViewById(R.id.gsbtn);
        msbtn=findViewById(R.id.msbtn);
        imageView=findViewById(R.id.imageView);

        cubtn.setOnClickListener(this);
        gsbtn.setOnClickListener(this);
        msbtn.setOnClickListener(this);
        imageView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.cubtn:
                Intent intent = new Intent(this, cu.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;

            case R.id.gsbtn:
                Intent intent2 = new Intent(this,gs.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;


            case R.id.msbtn:
                Intent intent3 = new Intent(this, ms.class);
                startActivity(intent3);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                break;

            case R.id.imageView:
                imageView.setVisibility(View.GONE);
                break;

            default:

                break;

        }
    }


}