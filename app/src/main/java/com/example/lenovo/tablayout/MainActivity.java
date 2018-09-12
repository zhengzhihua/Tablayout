package com.example.lenovo.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengzhihua on 2018/9/11.16:40
 * Update 2018/9/11 16:40
 * Describe
 */

public class MainActivity extends AppCompatActivity {

    private TabLayout tl;
    private ViewPager vp;
    private List<String> datas = new ArrayList<String>();
    private String[] status = new String[]{"0","1","2"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tl = (TabLayout) findViewById(R.id.tl);

        vp = (ViewPager) findViewById(R.id.vp);
        datas.add("照片");
        datas.add("视频");
        datas.add("地图");
        for (int i = 0; i < datas.size(); i++) { TabLayout.Tab tab = tl.newTab();//创建tab
            tab.setText(datas.get(i));//设置文字
            tl.addTab(tab);//添加到tabLayout中
             }
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, tab.getText(), Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
//        vp.setAdapter(new MyAdapter(getSupportFragmentManager()));
//        //进行关联
//        tl.setupWithViewPager(vp);

    }
    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
        //带参的构造方法
        @Override
        public int getCount() {
            return datas.size();
        }

        //返回选项卡的文本 ，，，添加选项卡
        @Override
        public CharSequence getPageTitle(int position) {
            return datas.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            //创建fragment对象并返回
            Bundle bundle = new Bundle();
            bundle.putString("url", status[position]);
            //实例化Fragment
            AllFragment allFragment = new AllFragment();
            allFragment.setArguments(bundle);
            return allFragment;
        }
    }
}
