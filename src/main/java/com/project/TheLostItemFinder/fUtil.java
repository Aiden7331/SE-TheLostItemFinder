package com.project.TheLostItemFinder;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Calendar;

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
	
	public static String PathEncoding(String str) throws UnsupportedEncodingException {
		byte[] bytes=str.getBytes();
		CharBuffer cbuffer = CharBuffer.wrap((new String(bytes, "EUC-KR")).toCharArray());
		Charset utf8charset = Charset.forName("UTF-8");
		ByteBuffer bbuffer = utf8charset.encode(cbuffer);

		String tmpDecode = new String(bbuffer.array());
		tmpDecode.replaceAll(" ", "_");
		System.out.println(tmpDecode);
		return tmpDecode;
	}
}
