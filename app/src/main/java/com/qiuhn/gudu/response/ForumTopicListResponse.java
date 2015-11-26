package com.qiuhn.gudu.response;


import com.qiuhn.gudu.pojo.ForumTopicPojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by qiuhn on 2015/11/25.
 */
public class ForumTopicListResponse implements Serializable{

    private int code;

    private List<ForumTopicPojo> obj;

    public ForumTopicListResponse() {
    }

    public ForumTopicListResponse(int code, List<ForumTopicPojo> obj) {
        this.code = code;
        this.obj = obj;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<ForumTopicPojo> getObj() {
        return obj;
    }

    public void setObj(List<ForumTopicPojo> obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "ForumTopicListResponse{" +
                "code=" + code +
                ", obj=" + obj +
                '}';
    }
}
