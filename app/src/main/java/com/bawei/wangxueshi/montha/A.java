package com.bawei.wangxueshi.montha;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */

public class A extends BaseAdapter {
    Context context;
    List<String> list;

    public A(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=View.inflate(context,R.layout.adapter,null);
        }
        TextView tv= (TextView) convertView.findViewById(R.id.tv);
        tv.setText(list.get(position));

        return convertView;
    }
}
