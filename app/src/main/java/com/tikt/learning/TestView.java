package com.tikt.learning;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by tikt on 16-2-3.
 */
public class TestView extends View {
	public TestView(Context context) {
		super(context);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
	}

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
