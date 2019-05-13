package com.project.TheLostItemFinder;

import java.util.Calendar;

public class fUtil {
	public static String date(){
		String date = "";
		date += Integer.toString(Calendar.YEAR)+"-";
		date += Integer.toString(Calendar.MONTH + 1)+"-";
		date += Integer.toString(Calendar.DATE)+".";
		date += Integer.toString(Calendar.HOUR)+"h";
		
		return date;
	}
}
