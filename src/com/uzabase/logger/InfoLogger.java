package com.uzabase.logger;

import java.util.Date;

public class InfoLogger extends Logger{

	public InfoLogger(int pLevel){
	    level = pLevel;
	}
	
	@Override
	protected void generateMessage(String message) {
		System.out.println("[INFO] :" + new Date().toString()+ " >> "+ message);
		
	}
	

}
