package com.bawei.wangxueshi.mylibrary;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.bawei.wangxueshi.mylibrary.pindaoguanli.ChannelActivity;
import com.bawei.wangxueshi.mylibrary.pindaoguanli.TabTitleBean;
import com.google.gson.Gson;

import org.xutils.DbManager;
import org.xutils.common.Callback;
import org.xutils.ex.DbException;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;


public class MainChannelActivity extends Activity {

    private DbManager dbManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        DbManager.DaoConfig daoConfig = IApplication.getDaoConfig();

        dbManager = x.getDb(daoConfig);
        SharedPreferences isone = getSharedPreferences("isone", MODE_PRIVATE);
        boolean isone1 = isone.getBoolean("isone", true);
        SharedPreferences.Editor edit = isone.edit();
        //判断是否 时第一次添加
        if(isone1){
        getTab();
            edit.putBoolean("isone",false).commit();
        }

        startActivity(new Intent(MainChannelActivity.this, ChannelActivity.class));
              finish();

    }
    public void getTab(){
        String pathTitle="http://ic.snssdk.com/article/category/get/v2/?iid=2939228904";
        RequestParams entity=new RequestParams(pathTitle);
        entity.setConnectTimeout(5000);
        entity.setReadTimeout(5000);
        x.http().get(entity,new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                TabTitleBean tabTitle = gson.fromJson(result, TabTitleBean.class);
                List<TabTitleBean.DataBeanX.DataBean> yuanData = tabTitle.getData().getData();
                //1  的顺序
                int k=0;
                //0 的顺序
                int j=0;
                for(int i=0;i<yuanData.size();i++){
                    if(yuanData.get(i).getDefault_add()==1){
                        k++;
                        yuanData.get(i).setOrderId(k);
                    }
                    else{
                        j++;
                        yuanData.get(i).setOrderId(j);
                    }
                }
                try {
                    //设置完成后 添加数据库
                    dbManager.save(yuanData);
                } catch (DbException e) {
                    e.printStackTrace();
                }
                //这里注意  一定是网络请求完  在去调转 ，不然网络请求需要时间，可以能还没有得到数据就调转了，有可能不出现数据
                startActivity(new Intent(MainChannelActivity.this, ChannelActivity.class));
                finish();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
            }

            @Override
            public void onCancelled(CancelledException cex) {
            }

            @Override
            public void onFinished() {
            }
        });




    }


}
