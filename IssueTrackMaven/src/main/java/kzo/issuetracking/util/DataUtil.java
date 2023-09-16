package kzo.issuetracking.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

public class DataUtil {
	/**
	 * Application Date Format
	 */
	public static final String APP_DATE_FORMAT = "MM/dd/yyyy";
	// public static final String APP_TIME_FORMAT = "MM/dd/yyyy HH:mm:ss";
	/**
	 * Date formatter
	 */
	private static final SimpleDateFormat formatter = new SimpleDateFormat(APP_DATE_FORMAT);

	// private static final SimpleDateFormat timeFormatter = new
	// SimpleDateFormat(APP_TIME_FORMAT);
	
	//Trims, trailing and leading spaces of a String
	public static String getString(String val) {
		if (DataValidator.isNotNull(val)) {
			return val.trim();
		} else {
			return val;
		}
	}

	//Converts any Object to String
	public static String getStringData(Object val) {

		if (val != null) {
			return val.toString();
		} else {
			return "";
		}
	}

	//Converts String into Integer
	public static int getInt(String val) {
		if (DataValidator.isInteger(val)) {
			return Integer.parseInt(val);
		} else {
			return 0;
		}
	}
	
	//Converts String into Long
	public static long getLong(String val) { 
		if (DataValidator.isLong(val)) {
			return Long.parseLong(val); 
		} else { 
			return 0; 
		} 
	}
	

	//Converts String into Date
	public static Date getDate(String val) {
		Date date = null;
		try {
			date = formatter.parse(val);
		} catch (Exception e) {
		}
		return date;
	}

	//Converts Date into String
	public static String getDateString(Date date) {
		try {
			if (date != null) {
				return formatter.format(date);
			} else {
				return "";
			}
		} catch (Exception e) {
			return "";
		}
	}
	
	public static Timestamp getCurrentTimestamp() {
	    Timestamp timeStamp = null;
	    try {
	      timeStamp = new Timestamp(new Date().getTime());
	    } catch (Exception e) {
	    }
	    return timeStamp;
	  }
}
