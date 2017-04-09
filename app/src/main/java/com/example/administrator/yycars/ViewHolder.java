package com.example.administrator.yycars;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/4/8.
 */
public class ViewHolder {
    private ImageView image;
    private TextView text;

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public TextView getText() {
        return text;
    }

    public void setText(TextView text) {
        this.text = text;
    }
    public ViewHolder(){

    }
    public ViewHolder(ImageView image,TextView text){
        this.image = image;
        this.text = text;
    }
}
