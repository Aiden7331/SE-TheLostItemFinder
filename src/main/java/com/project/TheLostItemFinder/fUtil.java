package com.project.TheLostItemFinder;

import java.util.Calendar;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.springframework.util.FileCopyUtils;

public class fUtil {
	public static String date(){
		Calendar cal= Calendar.getInstance();
		int month = cal.get(Calendar.MONTH)+1;
		String Month;
		
		if(month<10) {
			Month ="0"+month;
		}else {
			Month= Integer.toString(month);
		}
		String date = cal.get(Calendar.YEAR)+"-"+Month+"-"+cal.get(Calendar.DATE);
		return date;
	}
	
}
