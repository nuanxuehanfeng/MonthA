package com.bawei.wangxueshi.mylibrary.pindaoguanli;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.wangxueshi.mylibrary.IApplication;
import com.bawei.wangxueshi.mylibrary.R;
import com.bawei.wangxueshi.mylibrary.pindaoguanli.adapter.HttpDragAdapter;
import com.bawei.wangxueshi.mylibrary.pindaoguanli.adapter.HttpOtherAdapter;
import com.bawei.wangxueshi.mylibrary.pindaoguanli.view.DragGrid;
import com.bawei.wangxueshi.mylibrary.pindaoguanli.view.OtherGridView;

import org.xutils.DbManager;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;


/**
 * 频道管理
 * @Author RA
 * @Blog http://blog.csdn.net/vipzjyno1
 */
public class ChannelActivity extends Activity implements OnItemClickListener {


    /** 用户栏目的GRIDVIEW */
    private DragGrid userGridView;
    /** 其它栏目的GRIDVIEW */
    private OtherGridView otherGridView;
    /** 用户栏目对应的适配器，可以拖动 */
   // DragAdapter userAdapter;
    HttpDragAdapter userAdapter;
    /** 其它栏目对应的适配器 */
   // OtherAdapter otherAdapter;
    HttpOtherAdapter otherAdapter;
    /** 其它栏目列表 */
  //  ArrayList<ChannelItem> otherChannelList = new ArrayList<ChannelItem>();
    /** 用户栏目列表 */
   // ArrayList<ChannelItem> userChannelList = new ArrayList<ChannelItem>();

    List<TabTitleBean.DataBeanX.DataBean> userChannelList=new ArrayList<>();
    List<TabTitleBean.DataBeanX.DataBean> otherChannelList=new ArrayList<>();

    /** 是否在移动，由于这边是动画结束后才进行的数据更替，设置这个限制为了避免操作太频繁造成的数据错乱。 */
    boolean isMove = false;
    private DbManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //注意布局中自定义的类的导包哦
        setContentView(R.layout.subscribe_activity);

