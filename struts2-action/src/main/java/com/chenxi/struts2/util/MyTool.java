package com.chenxi.struts2.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTool {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(dateToString(date));

	}

	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(date);
	}

	public static Date stringToDate(String s) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.parse(s);
	}

	public static String lengthGet(int size) {
		if (size < 10)
			return "0" + size;
		else
			return "" + size;
	}

	public  static boolean deleteFile(String sPath) {  
		String path = sPath.replace("\\", "\\\\");
		System.out.println(path);
	    boolean flag = false;  
	    File file = new File(path);  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	}  
	
	public static String EngMonth(String month) {
		String str;
		switch (month) {
		case "01":
			str = "JAN";
			break;
		case "02":
			str = "FEB";
			break;
		case "03":
			str = "MAR";
			break;
		case "04":
			str = "APR";
			break;
		case "05":
			str = "MAY";
			break;
		case "06":
			str = "JUN";
			break;
		case "07":
			str = "JUL";
			break;
		case "08":
			str = "AUG";
			break;
		case "09":
			str = "SEP";
			break;
		case "10":
			str = "OCT";
			break;
		case "11":
			str = "NOV";
			break;
		case "12":
			str = "DEC";
			break;
		default:
			str = "NO";
			break;
		}
		return str;
	}
}
