package com.lvbu.zha.viewtest.utils;

import android.content.Context;
import android.content.res.Resources;

/**
 * Created by DaiQing.Zha on 2016/9/7 0007.
 */
public class Util {

    /**
     * dp转像素
     * @param resources
     * @param dpValue
     * @return
     */
    public static int dpToPx(Resources resources, float dpValue) {//dp转换为px
        float scale=resources.getDisplayMetrics().density;//获得当前屏幕密度
        return (int)(dpValue*scale+0.5f);
    }
}
