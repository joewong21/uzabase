package com.uzabase.logger;

import java.util.Date;

public class DebugLogger extends Logger{
	
	public DebugLogger(int pLevel){
	    level = pLevel;
	}
	
	@Override
	protected void generateMessage(String message) {
		System.err.println("[DEBUG] :" + new Date().toString()+ " >> "+ message);		
	}

}
