package com.example.administrator.yycars;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DcFragment extends Fragment {
    private GridView gridView;
    private GridViewAdapter gridViewAdapter;
    private List<String> titles = new ArrayList<String>();
    private List<Integer> imageids = new ArrayList<Integer>();
    SimpleAdapter simpleAdapter;
    Map<String,Object> map;
    List<Map<String,Object>> dataList = new ArrayList<Map<String, Object>>();
    private Banner banner;
    private List<Integer> images = new ArrayList<Integer>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        titles.add("为什么选择优越");
        titles.add("我们的优势");
        titles.add("服务范围");
        titles.add("教练团队");
        titles.add("服务价格");
        titles.add("教学大纲");

        imageids.add(R.drawable.reason);
        imageids.add(R.drawable.advantage);
        imageids.add(R.drawable.range);
        imageids.add(R.drawable.team);
        imageids.add(R.drawable.price);
        imageids.add(R.drawable.outline);

        images.add(R.drawable.banner01);
        images.add(R.drawable.banner02);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dc, container, false);
        
        gridView = (GridView)view.findViewById(R.id.gridview);
        simpleAdapter = new SimpleAdapter(view.getContext(),getData(),R.layout.index_gridview,
                new String[]{"image","title"},new int[]{R.id.item_iv,R.id.item_tv});
        gridView.setAdapter(simpleAdapter);

        banner = (Banner)view.findViewById(R.id.banner);
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(images);
        banner.setDelayTime(3000);
        banner.start();
        return view;
    }

    private List< Map<String,Object>> getData() {
        for (int i = 0;i< titles.size();i++){
            Map<String,Object> map = new HashMap<>();
            map.put("title",titles.get(i));
            map.put("image",imageids.get(i));
            dataList.add(map);
        }
        return  dataList;
    }


}

