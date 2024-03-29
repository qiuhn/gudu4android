package com.qiuhn.gudu.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.qiuhn.gudu.domain.ForumTopic;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table t_forum_topic.
*/
public class ForumTopicDao extends AbstractDao<ForumTopic, String> {

    public static final String TABLENAME = "t_forum_topic";

    /**
     * Properties of entity ForumTopic.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, String.class, "id", true, "_id");
        public final static Property Title = new Property(1, String.class, "title", false, "TITLE");
        public final static Property Content = new Property(2, String.class, "content", false, "CONTENT");
        public final static Property Imgs = new Property(3, String.class, "imgs", false, "IMGS");
        public final static Property SchoolId = new Property(4, Integer.class, "schoolId", false, "SCHOOL_ID");
        public final static Property LikeCount = new Property(5, Integer.class, "likeCount", false, "LIKE_COUNT");
        public final static Property ReplyCount = new Property(6, Integer.class, "replyCount", false, "REPLY_COUNT");
        public final static Property UserId = new Property(7, Long.class, "userId", false, "USER_ID");
        public final static Property CreateDate = new Property(8, Long.class, "createDate", false, "CREATE_DATE");
        public final static Property LatestUpdateTime = new Property(9, Long.class, "latestUpdateTime", false, "LATEST_UPDATE_TIME");
        public final static Property Status = new Property(10, Byte.class, "status", false, "STATUS");
        public final static Property MeLike = new Property(11, Byte.class, "meLike", false, "ME_LIKE");
    };


    public ForumTopicDao(DaoConfig config) {
        super(config);
    }
    
    public ForumTopicDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'t_forum_topic' (" + //
                "'_id' TEXT PRIMARY KEY NOT NULL ," + // 0: id
                "'TITLE' TEXT," + // 1: title
                "'CONTENT' TEXT," + // 2: content
                "'IMGS' TEXT," + // 3: imgs
                "'SCHOOL_ID' INTEGER," + // 4: schoolId
                "'LIKE_COUNT' INTEGER," + // 5: likeCount
                "'REPLY_COUNT' INTEGER," + // 6: replyCount
                "'USER_ID' INTEGER," + // 7: userId
                "'CREATE_DATE' INTEGER," + // 8: createDate
                "'LATEST_UPDATE_TIME' INTEGER," + // 9: latestUpdateTime
                "'STATUS' INTEGER," + // 10: status
                "'ME_LIKE' INTEGER);"); // 11: meLike
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'t_forum_topic'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ForumTopic entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(3, content);
        }
 
        String imgs = entity.getImgs();
        if (imgs != null) {
            stmt.bindString(4, imgs);
        }
 
        Integer schoolId = entity.getSchoolId();
        if (schoolId != null) {
            stmt.bindLong(5, schoolId);
        }
 
        Integer likeCount = entity.getLikeCount();
        if (likeCount != null) {
            stmt.bindLong(6, likeCount);
        }
 
        Integer replyCount = entity.getReplyCount();
        if (replyCount != null) {
            stmt.bindLong(7, replyCount);
        }
 
        Long userId = entity.getUserId();
        if (userId != null) {
            stmt.bindLong(8, userId);
        }
 
        Long createDate = entity.getCreateDate();
        if (createDate != null) {
            stmt.bindLong(9, createDate);
        }
 
        Long latestUpdateTime = entity.getLatestUpdateTime();
        if (latestUpdateTime != null) {
            stmt.bindLong(10, latestUpdateTime);
        }
 
        Byte status = entity.getStatus();
        if (status != null) {
            stmt.bindLong(11, status);
        }
 
        Byte meLike = entity.getMeLike();
        if (meLike != null) {
            stmt.bindLong(12, meLike);
        }
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public ForumTopic readEntity(Cursor cursor, int offset) {
        ForumTopic entity = new ForumTopic( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // title
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // content
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // imgs
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // schoolId
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // likeCount
            cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6), // replyCount
            cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7), // userId
            cursor.isNull(offset + 8) ? null : cursor.getLong(offset + 8), // createDate
            cursor.isNull(offset + 9) ? null : cursor.getLong(offset + 9), // latestUpdateTime
            cursor.isNull(offset + 10) ? null : (byte) cursor.getShort(offset + 10), // status
            cursor.isNull(offset + 11) ? null : (byte) cursor.getShort(offset + 11) // meLike
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ForumTopic entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setTitle(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setContent(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setImgs(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setSchoolId(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setLikeCount(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setReplyCount(cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6));
        entity.setUserId(cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7));
        entity.setCreateDate(cursor.isNull(offset + 8) ? null : cursor.getLong(offset + 8));
        entity.setLatestUpdateTime(cursor.isNull(offset + 9) ? null : cursor.getLong(offset + 9));
        entity.setStatus(cursor.isNull(offset + 10) ? null : (byte) cursor.getShort(offset + 10));
        entity.setMeLike(cursor.isNull(offset + 11) ? null : (byte) cursor.getShort(offset + 11));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(ForumTopic entity, long rowId) {
        return entity.getId();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(ForumTopic entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
