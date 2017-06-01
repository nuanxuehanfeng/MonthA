package com.bawei.wangxueshi.mylibrary.pindaoguanli;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

import java.util.List;

/**
 * Created by Administrator on 2017/5/22.
 */

public class TabTitleBean {

    /**
     * message : success
     * data : {"version":"5294303690|14|1494318495","data":[{"category":"news_hot","web_url":"","flags":0,"name":"热点","tip_new":0,"default_add":1,"concern_id":"","type":4,"icon_url":""},{"category":"video","web_url":"","flags":0,"name":"视频","tip_new":0,"default_add":1,"concern_id":"","type":4,"icon_url":""},{"category":"news_local","web_url":"","flags":0,"name":"北京","tip_new":0,"default_add":1,"concern_id":"6216118333234743809","type":4,"icon_url":""},{"category":"news_society","web_url":"","flags":0,"name":"社会","tip_new":0,"default_add":1,"concern_id":"6215497899397089794","type":4,"icon_url":""},{"category":"news_entertainment","web_url":"","flags":0,"name":"娱乐","tip_new":0,"default_add":1,"concern_id":"6215497896830175745","type":4,"icon_url":""},{"category":"news_tech","web_url":"","flags":0,"name":"科技","tip_new":0,"default_add":1,"concern_id":"6215497899594222081","type":4,"icon_url":""},{"category":"组图","web_url":"","flags":0,"name":"图片","tip_new":0,"default_add":1,"concern_id":"","type":4,"icon_url":""},{"category":"news_car","web_url":"","flags":0,"name":"汽车","tip_new":0,"default_add":1,"concern_id":"6215497898671475202","type":4,"icon_url":""},{"category":"news_sports","web_url":"","flags":0,"name":"体育","tip_new":0,"default_add":1,"concern_id":"6215497726554016258","type":4,"icon_url":""},{"category":"news_finance","web_url":"","flags":0,"name":"财经","tip_new":0,"default_add":1,"concern_id":"6215497900357585410","type":4,"icon_url":""},{"category":"news_military","web_url":"","flags":0,"name":"军事","tip_new":0,"default_add":1,"concern_id":"6215497895454444033","type":4,"icon_url":""},{"category":"news_world","web_url":"","flags":0,"name":"国际","tip_new":0,"default_add":1,"concern_id":"6215497896255556098","type":4,"icon_url":""},{"category":"positive","web_url":"","flags":0,"name":"正能量","tip_new":0,"default_add":1,"concern_id":"6215497898474342913","type":4,"icon_url":""},{"category":"essay_joke","web_url":"","flags":0,"name":"段子","tip_new":0,"default_add":1,"concern_id":"","type":3,"icon_url":""},{"category":"image_funny","web_url":"","flags":0,"name":"趣图","tip_new":0,"default_add":1,"concern_id":"","type":1,"icon_url":""},{"category":"image_ppmm","web_url":"","flags":0,"name":"美女","tip_new":0,"default_add":1,"concern_id":"","type":1,"icon_url":""},{"category":"news_health","web_url":"","flags":0,"name":"健康","tip_new":0,"default_add":1,"concern_id":"6215497895248923137","type":4,"icon_url":""},{"category":"news_house","web_url":"","flags":0,"name":"房产","tip_new":0,"default_add":1,"concern_id":"6215497897127971330","type":4,"icon_url":""},{"category":"news_fashion","web_url":"","flags":0,"name":"时尚","tip_new":0,"default_add":0,"concern_id":"6215497898084272641","type":4,"icon_url":""},{"category":"news_history","web_url":"","flags":0,"name":"历史","tip_new":0,"default_add":0,"concern_id":"6215497901590710786","type":4,"icon_url":""},{"category":"news_baby","web_url":"","flags":0,"name":"育儿","tip_new":0,"default_add":0,"concern_id":"6215497900164647426","type":4,"icon_url":""},{"category":"funny","web_url":"","flags":0,"name":"搞笑","tip_new":0,"default_add":0,"concern_id":"6215497900768627201","type":4,"icon_url":""},{"category":"digital","web_url":"","flags":0,"name":"数码","tip_new":0,"default_add":0,"concern_id":"6215497897518041601","type":4,"icon_url":""},{"category":"news_food","web_url":"","flags":0,"name":"美食","tip_new":0,"default_add":0,"concern_id":"6215497899774577154","type":4,"icon_url":""},{"category":"news_regimen","web_url":"","flags":0,"name":"养生","tip_new":0,"default_add":0,"concern_id":"6215497901406161409","type":4,"icon_url":""},{"category":"movie","web_url":"","flags":0,"name":"电影","tip_new":0,"default_add":0,"concern_id":"6215497900554717698","type":4,"icon_url":""},{"category":"cellphone","web_url":"","flags":0,"name":"手机","tip_new":0,"default_add":0,"concern_id":"6213187412705675778","type":4,"icon_url":""},{"category":"news_travel","web_url":"","flags":0,"name":"旅游","tip_new":0,"default_add":0,"concern_id":"6215497897899723265","type":4,"icon_url":""},{"category":"宠物","web_url":"","flags":0,"name":"宠物","tip_new":0,"default_add":0,"concern_id":"6215847700051528193","type":4,"icon_url":""},{"category":"emotion","web_url":"","flags":0,"name":"情感","tip_new":0,"default_add":0,"concern_id":"6215845055769348610","type":4,"icon_url":""},{"category":"news_home","web_url":"","flags":0,"name":"家居","tip_new":0,"default_add":0,"concern_id":"6215497901804620289","type":4,"icon_url":""},{"category":"news_edu","web_url":"","flags":0,"name":"教育","tip_new":0,"default_add":0,"concern_id":"6215497897312520705","type":4,"icon_url":""},{"category":"news_agriculture","web_url":"","flags":0,"name":"三农","tip_new":0,"default_add":0,"concern_id":"6215847700454181377","type":4,"icon_url":""},{"category":"pregnancy","web_url":"","flags":0,"name":"孕产","tip_new":0,"default_add":0,"concern_id":"6213187415759129090","type":4,"icon_url":""},{"category":"news_culture","web_url":"","flags":0,"name":"文化","tip_new":0,"default_add":0,"concern_id":"6215497897710979586","type":4,"icon_url":""},{"category":"stock","web_url":"","flags":0,"name":"股票","tip_new":0,"default_add":0,"concern_id":"6213187421031369217","type":4,"icon_url":""},{"category":"science_all","web_url":"","flags":0,"name":"科学","tip_new":0,"default_add":0,"concern_id":"6215848044378720770","type":4,"icon_url":""},{"category":"news_comic","web_url":"","flags":0,"name":"动漫","tip_new":0,"default_add":0,"concern_id":"6215497895852902913","type":4,"icon_url":""},{"category":"news_story","web_url":"","flags":0,"name":"故事","tip_new":0,"default_add":0,"concern_id":"6215497902182107649","type":4,"icon_url":""},{"category":"news_collect","web_url":"","flags":0,"name":"收藏","tip_new":0,"default_add":0,"concern_id":"6215847700907166210","type":4,"icon_url":""},{"category":"boutique","web_url":"","flags":0,"name":"精选","tip_new":0,"default_add":0,"concern_id":"","type":4,"icon_url":""},{"category":"essay_saying","web_url":"","flags":0,"name":"语录","tip_new":0,"default_add":0,"concern_id":"","type":3,"icon_url":""},{"category":"news_astrology","web_url":"","flags":0,"name":"星座","tip_new":0,"default_add":0,"concern_id":"6215497898268822018","type":4,"icon_url":""},{"category":"image_wonderful","web_url":"","flags":0,"name":"美图","tip_new":0,"default_add":0,"concern_id":"","type":1,"icon_url":""},{"category":"government","web_url":"","flags":0,"name":"政务","tip_new":0,"default_add":0,"concern_id":"","type":4,"icon_url":""},{"category":"rumor","web_url":"","flags":0,"name":"辟谣","tip_new":0,"default_add":0,"concern_id":"","type":4,"icon_url":""},{"category":"中国新唱将","web_url":"","flags":0,"name":"中国新唱将","tip_new":0,"default_add":0,"concern_id":"6331936063229004290","type":4,"icon_url":""},{"category":"彩票","web_url":"","flags":0,"name":"彩票","tip_new":0,"default_add":0,"concern_id":"6213185685910718978","type":4,"icon_url":""}]}
     */

