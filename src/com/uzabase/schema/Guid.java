package com.uzabase.schema;
import javax.xml.bind.annotation.*; 

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Guid {
    
	@XmlValue
	private  String guid;
	
	@XmlAttribute
	private  boolean isPermalink;
	
	
	public Guid(){}
	
	public Guid(boolean pIsPermalink, String pId){
		isPermalink = pIsPermalink;
		guid = pId;
	}

	public boolean isPermalink() {
		return isPermalink;
	}	
	

	public String getId() {
		return guid;
	}

	@Override
	public String toString() {
		return "Guid [isPermalink=" + isPermalink + ", guid=" + guid + "]";
	}

	
}
