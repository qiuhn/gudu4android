package com.qiuhn.gudu.domain;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table t_school_alias.
 */
public class SchoolAlias {

    private Integer id;
    private int school_id;
    private String master_name;
    private String name;
    private String pinyin;
    private String py;

    public SchoolAlias() {
    }

    public SchoolAlias(Integer id) {
        this.id = id;
    }

    public SchoolAlias(Integer id, int school_id, String master_name, String name, String pinyin, String py) {
        this.id = id;
        this.school_id = school_id;
        this.master_name = master_name;
        this.name = name;
        this.pinyin = pinyin;
        this.py = py;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSchool_id() {
        return school_id;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public String getMaster_name() {
        return master_name;
    }

    public void setMaster_name(String master_name) {
        this.master_name = master_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getPy() {
        return py;
    }

    public void setPy(String py) {
        this.py = py;
    }

}
