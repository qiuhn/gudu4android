package com.qiuhn.gudu.ui.view;

import com.qiuhn.gudu.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SelectionTextView extends LinearLayout {

	private TextView mLeftTextView;
	private TextView mCenterTextView;
	private TextView mRightTextView;

	public SelectionTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
	
		
		TypedArray a = context.obtainStyledAttributes(attrs,
				R.styleable.SectionTextView);
		String leftText = a.getString(R.styleable.SectionTextView_leftText);
		String centerText = a.getString(R.styleable.SectionTextView_centerText);
		Drawable drawable = a
				.getDrawable(R.styleable.SectionTextView_rightText_src);
		a.recycle();
		LayoutInflater.from(context).inflate(
				R.layout.view_selection_textview, this);
		initViews();
		mLeftTextView.setText(leftText);
		mLeftTextView.setVisibility(View.VISIBLE);
		mCenterTextView.setText(centerText);
		mRightTextView.setBackgroundDrawable(drawable);
	}

	private void initViews() {
		mLeftTextView = (TextView) findViewById(R.id.tv_left);
		mRightTextView = (TextView)findViewById(R.id.tv_right);
		mCenterTextView = (TextView) findViewById(R.id.tv_center);
	}
}
