package com.example.gradu;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class cumenudo extends maintool {

    ArrayList<SampleData> menuDataList;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        this.InitializeMovieData();

        ListView listView = (ListView)findViewById(R.id.listView);
        final MyAdapter myAdapter = new MyAdapter(this,menuDataList);

        listView.setAdapter(myAdapter);


        //리스트뷰 클릭 이벤트
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id){

                Intent intent = new Intent(v.getContext(), PopupActivity.class);
                intent.putExtra("data", myAdapter.getItem(position).getProdName());
                startActivityForResult(intent, 1);

            }
        });
    }

    public void InitializeMovieData()
    {
        menuDataList = new ArrayList<SampleData>();
        database = openOrCreateDatabase("gsdb.db", MODE_PRIVATE, null);
        Cursor cursor = database.rawQuery("select _id, prodName, prodPrice, img ,grade from CU_도시락", null);
        int recordCount = cursor.getCount();

        for(int i=0; i<recordCount; i++)
        {
            cursor.moveToNext();
            int _id= cursor.getInt(0);
            String prodName = cursor.getString(1);
            String prodPrice = cursor.getString(2);
            byte[] img = cursor.getBlob(3);
            int grade = cursor.getInt(4);

            //String tag= cursor.getString(5);
            //String[] tag_split = tag.split(",");
            menuDataList.add(new SampleData(img, prodName,prodPrice,grade));
        }
        cursor.close();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                //데이터 받기
                int result = data.getIntExtra("grade", 0);
            }
        }
    }
}