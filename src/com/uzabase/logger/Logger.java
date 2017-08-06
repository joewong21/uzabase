package com.uzabase.logger;

public abstract class  Logger {

	   public static int INFO =  1;
	   public static int DEBUG = 2;
	   public static int FILE = 3;

	   protected int level;

	   protected Logger nextLogger;

	   public void setNextLogger(Logger pNextLogger){
	      nextLogger = pNextLogger;
	   }

	   public void handleMessage(int level, String message){
	      if(this.level == level){
	    	  generateMessage(message);
	      }
	      if(nextLogger !=null){
	         nextLogger.handleMessage(level, message);
	      }
	   }

	   abstract protected void generateMessage(String message);

}
