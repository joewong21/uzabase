package com.uzabase.schema;
import javax.xml.bind.annotation.*; 

public class Item {
	
	@XmlElement(name="title")
	private   String title;
	
	@XmlElement(name="link")
	private   String link;
	
	@XmlElement(name="description")
	private   String description;
	
	@XmlElement(name="pubDate")
	private   String pubDate;
	
	@XmlElement(name="guid")
	private   Guid guid;
	
	@XmlElement(name="enclosure")
	private   Enclosure enclosure;
	
	
	public Item(){}
	
	public Item(String pTitle, String pLink, String pDescription, 
			String pPubDate, Guid pGuid, Enclosure pEnclosure){
		title = pTitle;
		link = pLink;
		description  = pDescription;
		pubDate = pPubDate;
		guid = pGuid;
		enclosure = pEnclosure;
	}

	public String getTitle() {
		return title;
	}

	public String getLink() {
		return link;
	}

	public String getDescription() {
		return description;
	}

	public String getPubDate() {
		return pubDate;
	}

	public Guid getGuid() {
		return guid;
	}

	public Enclosure getEnclosure() {
		return enclosure;
	}

	@Override
	public String toString() {
		return "Item [title=" + title + ", link=" + link + ", description=" + description.toString() + ", pubDate=" + pubDate
				+ ", guid=" + guid.toString() + ", enclosure=" + enclosure.toString() + "]";
	} 
	
	
	
}
