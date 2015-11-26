package com.qiuhn.gudu.common;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.qiuhn.gudu.common.db.DbConstants;
import com.qiuhn.gudu.dao.DaoMaster;
import com.qiuhn.gudu.dao.DaoSession;

import java.io.File;

public class GuduApplication extends Application {

	private static DaoMaster daoMaster;
    private static DaoSession daoSession;
    private static GuduApplication mInstance;
    public static String SP_REGISTER_SETTING="";
   
    
    @Override
    public void onCreate() {
    	super.onCreate();
    	if(mInstance == null){
    		mInstance = this;
    	}
    }
 
    /**
     * 取得DaoMaster
     *
     * @return
     */
    public  DaoMaster getDaoMaster() {
        if (daoMaster == null) {
            DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(this, DbConstants.DB_NAME, null);
            daoMaster = new DaoMaster(helper.getWritableDatabase());
        }
        return daoMaster;
    }

    /**
     * 取得DaoSession
     *
     * @return
     */
    public  DaoSession getDaoSession() {
        if (daoSession == null) {
            if (daoMaster == null) {
                daoMaster = getDaoMaster();
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }

    // 判断数据库是否存在
    public  SQLiteDatabase getSQLiteDatabase(String dbName) {
        File db = this.getDatabasePath(dbName);
        if (!db.exists()) {
            return null;
        } else {
            return SQLiteDatabase.openOrCreateDatabase(db, null);
        }
    }
    public static GuduApplication getInstance(){
    	return mInstance;
    }
	
}
