package com.example.lenovo.tablayout;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * Created by zhengzhihua on 2018/9/11.17:45
 * Update 2018/9/11 17:45
 * Describe
 */

public class SecondFragment extends Fragment{
    private String url;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        url=getArguments().getString("url");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, null);
        VideoView videoView=view.findViewById(R.id.video_text);
        //设置视频控制器
        videoView.setMediaController(new MediaController(getContext()));

        //播放完成回调
        videoView.setOnCompletionListener( new MyPlayerOnCompletionListener());

        //设置视频路径
        //videoView.setVideoURI(uri);
        videoView.setVideoPath(url);

        //开始播放视频
        videoView.start();
        return view;
    }

    class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mp) {
            Toast.makeText( getContext(), "播放完成了", Toast.LENGTH_SHORT).show();
        }
    }
}
