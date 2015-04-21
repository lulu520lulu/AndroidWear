package com.example.liulu.androidwear.Tools;

import android.content.Context;

import com.example.liulu.androidwear.R;
import com.lidroid.xutils.BitmapUtils;

/**
 * Created by liulu on 2015/4/20.
 */
public class BitMapUtilsTools {
    public static BitmapUtils bitmapUtils;
    public static BitmapUtils getBitmap(Context context){
        if (bitmapUtils!=null){
          return  bitmapUtils;
        }
        bitmapUtils =new BitmapUtils(context,
                context.getExternalCacheDir().getPath(),
                0.35f,
                10*1024*1024
        );
        bitmapUtils.configDefaultLoadingImage(R.drawable.ic_launcher);
        bitmapUtils.configDefaultLoadFailedImage(R.drawable.ic_launcher);
        bitmapUtils.configMemoryCacheEnabled(true);
        bitmapUtils.configDiskCacheEnabled(true);
        bitmapUtils.configThreadPoolSize(4);
        return bitmapUtils;
    }
}
