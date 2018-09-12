package com.example.lenovo.tablayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by zhengzhihua on 2018/9/11.17:37
 * Update 2018/9/11 17:37
 * Describe
 */

public class Hello extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[] title = {"图片", "视频", "地图"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.fragment_pager);
        initPager();
    }

    private void initPager() {
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = new Fragment();
                Bundle bundle=new Bundle();
                if (fragment != null) {
                    switch (position) {
                        case 0:
                            fragment = new FirstFragment();
                            bundle.putString("url","http://114.115.143.146:8080/hsjZfzj/1534742739640-1.png");
                            fragment.setArguments(bundle);
                            break;
                        case 1:
                            fragment = new SecondFragment();
                            bundle.putString("url","http://streamdl.ydstatic.com/private/xuetang/pushstation.5335831a4707_screen_merge_49eba987.mp4");
                            fragment.setArguments(bundle);
                            break;
                        case 2:
                            fragment = new ThirdFragment();
                            break;
                    }
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return 3;
            }
        });

        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(0);
        tabLayout.getTabAt(0).setCustomView(getTabView(0));
        tabLayout.getTabAt(1).setCustomView(getTabView(1));
        tabLayout.getTabAt(2).setCustomView(getTabView(2));

        initTab();
    }
    private void initTab() {
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                TextView textView = view.findViewById(R.id.txt_tab_task);

                textView.setTextColor(Color.parseColor("#ed8200"));
                if (textView.getText().toString().equals(title[0])) {

                    viewPager.setCurrentItem(0);
                } else if (textView.getText().toString().equals(title[1])) {

                    viewPager.setCurrentItem(1);
                } else if (textView.getText().toString().equals(title[2])) {

                    viewPager.setCurrentItem(2);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                TextView textView = view.findViewById(R.id.txt_tab_task);
                textView.setTextColor(Color.parseColor("#3F51B5"));
                if (textView.getText().toString().equals(title[0])) {

                    viewPager.setCurrentItem(0);
                } else if (textView.getText().toString().equals(title[1])) {

                    viewPager.setCurrentItem(1);
                } else if (textView.getText().toString().equals(title[2])) {

                    viewPager.setCurrentItem(2);
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private View getTabView(int position) {
        View view = LayoutInflater.from(this).inflate(R.layout.tab_task_item, null);
        TextView textView = view.findViewById(R.id.txt_tab_task);

        textView.setText(title[position]);


        if (position == 0) {
            textView.setTextColor(Color.parseColor("#ed8200"));

        }
        return view;
    }
}
