package com.example.gradu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static java.sql.Types.NULL;

public class MyAdapter extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<SampleData> sample;

    public MyAdapter(Context context, ArrayList<SampleData> data) {
        mContext = context;
        sample = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return sample.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public SampleData getItem(int position) {
        return sample.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.listview, null);

        ImageView imageView = (ImageView)view.findViewById(R.id.menuimg);
        TextView prodName = (TextView)view.findViewById(R.id.prodname);
        TextView prodPrice = (TextView)view.findViewById(R.id.prodprice);
        ImageView imageView2 = (ImageView)view.findViewById(R.id.grade);


        imageView.setImageBitmap(sample.get(position).getMenuimg());
        prodName.setText(sample.get(position).getProdName());
        prodPrice.setText(sample.get(position).getProdPrice());
        if(sample.get(position).getGrade()==1)
        {
            imageView2.setImageResource(R.drawable.grade1);
        }
        else if(sample.get(position).getGrade()==2)
        {
            imageView2.setImageResource(R.drawable.grade2);
        }
        else if(sample.get(position).getGrade()==3)
        {
            imageView2.setImageResource(R.drawable.grade3);
        }
        else
        {}

        return view;
    }
}