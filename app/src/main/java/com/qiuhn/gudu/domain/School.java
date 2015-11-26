package com.qiuhn.gudu.domain;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table t_school.
 */
public class School {

    private Integer id;
    /** Not-null value. */
    private String name;
    private String pinyin;
    private String py;
    private Integer rank;

    public School() {
    }

    public School(Integer id) {
        this.id = id;
    }

    public School(Integer id, String name, String pinyin, String py, Integer rank) {
        this.id = id;
        this.name = name;
        this.pinyin = pinyin;
        this.py = py;
        this.rank = rank;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getName() {
        return name;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
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

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

}
