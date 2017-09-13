package com.meession.homework.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class LongTextConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		String rs="";
		Integer cutLength;
		String l=(String)component.getAttributes().get("cutLength");
		if(null==l){
			cutLength=50;
		}else{
			cutLength=Integer.valueOf(l);
		}
		    if(null!=value&&(value instanceof String)){
		    	rs=showText((String)value,cutLength);
		    }
		return rs;
	}

	 private String showText(String str,int cutLength) {
		  StringBuffer summary = new StringBuffer();
		     if (str.trim().length() > cutLength) {
		     summary.append(str.trim().substring(0, cutLength) + "......");
		      } 
		    else {
		       summary.append(str.trim());
		      }
		  return summary.toString();
		 }
	
}
