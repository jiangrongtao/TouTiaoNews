package com.itoutiao.news.toutiaonews.util;

import android.content.Context;
import android.view.WindowManager;

import com.itoutiao.news.toutiaonews.base.ITTApplication;


/**
 * Created by 0bug-yun on 2016/8/24.
 */
public class WindowsUtil {
    static WindowManager wm = (WindowManager) ITTApplication.getInstance()
            .getSystemService(Context.WINDOW_SERVICE);

    public static int getWindowsWidth() {

        return wm.getDefaultDisplay().getWidth();
    }

    public static int getWindowsHeight() {
        return wm.getDefaultDisplay().getHeight();
    }


}
