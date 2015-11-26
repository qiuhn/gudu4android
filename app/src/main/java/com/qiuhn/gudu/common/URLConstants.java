package com.qiuhn.gudu.common;

public class URLConstants {

	public static final String url = "http://192.168.1.100:9080/gudu-chat";

	public static final String url_login = url + "/account/login/{username}/{pwd}/{mobileNo}";

	public static final String url_topic_list = url + "/account/login/{username}/{pwd}/{mobileNo}";


	public static String getForumTopicListURL(long userid,long time,int timeCount,int size){
		return url + "/forum/queryTopics?userid="+userid+"&time="+time+"&timeCount="+timeCount+"&size="+size;
	}
}
