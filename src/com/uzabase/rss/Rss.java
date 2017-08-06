package com.uzabase.rss;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.uzabase.schema.Feed;

@XmlRootElement(name="rss")
public class Rss {
	
	@XmlElement(name="channel")
	private List<Feed> channel;
	
	public Rss(){}
	
	public List<Feed> getChannel() {
		return channel;
	}
    
}
