package com.uzabase.rss;

import java.io.StringWriter;
import java.net.UnknownHostException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.uzabase.logger.Logger;
import com.uzabase.logger.RssFeederLogger;
import com.uzabase.schema.Rss;

public class UzabaseFeeder {

	static Logger logger = RssFeederLogger.getLogger("rss");
	private final static String[] EXCLUDED_KEYWORDS_REGEX = {"(?i)NewsPicks"};
	private final static String  RSS_URL = "http://tech.uzabase.com/rss";

	
	public static void main(String[] args) {		
		try {
		   logger.handleMessage(Logger.INFO,"Start Rss fetching ..");
		   UzabaseFeeder  feeder = new UzabaseFeeder();	
           Rss rss = new RssFetcher<Rss>(RSS_URL, EXCLUDED_KEYWORDS_REGEX, Rss.class).fetchFeed();
           String rsstext = feeder.convertFeedtoText(rss);
           logger.handleMessage(Logger.FILE,rsstext);
        }catch(UnknownHostException connEx){
        	logger.handleMessage(Logger.DEBUG,"Unable to reach host : " + RSS_URL);
        }catch(JAXBException jaxbEx){        	
        	logger.handleMessage(Logger.DEBUG,"xml feed object conversion error.");
        }catch (Exception e) {
            logger.handleMessage(Logger.DEBUG, e.getMessage());
        }
	}

	private String convertFeedtoText(Rss rss) throws JAXBException{
		
		String output = null;
		JAXBContext jc = JAXBContext.newInstance(Rss.class);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(rss, sw);
        output = sw.toString();
		return output;
	}

}

		