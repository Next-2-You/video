package com.chen.action.converter;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

public class DateConverter extends DefaultTypeConverter {


	@Override
	public Object convertValue(Map<String, Object> context, Object value, Class toType) {
		if(value!=null) {
			try {
				System.out.println("日期格式转换器");
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				if (toType == Date.class) {
					String[] parms = (String[]) value;
					return dateFormat.parse(parms[0]);
				}
				if (toType == String.class) {
					Date parms = (Date) value;
					return dateFormat.format(parms);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}	
		}
		return null;
	}

}