    private String message;
    private DataBeanX data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * version : 5294303690|14|1494318495
         * data : [{"category":"news_hot","web_url":"","flags":0,"name":"热点","tip_new":0,"default_add":1,"concern_id":"","type":4,"icon_url":""},{"category":"video","web_url":"","flags":0,"name":"视频","tip_new":0,"default_add":1,"concern_id":"","type":4,"icon_url":""},{"category":"news_local","web_url":"","flags":0,"name":"北京","tip_new":0,"default_add":1,"concern_id":"6216118333234743809","type":4,"icon_url":""},{"category":"news_society","web_url":"","flags":0,"name":"社会","tip_new":0,"default_add":1,"concern_id":"6215497899397089794","type":4,"icon_url":""},{"category":"news_entertainment","web_url":"","flags":0,"name":"娱乐","tip_new":0,"default_add":1,"concern_id":"6215497896830175745","type":4,"icon_url":""},{"category":"news_tech","web_url":"","flags":0,"name":"科技","tip_new":0,"default_add":1,"concern_id":"6215497899594222081","type":4,"icon_url":""},{"category":"组图","web_url":"","flags":0,"name":"图片","tip_new":0,"default_add":1,"concern_id":"","type":4,"icon_url":""},{"category":"news_car","web_url":"","flags":0,"name":"汽车","tip_new":0,"default_add":1,"concern_id":"6215497898671475202","type":4,"icon_url":""},{"category":"news_sports","web_url":"","flags":0,"name":"体育","tip_new":0,"default_add":1,"concern_id":"6215497726554016258","type":4,"icon_url":""},{"category":"news_finance","web_url":"","flags":0,"name":"财经","tip_new":0,"default_add":1,"concern_id":"6215497900357585410","type":4,"icon_url":""},{"category":"news_military","web_url":"","flags":0,"name":"军事","tip_new":0,"default_add":1,"concern_id":"6215497895454444033","type":4,"icon_url":""},{"category":"news_world","web_url":"","flags":0,"name":"国际","tip_new":0,"default_add":1,"concern_id":"6215497896255556098","type":4,"icon_url":""},{"category":"positive","web_url":"","flags":0,"name":"正能量","tip_new":0,"default_add":1,"concern_id":"6215497898474342913","type":4,"icon_url":""},{"category":"essay_joke","web_url":"","flags":0,"name":"段子","tip_new":0,"default_add":1,"concern_id":"","type":3,"icon_url":""},{"category":"image_funny","web_url":"","flags":0,"name":"趣图","tip_new":0,"default_add":1,"concern_id":"","type":1,"icon_url":""},{"category":"image_ppmm","web_url":"","flags":0,"name":"美女","tip_new":0,"default_add":1,"concern_id":"","type":1,"icon_url":""},{"category":"news_health","web_url":"","flags":0,"name":"健康","tip_new":0,"default_add":1,"concern_id":"6215497895248923137","type":4,"icon_url":""},{"category":"news_house","web_url":"","flags":0,"name":"房产","tip_new":0,"default_add":1,"concern_id":"6215497897127971330","type":4,"icon_url":""},{"category":"news_fashion","web_url":"","flags":0,"name":"时尚","tip_new":0,"default_add":0,"concern_id":"6215497898084272641","type":4,"icon_url":""},{"category":"news_history","web_url":"","flags":0,"name":"历史","tip_new":0,"default_add":0,"concern_id":"6215497901590710786","type":4,"icon_url":""},{"category":"news_baby","web_url":"","flags":0,"name":"育儿","tip_new":0,"default_add":0,"concern_id":"6215497900164647426","type":4,"icon_url":""},{"category":"funny","web_url":"","flags":0,"name":"搞笑","tip_new":0,"default_add":0,"concern_id":"6215497900768627201","type":4,"icon_url":""},{"category":"digital","web_url":"","flags":0,"name":"数码","tip_new":0,"default_add":0,"concern_id":"6215497897518041601","type":4,"icon_url":""},{"category":"news_food","web_url":"","flags":0,"name":"美食","tip_new":0,"default_add":0,"concern_id":"6215497899774577154","type":4,"icon_url":""},{"category":"news_regimen","web_url":"","flags":0,"name":"养生","tip_new":0,"default_add":0,"concern_id":"6215497901406161409","type":4,"icon_url":""},{"category":"movie","web_url":"","flags":0,"name":"电影","tip_new":0,"default_add":0,"concern_id":"6215497900554717698","type":4,"icon_url":""},{"category":"cellphone","web_url":"","flags":0,"name":"手机","tip_new":0,"default_add":0,"concern_id":"6213187412705675778","type":4,"icon_url":""},{"category":"news_travel","web_url":"","flags":0,"name":"旅游","tip_new":0,"default_add":0,"concern_id":"6215497897899723265","type":4,"icon_url":""},{"category":"宠物","web_url":"","flags":0,"name":"宠物","tip_new":0,"default_add":0,"concern_id":"6215847700051528193","type":4,"icon_url":""},{"category":"emotion","web_url":"","flags":0,"name":"情感","tip_new":0,"default_add":0,"concern_id":"6215845055769348610","type":4,"icon_url":""},{"category":"news_home","web_url":"","flags":0,"name":"家居","tip_new":0,"default_add":0,"concern_id":"6215497901804620289","type":4,"icon_url":""},{"category":"news_edu","web_url":"","flags":0,"name":"教育","tip_new":0,"default_add":0,"concern_id":"6215497897312520705","type":4,"icon_url":""},{"category":"news_agriculture","web_url":"","flags":0,"name":"三农","tip_new":0,"default_add":0,"concern_id":"6215847700454181377","type":4,"icon_url":""},{"category":"pregnancy","web_url":"","flags":0,"name":"孕产","tip_new":0,"default_add":0,"concern_id":"6213187415759129090","type":4,"icon_url":""},{"category":"news_culture","web_url":"","flags":0,"name":"文化","tip_new":0,"default_add":0,"concern_id":"6215497897710979586","type":4,"icon_url":""},{"category":"stock","web_url":"","flags":0,"name":"股票","tip_new":0,"default_add":0,"concern_id":"6213187421031369217","type":4,"icon_url":""},{"category":"science_all","web_url":"","flags":0,"name":"科学","tip_new":0,"default_add":0,"concern_id":"6215848044378720770","type":4,"icon_url":""},{"category":"news_comic","web_url":"","flags":0,"name":"动漫","tip_new":0,"default_add":0,"concern_id":"6215497895852902913","type":4,"icon_url":""},{"category":"news_story","web_url":"","flags":0,"name":"故事","tip_new":0,"default_add":0,"concern_id":"6215497902182107649","type":4,"icon_url":""},{"category":"news_collect","web_url":"","flags":0,"name":"收藏","tip_new":0,"default_add":0,"concern_id":"6215847700907166210","type":4,"icon_url":""},{"category":"boutique","web_url":"","flags":0,"name":"精选","tip_new":0,"default_add":0,"concern_id":"","type":4,"icon_url":""},{"category":"essay_saying","web_url":"","flags":0,"name":"语录","tip_new":0,"default_add":0,"concern_id":"","type":3,"icon_url":""},{"category":"news_astrology","web_url":"","flags":0,"name":"星座","tip_new":0,"default_add":0,"concern_id":"6215497898268822018","type":4,"icon_url":""},{"category":"image_wonderful","web_url":"","flags":0,"name":"美图","tip_new":0,"default_add":0,"concern_id":"","type":1,"icon_url":""},{"category":"government","web_url":"","flags":0,"name":"政务","tip_new":0,"default_add":0,"concern_id":"","type":4,"icon_url":""},{"category":"rumor","web_url":"","flags":0,"name":"辟谣","tip_new":0,"default_add":0,"concern_id":"","type":4,"icon_url":""},{"category":"中国新唱将","web_url":"","flags":0,"name":"中国新唱将","tip_new":0,"default_add":0,"concern_id":"6331936063229004290","type":4,"icon_url":""},{"category":"彩票","web_url":"","flags":0,"name":"彩票","tip_new":0,"default_add":0,"concern_id":"6213185685910718978","type":4,"icon_url":""}]
         */

