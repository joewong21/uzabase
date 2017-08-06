package com.uzabase.schema;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="rss")
public class Rss {
	
	@XmlElement(name="channel")
	private List<Feed> channel;
	
	public Rss(){}
	
	public List<Feed> getChannel() {
		return channel;
	}
    
}
