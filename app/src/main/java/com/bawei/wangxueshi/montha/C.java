package com.bawei.wangxueshi.montha;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class C extends Activity {

    private List<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        Banner banner= (Banner) findViewById(R.id.c_banner);
        init();
        //设置图片加载器
        banner.setImageLoader(new GlideimageLoader());
        //设置图片资源
        banner.setImages(list);
        //开启 开启前设置所有方法
        banner.start();





    }

    private void init() {

        list = new ArrayList<>();
        list.add(R.drawable.a);
        list.add(R.drawable.b);
        list.add(R.drawable.c);
        list.add(R.drawable.d);
    }

    class GlideimageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }
}
