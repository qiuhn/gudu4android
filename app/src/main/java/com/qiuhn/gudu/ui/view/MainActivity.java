package com.qiuhn.gudu.ui.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.qiuhn.gudu.R;

public class MainActivity extends Activity {

	private com.qiuhn.gudu.ui.view.MyEditText mEditText;
	private TextView mShowContent;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		mEditText = (MyEditText) findViewById(R.id.et);
//		mShowContent = (TextView) findViewById(R.id.et_content);
		
	
		
	}

}
