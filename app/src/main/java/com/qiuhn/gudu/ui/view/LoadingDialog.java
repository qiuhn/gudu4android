package com.qiuhn.gudu.ui.view;


import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.qiuhn.gudu.R;

public class LoadingDialog extends Dialog {

	private static LoadingDialog dlg;

	public LoadingDialog(Context context) {
		super(context);
	}

	public LoadingDialog(Context context, int theme) {
		super(context, theme);
	}

	public static LoadingDialog createDialog(Context context) {
		dlg = new LoadingDialog(context, R.style.NotTitleBarDialog);
		dlg.setContentView(R.layout.animation_dialog);
		return dlg;
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
	}

	public LoadingDialog setMessage(String strMessage) {
		TextView tvMsg = (TextView) dlg.findViewById(R.id.tv_message);
		if (tvMsg != null) {
			tvMsg.setText(strMessage);
			tvMsg.setVisibility(View.VISIBLE);
		}
		return dlg;
	}

	public LoadingDialog setMessage(int res) {
		TextView tvMsg = (TextView) dlg.findViewById(R.id.tv_message);
		if (tvMsg != null) {
			tvMsg.setText(res);
			tvMsg.setVisibility(View.VISIBLE);
		}
		return dlg;
	}
	/**
	 * 触摸屏幕时进度框不消失
	 * @author wwt
	 */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        return super.onTouchEvent(event);
        return false;
    }
	
}
