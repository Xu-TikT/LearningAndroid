package com.tikt.learning;

import android.content.Context;
import android.view.View;

/**
 * Created by tikt on 16-2-3.
 */
public class TestView extends View {
	public TestView(Context context) {
		super(context);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
}
