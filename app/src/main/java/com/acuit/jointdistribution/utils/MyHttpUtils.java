package com.acuit.jointdistribution.utils;

import com.lidroid.xutils.HttpUtils;

public class MyHttpUtils {

	public static HttpUtils hu;

	public static HttpUtils getHttpUtils() {
		if (hu == null) {
			
			hu = new HttpUtils();
		}
		return hu;
	}

}
