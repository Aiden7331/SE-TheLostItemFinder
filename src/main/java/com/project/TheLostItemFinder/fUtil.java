package com.project.TheLostItemFinder;

import java.util.Calendar;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.springframework.util.FileCopyUtils;

public class fUtil {
	public static String date(){
		Calendar cal= Calendar.getInstance();
		int month = cal.get(Calendar.MONTH)+1;
		String date = cal.get(Calendar.YEAR)+"-"+month+"-"+cal.get(Calendar.DATE);
		return date;
	}
	
}
