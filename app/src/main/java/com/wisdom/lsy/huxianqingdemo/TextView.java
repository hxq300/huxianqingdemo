package com.wisdom.lsy.huxianqingdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by hxq on 2021/1/21
 * describe :  TODO
 */
public class TextView extends View {
    //new 的时候调用
    public TextView(Context context) {
        super(context);
    }
    //在布局中使用时调用
    public TextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    //在style设置样式时调用
    public TextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     *
     * widthMeasureSpec heightMeasureSpec // 包含二个信息 一个32位的值 前两位模式 后30位具体值
     *
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 获取布局的模式
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

//        MeasureSpec.getSize() // 获取具体值 高度/宽度

//        MeasureSpec.AT_MOST wrap_content
//        MeasureSpec.AT_EXACTLY 指定确切值 100dp match_parent
//        MeasureSpec.AT_UNSPECIFIED 尽可能大 ListView ， ScrollView

        // 面试题 ScrollView嵌套ListView item只显示一条的 问题
        // 原因： ScrollView 高度模式是AT_UNSPECIFIED 尽可能大  传递给ListView
        // ListView给自己指定高度为 padding_top +padding_bottom + childHeight 所以就只有一个item的高度
        // 解决方案：
        // heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        // Integer.MAX_VALUE最大值 是个32位的值 右移两位 就是变成一个30位的在值 还有两位是MeasureSpec.AT_MOST
        // 后面会进行拼接 ListView 里面这时就会走匹配AT_MOST的代码
    }
}
