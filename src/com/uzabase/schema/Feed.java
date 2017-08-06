package com.uzabase.schema;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*; 

@XmlRootElement(name="channel")
@XmlAccessorType(XmlAccessType.FIELD)
public class Feed {

	@XmlElement(name="title")
	private  String title;
	 
	@XmlElement(name="link")
	private  String link;
	
	@XmlElement(name="description")
	private  String description;
	
	@XmlElement(name="lastBuildDate")
	private  String lastBuildDate;
	
	@XmlElement(name="docs")
	private  String docs;
	
	@XmlElement(name="generator")
	private  String generator;
	
	@XmlElement(name="item")
	private List<Item> items = new ArrayList<Item>();
	
	public Feed(){
		
	}
	
	public Feed(String pTitle, String pLink, String pDescription, String pLastBuildDate, 
			String pDocs, String pGenerator) {
		title = pTitle;
		link = pLink;
		description = pDescription;
		lastBuildDate = pLastBuildDate;
		docs = pDocs;
		generator = pGenerator;
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


	public String getLastBuildDate() {
		return lastBuildDate;
	}


	public String getDocs() {
		return docs;
	}


	public String getGenerator() {
		return generator;
	}


	public List<Item> getFeedItems() {
		return items;
	}


	@Override
	public String toString() {
		return "Feed [title=" + title + ", link=" + link + ", description=" + description + ", lastBuildDate="
				+ lastBuildDate + ", docs=" + docs + ", generator=" + generator + "]";
	}
    
}
