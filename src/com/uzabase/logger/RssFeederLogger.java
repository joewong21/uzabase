package com.uzabase.logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RssFeederLogger {
	 
	public static Logger getLogger(String loggerName){
		
		try{
		  Logger infoLogger = new InfoLogger(Logger.INFO);
	      Logger debugLogger = new DebugLogger(Logger.DEBUG);	      
	      Logger fileLogger = new FileLogger(Logger.FILE, loggerName);

	      infoLogger.setNextLogger(debugLogger);
	      debugLogger.setNextLogger(fileLogger);
	      
	      return infoLogger;
	      
		}catch(Exception ex){
			System.err.println("Failed to initiate Logger :" + ex.getMessage());
		}
		return null;
	      	
	   }	

}
