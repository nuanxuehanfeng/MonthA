package com.bawei.wangxueshi.mylibrary.pindaoguanli.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bawei.wangxueshi.mylibrary.R;
import com.bawei.wangxueshi.mylibrary.pindaoguanli.TabTitleBean;

import java.util.List;

//import com.bawei.lvwenjing.daynews.R;
//import com.bawei.lvwenjing.daynews.newsdrag.bean.HttpBean;

public class HttpOtherAdapter extends BaseAdapter {
    private Context context;
    public List<TabTitleBean.DataBeanX.DataBean> channelList;
    private TextView item_text;
    /** 是否可见 */
    boolean isVisible = true;
    /** 要删除的position */
    public int remove_position = -1;

    //List<HttpBean.DataBeanX.DataBean> channelList;
    public HttpOtherAdapter(Context context, List<TabTitleBean.DataBeanX.DataBean> channelList) {
        this.context = context;
        this.channelList = channelList;
    }

    @Override
    public int getCount() {
        return channelList == null ? 0 : channelList.size();
    }

    @Override
    public TabTitleBean.DataBeanX.DataBean getItem(int position) {
        if (channelList != null && channelList.size() != 0) {
            return channelList.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.subscribe_category_item, null);
        item_text = (TextView) view.findViewById(R.id.text_item);
        TabTitleBean.DataBeanX.DataBean channel = getItem(position);
        item_text.setText(channel.getName());
        if (!isVisible && (position == -1 + channelList.size())){
            item_text.setText("");
        }
        if(remove_position == position){
            item_text.setText("");
        }
        return view;
    }

    /** 获取频道列表 */
    public List<TabTitleBean.DataBeanX.DataBean> getChannnelLst() {
        return channelList;
    }

    /** 添加频道列表 */
    public void addItem(TabTitleBean.DataBeanX.DataBean channel) {
        channelList.add(channel);
        notifyDataSetChanged();
    }

    /** 设置删除的position */
    public void setRemove(int position) {
        remove_position = position;
        notifyDataSetChanged();
        // notifyDataSetChanged();
    }

    /** 删除频道列表 */
    public void remove() {
        channelList.remove(remove_position);
        remove_position = -1;
        notifyDataSetChanged();
    }
    /** 设置频道列表 */
    public void setListDate(List<TabTitleBean.DataBeanX.DataBean> list) {
        channelList = list;
    }

    /** 获取是否可见 */
    public boolean isVisible() {
        return isVisible;
    }

    /** 设置是否可见 */
    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}