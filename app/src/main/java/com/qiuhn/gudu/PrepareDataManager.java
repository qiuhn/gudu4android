package com.qiuhn.gudu;

import android.content.Context;

import com.qiuhn.gudu.common.db.DbConstants;
import com.qiuhn.gudu.common.GuduApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 预装数据管理
 * @author qiuhn
 *
 */
public class PrepareDataManager {

	/**
	 * 准备学校相关数据
	 * @param app
	 */
	public static void createSchoolDb(GuduApplication app){
		if (app.getSQLiteDatabase(DbConstants.DB_NAME_SCHOOL) == null) {
            try {
                InputStream is = app.getResources().getAssets()
                        .open("region" + File.separator + DbConstants.DB_NAME_SCHOOL);
                copyDb(is, DbConstants.DB_NAME_SCHOOL, app);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
	/**
	 * copy数据库
	 * @param is
	 * @param dbStr
	 * @param context
	 * @throws IOException
	 */
	public static void copyDb(InputStream is, String dbStr, Context context) throws IOException {
        File db = context.getDatabasePath(dbStr);
        if (!db.exists()) {
            db.createNewFile();
            // fileChannelCopy(source, db);
            FileOutputStream fos = new FileOutputStream(db);
            byte[] buffer = new byte[1024];
            int byteCount = 0;
            while ((byteCount = is.read(buffer)) != -1) {// 循环从输入流读取 buffer字节
                fos.write(buffer, 0, byteCount);// 将读取的输入流写入到输出流
            }
            fos.flush();// 刷新缓冲区
            is.close();
            fos.close();
        }
    }
	
}
