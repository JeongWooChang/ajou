package com.example.gradu;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class cumenu extends maintool {

    ArrayList<SampleData> menuDataList;
    ArrayList<SampleData> menuDataList2;
    ArrayList<TasteData> tasteDataList;
    DBHelper helper;
    SQLiteDatabase database;
    SQLiteDatabase database2;
    Button starorder;
    Button recoorder;
    int a=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        onResume();
    }

    @Override
    public void onResume() {
        super.onResume();

        this.tasteStart();
        this.InitializeData();
        this.InitializeData2();

        final ListView listView = (ListView)findViewById(R.id.listView);
        final MyAdapter myAdapter = new MyAdapter(this,menuDataList);
        final MyAdapter myAdapter2 = new MyAdapter(this,menuDataList2);

        if(a==0){
            listView.setAdapter(myAdapter);
        }
        else{
            listView.setAdapter(myAdapter2);
        }
        starorder=findViewById(R.id.starorder);
        starorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.setAdapter(myAdapter);
                a=0;
            }

        });

        recoorder=findViewById(R.id.recoorder);
        recoorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.setAdapter(myAdapter2);
                a=1;
            }
        });
        //리스트뷰 클릭 이벤트
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id){

                Intent intent = new Intent(v.getContext(), PopupActivity.class);
                if(a==0){
                    intent.putExtra("data", myAdapter.getItem(position).getProdName());
                    intent.putExtra("data2", myAdapter.getItem(position).getTag());


                }
                else{
                    intent.putExtra("data", myAdapter2.getItem(position).getProdName());
                    intent.putExtra("data2", myAdapter2.getItem(position).getTag());

                }
                startActivityForResult(intent, 1);
                Toast.makeText(getApplicationContext(),myAdapter.getItem(position).getProdName(),Toast.LENGTH_LONG);

            }

        });


    }

    public void InitializeData ()
    {
        menuDataList = new ArrayList<SampleData>();
        helper = new DBHelper(this, "gsdb.db", null, 3);
        database = helper.getWritableDatabase();
        Intent intent = getIntent();
        String k = intent.getStringExtra("dbq");
        Cursor cursor = database.rawQuery(k+" order by grade DESC", null);
        int recordCount = cursor.getCount();

        for (int i = 0; i < recordCount; i++) {
            cursor.moveToNext();
            int _id= cursor.getInt(0);
            String prodName = cursor.getString(1);
            String prodPrice = cursor.getString(2);
            byte[] img = cursor.getBlob(3);
            int grade = cursor.getInt(4);
            int taste = cursor.getInt(5);
            String tag= cursor.getString(6);
            String[] tag_split= tag.split(", ");

            Intent intent2 = getIntent();
            String z = intent2.getStringExtra("tbn");
            ContentValues values = new ContentValues();
            int q=0;
            for(int p=0; p<2;p++){
                for(int j=0; j<6;j++){
                    if(tasteDataList.get(j).getTasteName().equals(tag_split[p])){
                        q+=tasteDataList.get(j).getAverage();
                    }
                }
            }
            taste=q/2;

            values.put("taste", taste);

            database.update(z,
                    values,    // 뭐라고 변경할지 ContentValues 설정
                    "prodName=?", // 바꿀 항목을 찾을 조건절
                    new String[]{prodName});// 바꿀 항

            menuDataList.add(new SampleData(img, prodName,prodPrice,grade,tag_split));
        }
        cursor.close();

    }

    public void InitializeData2()
    {
        menuDataList2 = new ArrayList<SampleData>();
        helper = new DBHelper(this,"gsdb.db",null,3);
        database = helper.getWritableDatabase();

        Intent intent = getIntent();
        String k = intent.getStringExtra("dbq");
        Cursor cursor = database.rawQuery(k+" where grade=0 order by taste DESC ", null);
        int recordCount = cursor.getCount();

        for(int i=0; i<recordCount; i++)
        {
            cursor.moveToNext();
            int _id= cursor.getInt(0);
            String prodName = cursor.getString(1);
            String prodPrice = cursor.getString(2);
            byte[] img = cursor.getBlob(3);
            int grade = cursor.getInt(4);
            int taste = cursor.getInt(5);
            String tag= cursor.getString(6);
            String[] tag_split= tag.split(", ");

            Intent intent2 = getIntent();
            String z = intent2.getStringExtra("tbn");
            ContentValues values = new ContentValues();
            int q=0;
            for(int p=0; p<2;p++){
                for(int j=0; j<6;j++){
                    if(tasteDataList.get(j).getTasteName().equals(tag_split[p])){
                        q+=tasteDataList.get(j).getAverage();
                    }
                }
            }

            taste=q/2;

            values.put("taste", taste);
            database.update(z,
                    values,    // 뭐라고 변경할지 ContentValues 설정
                    "prodName=?", // 바꿀 항목을 찾을 조건절
                    new String[]{prodName});// 바꿀 항

            menuDataList2.add(new SampleData(img, prodName,prodPrice,grade,tag_split));
        }
        cursor.close();

    }

    public void tasteStart(){
        tasteDataList = new ArrayList<TasteData>();
        helper = new DBHelper(this, "gsdb.db", null, 3);
        database2 = helper.getWritableDatabase();
        Cursor cursor = database2.rawQuery("select 맛이름, 점수합, 평가개수 from 맛_db ", null);
        int recordCount = cursor.getCount();

        for (int i = 0; i < recordCount; i++) {
            cursor.moveToNext();
            String 맛이름 = cursor.getString(0);
            int 점수합 = cursor.getInt(1);
            int 평가개수 = cursor.getInt(2);

            tasteDataList.add(new TasteData(맛이름, 점수합, 평가개수));
        }
        cursor.close();

    }

    public void tasteUpdate(String[] tag, int grade)
    {

        for(int i=0; i<2;i++){
            for(int j=0; j<6;j++){
                if(tasteDataList.get(j).getTasteName().equals(tag[i])==true){
                    ContentValues values = new ContentValues();
                    values.put("점수합", grade+tasteDataList.get(j).getAddGrade());
                    values.put("평가개수",tasteDataList.get(j).getCountGrade()+1);
                    values.put("평균점수",(grade+tasteDataList.get(j).getAddGrade())/(tasteDataList.get(j).getCountGrade()+1));
                    database2.update("맛_db",
                            values,    // 뭐라고 변경할지 ContentValues 설정
                            "맛이름=?", // 바꿀 항목을 찾을 조건절
                            new String[]{tag[i]});// 바꿀 항목으로 찾을 값 String 배열
                }
            }
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                //데이터 받기
                int result = data.getIntExtra("grade", 0);
                String prodName = data.getStringExtra("prodName");
                String[] tag = data.getStringArrayExtra("tag");
                tasteUpdate(tag, result);
                dbUpdate(prodName,result);
            }
        }
    }

    public void dbUpdate(String prodName, int grade) {
        Intent intent = getIntent();
        String k = intent.getStringExtra("tbn");
        ContentValues values = new ContentValues();
        values.put("grade", grade);
        database.update(k,
                values,    // 뭐라고 변경할지 ContentValues 설정
                "prodName=?", // 바꿀 항목을 찾을 조건절
                new String[]{prodName});// 바꿀 항목으로 찾을 값 String 배열
    }

}
