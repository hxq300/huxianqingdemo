package com.wisdom.lsy.huxianqingdemo.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.wisdom.lsy.huxianqingdemo.R;

/**
 * Created by hxq on 2021/2/22
 * describe :  TODO 仿QQ计步器
 */
public class QQStepView extends View {
    private int mOuterColor = Color.RED;
    private int mInnerColor = Color.BLUE;
    private int mBorderWidth = 20;
    private int mStepTextSize = 15;
    private int mStepTextColor = Color.BLACK;
    private Paint mOutPaint;

    public QQStepView(Context context) {
        super(context);
    }

    public QQStepView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // 获取自定义属性
        TypedArray array = context.obtainStyledAttributes(R.styleable.QQStepView);
        mOuterColor = array.getColor(R.styleable.QQStepView_outerColor,mOuterColor);
        mInnerColor = array.getColor(R.styleable.QQStepView_innerColor,mInnerColor);
        mBorderWidth = array.getColor(R.styleable.QQStepView_borderWidth,mBorderWidth);
        mStepTextSize = array.getDimensionPixelSize(R.styleable.QQStepView_stepTextSize,mStepTextSize);
        mStepTextColor = array.getColor(R.styleable.QQStepView_stepTextColor,mStepTextColor);
        // 回收
        array.recycle();

        mOutPaint = new Paint();
        mOutPaint.setAntiAlias(true);
        mOutPaint.setStrokeWidth(mBorderWidth);
        mOutPaint.setColor(mOuterColor);
        mOutPaint.setStyle(Paint.Style.STROKE); //实心圆
    }

    public QQStepView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 外圈弧
        int center = getWidth() / 2;
        int radius = getWidth() / 2 - mBorderWidth/2;
        RectF rectF = new RectF(center - radius, getWidth(), center + radius, getHeight());
        canvas.drawArc(rectF,135,270,false,mOutPaint);

    }

}
