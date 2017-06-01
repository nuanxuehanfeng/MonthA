package com.bawei.wangxueshi.montha;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bwei.springview.container.DefaultFooter;
import com.bwei.springview.container.DefaultHeader;
import com.bwei.springview.widget.SpringView;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
   List<String>  list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this,C.class));

        final ListView listView= (ListView) findViewById(R.id.main_listview);
        final File file=new File(Environment.getExternalStorageDirectory(),"a");
        if(file.exists()){}
        else{
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        final SpringView springView= (SpringView) findViewById(R.id.main_spring);
        initdata();
        final A a = new A(this, list);
        listView.setAdapter(a);
        springView.setHeader(new DefaultHeader(this));
        springView.setFooter(new DefaultFooter(this));
        springView.setType(SpringView.Type.FOLLOW);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                showDownloadProgressDialog(MainActivity.this);




            }
        });


        springView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                for(int i=0;i<10;i++){
                    list.add("刷新"+i);
                }
                a.notifyDataSetChanged();
                 springView.onFinishFreshAndLoad();
            }
            @Override
            public void onLoadmore() {

                for(int i=0;i<10;i++){
                    list.add("加载"+i);
                }
                a.notifyDataSetChanged();
                springView.onFinishFreshAndLoad();

            }
        });

    }

    private void initdata() {

        for(int i=0;i<10;i++){
            list.add("这是条目"+i);
        }

    }



    public void showDownloadProgressDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("提示");
        progressDialog.setMessage("正在下载...");
        progressDialog.setIndeterminate(false);
        progressDialog.setMax(100);
        progressDialog.setCancelable(false); //设置不可点击界面之外的区域让对话框小时
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL); //进度条类型
        progressDialog.show();
//下载的地址
        String downloadUrl = "http://imtt.dd.qq.com/16891/E4E087B63E27B87175F4B9BC7CFC4997.apk?fsname=com.tencent.qlauncher_6.0.2_64170111.apk&csr=97c2"; //这里写你的apk url地址
//asynctask类运行
        new DownloadAPK(progressDialog).execute(downloadUrl);
    }
    //定义的asynctask类
    public class DownloadAPK extends AsyncTask<String,Integer,String> {
        ProgressDialog progressDialog;
        File file;

        public DownloadAPK(ProgressDialog progressDialog) {
            this.progressDialog = progressDialog;
        }

        @Override
        protected String doInBackground(String... params) {
            URL url;
            HttpURLConnection conn;
            BufferedInputStream bis = null;
            FileOutputStream fos = null;

            try {
                url = new URL(params[0]);
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(5000);

                int fileLength = conn.getContentLength();
                bis = new BufferedInputStream(conn.getInputStream());
                String fileName = Environment.getExternalStorageDirectory().getPath() + "/magkare/action.apk";
                file = new File(fileName);
                if (!file.exists()) {
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                fos = new FileOutputStream(file);
                byte data[] = new byte[4 * 1024];
                long total = 0;
                int count;
                while ((count = bis.read(data)) != -1) {
                    total += count;
                    publishProgress((int) (total * 100 / fileLength));
                    fos.write(data, 0, count);
                    fos.flush();
                }
                fos.flush();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fos != null) {
                        fos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (bis != null) {
                        bis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            super.onProgressUpdate(progress);
// 这里 改变ProgressDialog的进度值
            progressDialog.setProgress(progress[0]);
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            openFile(file); //打开安装apk文件操作
            progressDialog.dismiss(); //关闭对话框
        }
        private void openFile(File file) {
            if (file!=null){
                Intent intent = new Intent(Intent.ACTION_VIEW);
//判断是否是AndroidN以及更高的版本
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    Uri contentUri = FileProvider.getUriForFile(MainActivity.this, BuildConfig.APPLICATION_ID + ".fileProvider", file);
                    intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
                } else {
                    intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                }
                startActivity(intent);



            }
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

}
