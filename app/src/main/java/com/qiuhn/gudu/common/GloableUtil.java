package com.qiuhn.gudu.common;

import android.content.Context;
import android.telephony.TelephonyManager;

public class GloableUtil {

	/**
	 * 获取手机标识号
	 * @param context
	 * @return
	 */
	public static String getIMEI(Context context) {
		TelephonyManager TelephonyMgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		String szImei = TelephonyMgr.getDeviceId();
		return szImei;
	}

}
