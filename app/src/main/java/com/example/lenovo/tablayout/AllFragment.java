package com.example.lenovo.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhengzhihua on 2018/9/11.16:47
 * Update 2018/9/11 16:47
 * Describe
 */

public class AllFragment extends Fragment {
    private String urlTitle;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.allfragment_layout,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //获取Activity传来的数据
        Bundle bundle = getArguments();
        urlTitle = bundle.getString("url").toString();
    }
}
