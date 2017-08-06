package com.uzabase.logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger extends Logger{
	 
	String loggerName;
	
    public FileLogger(int pLevel,String pLoggerName){
	    level = pLevel;
	    loggerName = pLoggerName;
	}

	@Override
	protected void generateMessage(String message) {
		System.out.println("[Log To File] :" + new Date().toString()+ " >> "+ message.substring(0,200)+ "....");
		try {
			String fileName = generateFileName(loggerName);
			File logFile = new File(fileName);
			FileWriter logwriter = new FileWriter(logFile,true);
			BufferedWriter writer = new BufferedWriter(logwriter);  
			writer.write(message);
			System.out.println("[Logged to file : " + fileName +"]");
		} catch (IOException e) {
			System.err.println("Failed to log the file.");
		}
	}
	
	private String generateFileName(String loggerName){
		Date date = new Date() ;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MMM_dd_HH_mm_ss");
		return loggerName +"_"+dateFormat.format(date)+ ".log";
	}
}
