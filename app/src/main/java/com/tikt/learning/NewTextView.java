package com.tikt.learning;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by tikt on 16-2-3.
 * 练习重写TextView
 */
public class NewTextView extends TextView {

	Paint mPaint1;
	Paint mPaint2;

	public NewTextView(Context context) {
		super(context);
		//初始化画笔
		initView();
	}

	public NewTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView();
	}

	public NewTextView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initView();
	}

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	public NewTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		initView();
	}

	//初始化画笔
	private void initView(){
	mPaint1 = new Paint();
	mPaint1.setColor(getResources().getColor(android.R.color.holo_blue_light));
	mPaint1.setStyle(Paint.Style.FILL);
	mPaint2 = new Paint();
	mPaint2.setColor(Color.YELLOW);
	mPaint2.setStyle(Paint.Style.FILL);
}
	@Override
	protected void onDraw(Canvas canvas) {
		//绘制外层矩形
		canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint1);
		//绘制内层矩形
		canvas.drawRect(10, 10, getMeasuredWidth() - 10, getMeasuredHeight() - 10, mPaint2);
		canvas.save();
		//绘制文字前平移10像素
		canvas.translate(10,0);
		//父类完成的方法，即绘制文本
		super.onDraw(canvas);
		canvas.restore();
	}


	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
//		if(mViewWidth == 0){
//			mViewWidth = getMeasuredWidth();
//		}
	}

	//重写onMeasure使View能适应wrap_content属性
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));


	}

	private int measureHeight(int heightMeasureSpec) {
		int result = 0;
		int specMode = MeasureSpec.getMode(heightMeasureSpec);
		int specSize = MeasureSpec.getSize(heightMeasureSpec);
		if (specMode == MeasureSpec.EXACTLY) {
			result = specSize;
		} else {
			result = 200;

			/*
			*  计算自身需要的高度
			*result = getNeedHeight()+getPaddingTop()+getPaddingBottom();
			*
			*/
			if (specMode == MeasureSpec.AT_MOST) {
				result = Math.min(result, specSize);
			}
		}
		return result;
	}

	private int measureWidth(int widthMeasureSpec) {
		int result = 0;
		//从MeasureSpec对象中提取出具体的测量模式和大小
		int specMode = MeasureSpec.getMode(widthMeasureSpec);
		int specSize = MeasureSpec.getSize(widthMeasureSpec);
		if (specMode == MeasureSpec.EXACTLY) {
			result = specSize;
		} else {
			result = 200;
			if (specMode == MeasureSpec.AT_MOST) {
				result = Math.min(result, specSize);
			}
		}
		return result;
	}
}
