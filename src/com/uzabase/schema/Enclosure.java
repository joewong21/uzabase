package com.uzabase.schema;

import javax.xml.bind.annotation.*;

public class Enclosure {
	
	@XmlAttribute
	private String url;
	
	@XmlAttribute
	private String type;
	
	@XmlAttribute
	private int length;
	
	public Enclosure(){}
	
	public Enclosure(String pUrl, String pType, int pLength ){
		url = pUrl;
		type = pType;
		length = pLength;
	}

	public String getUrl() {
		return url;
	}

	public String getType() {
		return type;
	}

	public int getLength() {
		return length;
	}

	@Override
	public String toString() {
		return "Enclosure [url=" + url + ", type=" + type + ", length=" + length + "]";
	}
 
	
	 
	
}
