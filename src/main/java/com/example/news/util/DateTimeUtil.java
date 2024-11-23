package com.example.news.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {

	/**
	 * 以yyyy-MM-dd HH:mm:SS格式返回当前时间字符串
	 * 
	 * @return
	 */
	static public String getNowStr() {
		String resultStr = getDateStr(new Date(), "yyyy-MM-dd HH:mm:ss");

		return resultStr;
	}

	/**
	 * 返回指定格式的时间字符串，如yyyy-MM-dd, 或HH:mm:SS
	 * 
	 * @param format
	 * @return
	 */
	static public String getDateStr(Date date, String pattern) {
		// Date date =new Date();
		String dateStr = null;
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			dateStr = sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dateStr;
	}

	static public void main(String[] args) throws Exception {
		System.out.print(getNowStr());
	}
}
