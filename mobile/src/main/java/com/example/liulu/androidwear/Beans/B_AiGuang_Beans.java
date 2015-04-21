package com.example.liulu.androidwear.Beans;

/**
 * Created by liulu on 2015/4/21.
 */
public class B_AiGuang_Beans {
    private  String original_price ;
    private String mobile_url ;
    private String title ;
    private  String liked_num ;
    private String price ;
    private String image;
    private int id;

    public B_AiGuang_Beans(String original_price, String mobile_url, String title, String liked_num, String price, String image, int id) {
        this.original_price = original_price;
        this.mobile_url = mobile_url;
        this.title = title;
        this.liked_num = liked_num;
        this.price = price;
        this.image = image;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "B_AiGuang_Beans{" +
                "original_price='" + original_price + '\'' +
                ", mobile_url='" + mobile_url + '\'' +
                ", title='" + title + '\'' +
                ", liked_num='" + liked_num + '\'' +
                ", price='" + price + '\'' +
                ", image='" + image + '\'' +
                ", id=" + id +
                '}';
    }

    public void setOriginal_price(String original_price) {
        this.original_price = original_price;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLiked_num(String liked_num) {
        this.liked_num = liked_num;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOriginal_price() {
        return original_price;
    }

    public String getMobile_url() {
        return mobile_url;
    }

    public String getTitle() {
        return title;
    }

    public String getLiked_num() {
        return liked_num;
    }

    public String getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
}
