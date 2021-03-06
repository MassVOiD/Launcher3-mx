package com.android.mxtheme;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.android.mxtheme.bean.ThemeBean;
import com.android.mxtheme.bean.WallpaperBean;

/**
 * Created by CodeMX
 * DATE 2019/2/22
 * TIME 9:22
 */
public class ThemeActivity extends AppCompatActivity implements OnClickListener {

    public static void startThemeActivity(Context context){
        Intent intent = new Intent();
        intent.setClass(context, ThemeActivity.class);
        context.startActivity(intent);
    }

    ThemeClient mThemeChangeClient;
    private Button mBtnTheme;
    private Button mBtnWallpaper;
    private TextView mTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme_activity);

        mBtnTheme = findViewById(R.id.theme_activity_set_theme);
        mBtnWallpaper = findViewById(R.id.theme_activity_set_wallpaper);
        mTv = findViewById(R.id.theme_activity_tv);
        mBtnTheme.setOnClickListener(this);
        mBtnWallpaper.setOnClickListener(this);

        mThemeChangeClient = new ThemeClient();
        mThemeChangeClient.bindService(this);
    }

    @Override
    protected void onDestroy() {
        mThemeChangeClient.unbindService(this);
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.theme_activity_set_theme) {
            ThemeBean bean = new ThemeBean();
            bean.setThemeName("theme");
            mThemeChangeClient.changeTheme(bean);
        } else if (i == R.id.theme_activity_set_wallpaper) {
            WallpaperBean wallpaperBean = new WallpaperBean();
            wallpaperBean.setWallpaperName("theme");
            mThemeChangeClient.changeWallpaper(wallpaperBean);
        } else {
        }
    }
}
