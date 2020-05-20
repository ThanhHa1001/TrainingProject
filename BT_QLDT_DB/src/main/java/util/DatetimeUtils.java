package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import repository.impl.ClassroomRepository;

public class DatetimeUtils {
	private static final Logger logger = LoggerFactory.getLogger(ClassroomRepository.class);
	
	public static final String CREATED_AT_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	public static String convertDateToString(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date).toString();
	}
	
	public static Date convertDateToString(String strDate, String pattern) {
		Date date = null;
		try {
			date = new SimpleDateFormat(pattern).parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
			logger.error("ParseException ", e);
		}
		return date;
	}
}
