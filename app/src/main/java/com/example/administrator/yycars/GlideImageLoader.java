package com.example.administrator.yycars;

import android.content.Context;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by Administrator on 2017/3/25.
 */
public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Picasso.with(context).load((int)path).into(imageView);
        imageView.setImageResource((int)path);
    }
   /* @Override
   public ImageView createImageView(Context context){
      SimpleDraweeView simpleDraweeView = new SimpleDraweeView(context);
        return simpleDraweeView;
    }*/
}
