package com.example.lenovo.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;

/**
 * Created by zhengzhihua on 2018/9/11.17:42
 * Update 2018/9/11 17:42
 * Describe
 */

public class FirstFragment extends Fragment {
    private String url;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        url=getArguments().getString("url");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, null);
        MyImageView myImageView=view.findViewById(R.id.image);
        //设置视频控制器
        myImageView.setImageURL(url);
        return view;
    }


}
