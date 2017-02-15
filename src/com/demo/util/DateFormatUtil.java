package com.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class DateFormatUtil {
	public static Date dateFormat(String proDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 将String 转化为Date
		java.util.Date dates = sdf.parse(proDate);
		// 将java.util.Date转化为java.sql.Date
		Date date = new Date(dates.getTime());
		return date;
	}

}
