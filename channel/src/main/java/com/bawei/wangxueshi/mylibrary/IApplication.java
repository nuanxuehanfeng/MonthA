package com.bawei.wangxueshi.mylibrary;

import android.app.Application;

import org.xutils.DbManager;
import org.xutils.x;


/**
 * Created by Administrator on 2017/5/10.aaASDFFFFFFFFFFASDFSDFASDFASDFASDFASDFSDFASDFSD
 */
//王学士
public class IApplication extends Application {
    private static IApplication mAppApplication;
    private  static  DbManager.DaoConfig  daoConfig;
    @Override
    public void onCreate() {
        super.onCreate();
        mAppApplication = this ;
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
   getDaoConfig();
    }
    public static DbManager.DaoConfig getDaoConfig(){
        if(daoConfig==null){
            daoConfig=new DbManager.DaoConfig()
                    .setDbVersion(1)
                    .setDbName("tt.db")//设置数据库的名字
                    .setAllowTransaction(true)
                    .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                        @Override
                        public void onUpgrade(DbManager db, int oldVersion, int newVersion) {

                        }
                    });
        }
        return daoConfig;
    }


}
