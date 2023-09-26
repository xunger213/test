package com.baidu.pojo;

import java.util.List;

public class Pokemen {
    private Integer id;
    private Integer number;         //编号
    private String name;            //名称
    private Integer ss;             //战斗力
    private String url;             //图片
    private String stature;        //身高
    private String weight;         //体重
    private String characteristic;  //描述
    private List<Attributes> attrs; //属性

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSs() {
        return ss;
    }

    public void setSs(Integer ss) {
        this.ss = ss;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStature() {
        return stature;
    }

    public void setStature(String stature) {
        this.stature = stature;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public List<Attributes> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<Attributes> attrs) {
        this.attrs = attrs;
    }
}
