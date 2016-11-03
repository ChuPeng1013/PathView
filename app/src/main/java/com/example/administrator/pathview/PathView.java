package com.example.administrator.pathview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ChuPeng on 2016/11/1.
 */
public class PathView extends View
{

    private Paint paint;
    private Path path;
    private RectF oval;
    public PathView(Context context)
    {
        super(context);
    }

    public PathView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public PathView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public PathView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
    {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        paint = new Paint();
        //设置paint的属性
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        //实例化路径
        path = new Path();
        //移动起始点至(100, 100)
        path.moveTo(100, 100);
        //连接路径到指定的点
        path.lineTo(200, 200);
        path.lineTo(200, 100);
        //构建一条末点和起始点的线段
        path.close();
        oval = new RectF(300, 300, 400, 400);
        //添加一条路径
        path.addArc(oval, 0, 90);
        //绘制路径
        canvas.drawPath(path, paint);
    }
}