        private String version;
        private List<DataBean> data;

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }
        //tablayout中对象的表
        @Table(name = "tabbean")
        public static class DataBean {
            public Integer getOrderId() {
                return orderId;
            }

            public void setOrderId(Integer orderId) {
                this.orderId = orderId;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            /**
             * category : news_hot
             * web_url :
             * flags : 0
             *
             * name : 热点
             * tip_new : 0
             * default_add : 1
             * concern_id :
             * type : 4
             * icon_url :
             */

            //自己在数据缆中 整体的排序
            @Column(name = "orderId")
            public Integer orderId;
            //自己数据id
            @Column(name = "id",isId = true,autoGen = true)
            private int id;
            //地址中用到的
            @Column(name = "category")
            private String category;
            private String web_url;
            private int flags;
            @Column(name = "name")
            private String name;
            private int tip_new;
            @Column(name = "default_add")
            //1 选中，0 没有选中
            private int default_add;
            private String concern_id;
            private int type;
            private String icon_url;
            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getWeb_url() {
                return web_url;
            }

            public void setWeb_url(String web_url) {
                this.web_url = web_url;
            }

            public int getFlags() {
                return flags;
            }

            public void setFlags(int flags) {
                this.flags = flags;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getTip_new() {
                return tip_new;
            }

            public void setTip_new(int tip_new) {
                this.tip_new = tip_new;
            }

            public int getDefault_add() {
                return default_add;
            }

            public void setDefault_add(int default_add) {
                this.default_add = default_add;
            }

            public String getConcern_id() {
                return concern_id;
            }

            public void setConcern_id(String concern_id) {
                this.concern_id = concern_id;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getIcon_url() {
                return icon_url;
            }

            public void setIcon_url(String icon_url) {
                this.icon_url = icon_url;
            }
        }
    }
}
