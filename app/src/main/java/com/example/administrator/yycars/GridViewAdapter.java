package com.example.administrator.yycars;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/8.
 */
public class GridViewAdapter extends ArrayAdapter<GridItem> {

    private Context context;
    private int layoutId;
    private List<GridItem> gridItems = new ArrayList<GridItem>();

    public GridViewAdapter(Context context, int resource, List<GridItem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layoutId = resource;
        this.gridItems = objects;
    }
    public void setGridData(List<GridItem> objects){
        this.gridItems = objects;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(layoutId,parent,false);
            holder = new ViewHolder();
            holder.setImage((ImageView) convertView.findViewById(R.id.item_iv));
            holder.setText((TextView) convertView.findViewById(R.id.item_tv));
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }
        GridItem gridItem = gridItems.get(position);
        holder.getText().setText(gridItem.getTitle());
        Picasso.with(context).load(gridItem.getImage()).into(holder.getImage());
        return convertView;
    }
}
