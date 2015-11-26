package com.qiuhn.gudu.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.qiuhn.gudu.domain.ForumReply;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table t_forum_reply.
*/
public class ForumReplyDao extends AbstractDao<ForumReply, String> {

    public static final String TABLENAME = "t_forum_reply";

    /**
     * Properties of entity ForumReply.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, String.class, "id", true, "_id");
        public final static Property Content = new Property(1, String.class, "content", false, "CONTENT");
        public final static Property Imgs = new Property(2, String.class, "imgs", false, "IMGS");
        public final static Property UserId = new Property(3, Long.class, "userId", false, "USER_ID");
        public final static Property CreateDate = new Property(4, Long.class, "createDate", false, "CREATE_DATE");
        public final static Property Index = new Property(5, Long.class, "index", false, "INDEX");
        public final static Property Status = new Property(6, Byte.class, "status", false, "STATUS");
    };


    public ForumReplyDao(DaoConfig config) {
        super(config);
    }
    
    public ForumReplyDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'t_forum_reply' (" + //
                "'_id' TEXT PRIMARY KEY NOT NULL ," + // 0: id
                "'CONTENT' TEXT," + // 1: content
                "'IMGS' TEXT," + // 2: imgs
                "'USER_ID' INTEGER," + // 3: userId
                "'CREATE_DATE' INTEGER," + // 4: createDate
                "'INDEX' INTEGER," + // 5: index
                "'STATUS' INTEGER);"); // 6: status
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'t_forum_reply'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ForumReply entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(2, content);
        }
 
        String imgs = entity.getImgs();
        if (imgs != null) {
            stmt.bindString(3, imgs);
        }
 
        Long userId = entity.getUserId();
        if (userId != null) {
            stmt.bindLong(4, userId);
        }
 
        Long createDate = entity.getCreateDate();
        if (createDate != null) {
            stmt.bindLong(5, createDate);
        }
 
        Long index = entity.getIndex();
        if (index != null) {
            stmt.bindLong(6, index);
        }
 
        Byte status = entity.getStatus();
        if (status != null) {
            stmt.bindLong(7, status);
        }
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public ForumReply readEntity(Cursor cursor, int offset) {
        ForumReply entity = new ForumReply( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // content
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // imgs
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3), // userId
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4), // createDate
            cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5), // index
            cursor.isNull(offset + 6) ? null : (byte) cursor.getShort(offset + 6) // status
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ForumReply entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setContent(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setImgs(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setUserId(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
        entity.setCreateDate(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
        entity.setIndex(cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5));
        entity.setStatus(cursor.isNull(offset + 6) ? null : (byte) cursor.getShort(offset + 6));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(ForumReply entity, long rowId) {
        return entity.getId();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(ForumReply entity) {
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