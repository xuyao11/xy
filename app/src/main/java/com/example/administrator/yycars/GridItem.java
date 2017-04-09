package com.example.administrator.yycars;

/**
 * Created by Administrator on 2017/4/8.
 */
public class GridItem {
    private String image;
    private String title;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public GridItem(){

    }
    public GridItem(String image,String title){
        this.image = image;
        this.title = title;

    }
}
