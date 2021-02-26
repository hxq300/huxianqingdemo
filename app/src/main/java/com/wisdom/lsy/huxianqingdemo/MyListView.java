package com.wisdom.lsy.huxianqingdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

import java.util.List;

/**
 * Created by hxq on 2021/1/21
 * describe :  TODO
 */
public class MyListView extends ListView {
    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 解决显示不全的问题
        // 最大值
        //MeasureSpec.makeMeasureSpec 重置
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
