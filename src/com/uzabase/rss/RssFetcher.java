package com.uzabase.rss;

import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;


public class  RssFetcher<T> {
	
	private final String rssUrl;
	private final String[] excludeKeywords;
	private final Class<T> clazz;
	
	
	public RssFetcher(String pUrl, String[] pExcludeKeywords, Class<T> pClazz){
		rssUrl = pUrl;
		excludeKeywords = pExcludeKeywords;
		clazz = pClazz;
	}
	
	public T fetchFeed() throws Exception
    {
        URL url = new URL(rssUrl);
        URLConnection connection = url.openConnection();
        Document doc = parseXML(connection.getInputStream());
        String xml = removeKeyword(convertDocumentToString(doc));

        JAXBContext jc = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        StringReader stringReader = new StringReader(xml);
        XMLInputFactory xif = XMLInputFactory.newInstance();
        XMLStreamReader xsr = xif.createXMLStreamReader(stringReader);
        T Rss = (T)unmarshaller.unmarshal(xsr); 
        return Rss;
         
    }

    private Document parseXML(InputStream stream)
    throws Exception
    {
        DocumentBuilderFactory objDocumentBuilderFactory = null;
        DocumentBuilder objDocumentBuilder = null;
        Document doc = null;
        try
        {
            objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
            objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();

            doc = objDocumentBuilder.parse(stream);
        }
        catch(Exception ex)
        {
            throw ex;
        }       

        return doc;
    }

    private static String convertDocumentToString(Document doc) {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = tf.newTransformer();
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            String output = writer.getBuffer().toString();
            return output;
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    private String removeKeyword(String xml){
    	String retXml = xml;
    			
    	for(String kw : excludeKeywords){
    		retXml = retXml.replaceAll(kw,"");
    	}
    	return retXml;
    }
}