        initView();
        initData();
        TextView tv= (TextView) findViewById(R.id.my_category_text);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("\"这是吐司\" = " + "这是吐司");
             //   userChannelList = ((ArrayList<HttpBean.DataBeanX.DataBean>) HttpBeanManage.getManage(IApplication.getApp().getSQLHelper()).getUserChannel());
                System.out.println("\"这是吐司\" = " + userChannelList.size());
            }
        });
    }

    /** 初始化数据*/
    private void initData() {
        DbManager.DaoConfig daoConfig = IApplication.getDaoConfig();

        dbManager = x.getDb(daoConfig);

        try {
            List<TabTitleBean.DataBeanX.DataBean> all = dbManager.findAll(TabTitleBean.DataBeanX.DataBean.class);
            if(null!=all){
            System.out.println("all.size() 数据库总共保存= " + all.size());
            for (TabTitleBean.DataBeanX.DataBean bean:all){
                if(bean.getDefault_add()==1){
                    userChannelList.add(bean);
                }
                else{
                    otherChannelList.add(bean);
                }
            }
            }
        } catch (DbException e) {
            e.printStackTrace();
        }

       // userAdapter = new DragAdapter(this, userChannelList);
        userAdapter = new HttpDragAdapter(this, userChannelList);
        userGridView.setAdapter(userAdapter);

    //    otherAdapter = new OtherAdapter(this, otherChannelList);
        otherAdapter = new HttpOtherAdapter(this, otherChannelList);

        otherGridView.setAdapter(this.otherAdapter);
        //设置GRIDVIEW的ITEM的点击监听
        otherGridView.setOnItemClickListener(this);
        userGridView.setOnItemClickListener(this);
    }

    /** 初始化布局*/
    private void initView() {
        userGridView = (DragGrid) findViewById(R.id.userGridView);
        otherGridView = (OtherGridView) findViewById(R.id.otherGridView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /** GRIDVIEW对应的ITEM点击监听接口  */
    @Override
    public void onItemClick(AdapterView<?> parent, final View view, final int position,long id) {
        //如果点击的时候，之前动画还没结束，那么就让点击事件无效
        if(isMove){
            return;
        }
        int i = parent.getId();
        if (i == R.id.userGridView) {//position为 0，1 的不可以进行任何操作
            if (position != 0 && position != 1) {
                final ImageView moveImageView = getView(view);
                if (moveImageView != null) {
                    TextView newTextView = (TextView) view.findViewById(R.id.text_item);
                    final int[] startLocation = new int[2];
                    newTextView.getLocationInWindow(startLocation);
                    final TabTitleBean.DataBeanX.DataBean channel = ((HttpDragAdapter) parent.getAdapter()).getItem(position);//获取点击的频道内容
                    otherAdapter.setVisible(false);
                    //添加到最后一个
                    otherAdapter.addItem(channel);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            try {
                                int[] endLocation = new int[2];
                                //获取终点的坐标
                                otherGridView.getChildAt(otherGridView.getLastVisiblePosition()).getLocationInWindow(endLocation);
                                MoveAnim(moveImageView, startLocation, endLocation, channel, userGridView);
                                userAdapter.setRemove(position);
                            } catch (Exception localException) {
                            }
                        }
                    }, 50L);
                }
            }

        } else if (i == R.id.otherGridView) {
            final ImageView moveImageView = getView(view);
            if (moveImageView != null) {
                TextView newTextView = (TextView) view.findViewById(R.id.text_item);
                final int[] startLocation = new int[2];
                newTextView.getLocationInWindow(startLocation);
                final TabTitleBean.DataBeanX.DataBean channel = ((HttpOtherAdapter) parent.getAdapter()).getItem(position);
                userAdapter.setVisible(false);
                //添加到最后一个
                userAdapter.addItem(channel);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        try {
                            int[] endLocation = new int[2];
                            //获取终点的坐标
                            userGridView.getChildAt(userGridView.getLastVisiblePosition()).getLocationInWindow(endLocation);
                            MoveAnim(moveImageView, startLocation, endLocation, channel, otherGridView);
                            otherAdapter.setRemove(position);
                        } catch (Exception localException) {
                        }
                    }
                }, 50L);
            }

        } else {
        }
    }
    /**
     * 点击ITEM移动动画
     * @param moveView
     * @param startLocation
     * @param endLocation
     * @param moveChannel
     * @param clickGridView
     */
    private void MoveAnim(View moveView, int[] startLocation,int[] endLocation, final TabTitleBean.DataBeanX.DataBean moveChannel,
                          final GridView clickGridView) {
        int[] initLocation = new int[2];
        //获取传递过来的VIEW的坐标
        moveView.getLocationInWindow(initLocation);
        //得到要移动的VIEW,并放入对应的容器中
        final ViewGroup moveViewGroup = getMoveViewGroup();
        final View mMoveView = getMoveView(moveViewGroup, moveView, initLocation);
        //创建移动动画
        TranslateAnimation moveAnimation = new TranslateAnimation(
                startLocation[0], endLocation[0], startLocation[1],
                endLocation[1]);
        moveAnimation.setDuration(300L);//动画时间
        //动画配置
        AnimationSet moveAnimationSet = new AnimationSet(true);
        moveAnimationSet.setFillAfter(false);//动画效果执行完毕后，View对象不保留在终止的位置
        moveAnimationSet.addAnimation(moveAnimation);
        mMoveView.startAnimation(moveAnimationSet);
        moveAnimationSet.setAnimationListener(new AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                isMove = true;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                moveViewGroup.removeView(mMoveView);
                // instanceof 方法判断2边实例是不是一样，判断点击的是DragGrid还是OtherGridView
                if (clickGridView instanceof DragGrid) {
                    otherAdapter.setVisible(true);
                    otherAdapter.notifyDataSetChanged();
                    userAdapter.remove();
                }else{
                    userAdapter.setVisible(true);
                    userAdapter.notifyDataSetChanged();
                    otherAdapter.remove();
                }
                isMove = false;
            }
        });
    }

    /**
     * 获取移动的VIEW，放入对应ViewGroup布局容器
     * @param viewGroup
     * @param view
     * @param initLocation
     * @return
     */
    private View getMoveView(ViewGroup viewGroup, View view, int[] initLocation) {
        int x = initLocation[0];
        int y = initLocation[1];
        viewGroup.addView(view);
        LinearLayout.LayoutParams mLayoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        mLayoutParams.leftMargin = x;
        mLayoutParams.topMargin = y;
        view.setLayoutParams(mLayoutParams);
        return view;
    }

    /**
     * 创建移动的ITEM对应的ViewGroup布局容器
     */
    private ViewGroup getMoveViewGroup() {
        ViewGroup moveViewGroup = (ViewGroup) getWindow().getDecorView();
        LinearLayout moveLinearLayout = new LinearLayout(this);
        moveLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        moveViewGroup.addView(moveLinearLayout);
        return moveLinearLayout;
    }

    /**
     * 获取点击的Item的对应View，
     * @param view
     * @return
     */
    private ImageView getView(View view) {
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(true);
        Bitmap cache = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        ImageView iv = new ImageView(this);
        iv.setImageBitmap(cache);
        return iv;
    }

    /** 退出时候保存选择后数据库的设置  */
    private void saveChannel() {
        //数据库清空
     //   HttpBeanManage.getManage(IApplication.getApp().getSQLHelper()).deleteAllChannel();
        try {
            dbManager.delete(TabTitleBean.DataBeanX.DataBean.class);
            for(TabTitleBean.DataBeanX.DataBean bean:userAdapter.getChannnelLst()){
                bean.setDefault_add(1);
                dbManager.save(bean);

            }
            for(TabTitleBean.DataBeanX.DataBean bean:otherAdapter.getChannnelLst()){
                bean.setDefault_add(0);
                dbManager.save(bean);
            }
        } catch (DbException e) {
            e.printStackTrace();
        }


    }


}
