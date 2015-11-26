package com.qiuhn.gudu.db;

import com.qiuhn.gudu.common.GuduApplication;
import com.qiuhn.gudu.dao.ForumTopicDao;

public  class BaseDaoHelper {


    protected static ForumTopicDao getForumTopicDao(){
        return GuduApplication.getInstance().getDaoSession().getForumTopicDao();
    }


}
