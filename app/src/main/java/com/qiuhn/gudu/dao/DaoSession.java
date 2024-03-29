package com.qiuhn.gudu.dao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.qiuhn.gudu.domain.School;
import com.qiuhn.gudu.domain.Department;
import com.qiuhn.gudu.domain.SchoolAlias;
import com.qiuhn.gudu.domain.ForumTopic;
import com.qiuhn.gudu.domain.ForumReply;

import com.qiuhn.gudu.dao.SchoolDao;
import com.qiuhn.gudu.dao.DepartmentDao;
import com.qiuhn.gudu.dao.SchoolAliasDao;
import com.qiuhn.gudu.dao.ForumTopicDao;
import com.qiuhn.gudu.dao.ForumReplyDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig schoolDaoConfig;
    private final DaoConfig departmentDaoConfig;
    private final DaoConfig schoolAliasDaoConfig;
    private final DaoConfig forumTopicDaoConfig;
    private final DaoConfig forumReplyDaoConfig;

    private final SchoolDao schoolDao;
    private final DepartmentDao departmentDao;
    private final SchoolAliasDao schoolAliasDao;
    private final ForumTopicDao forumTopicDao;
    private final ForumReplyDao forumReplyDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        schoolDaoConfig = daoConfigMap.get(SchoolDao.class).clone();
        schoolDaoConfig.initIdentityScope(type);

        departmentDaoConfig = daoConfigMap.get(DepartmentDao.class).clone();
        departmentDaoConfig.initIdentityScope(type);

        schoolAliasDaoConfig = daoConfigMap.get(SchoolAliasDao.class).clone();
        schoolAliasDaoConfig.initIdentityScope(type);

        forumTopicDaoConfig = daoConfigMap.get(ForumTopicDao.class).clone();
        forumTopicDaoConfig.initIdentityScope(type);

        forumReplyDaoConfig = daoConfigMap.get(ForumReplyDao.class).clone();
        forumReplyDaoConfig.initIdentityScope(type);

        schoolDao = new SchoolDao(schoolDaoConfig, this);
        departmentDao = new DepartmentDao(departmentDaoConfig, this);
        schoolAliasDao = new SchoolAliasDao(schoolAliasDaoConfig, this);
        forumTopicDao = new ForumTopicDao(forumTopicDaoConfig, this);
        forumReplyDao = new ForumReplyDao(forumReplyDaoConfig, this);

        registerDao(School.class, schoolDao);
        registerDao(Department.class, departmentDao);
        registerDao(SchoolAlias.class, schoolAliasDao);
        registerDao(ForumTopic.class, forumTopicDao);
        registerDao(ForumReply.class, forumReplyDao);
    }
    
    public void clear() {
        schoolDaoConfig.getIdentityScope().clear();
        departmentDaoConfig.getIdentityScope().clear();
        schoolAliasDaoConfig.getIdentityScope().clear();
        forumTopicDaoConfig.getIdentityScope().clear();
        forumReplyDaoConfig.getIdentityScope().clear();
    }

    public SchoolDao getSchoolDao() {
        return schoolDao;
    }

    public DepartmentDao getDepartmentDao() {
        return departmentDao;
    }

    public SchoolAliasDao getSchoolAliasDao() {
        return schoolAliasDao;
    }

    public ForumTopicDao getForumTopicDao() {
        return forumTopicDao;
    }

    public ForumReplyDao getForumReplyDao() {
        return forumReplyDao;
    }

}
