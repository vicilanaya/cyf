package com.vicilanaya.cyf.log;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.vicilanaya.cyf.CyF;

public class Log {

	// https://docs.oracle.com/javase/8/docs/api/java/util/logging/Logger.html
	// https://www.digitalocean.com/community/tutorials/logger-in-java-logging-example
	static Logger cyfLogger = Logger.getLogger(CyF.class.getName());
	cyfLogger.setLevel(Level.INFO);
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Log log = new Log();

	} // end main method 

} // end Log class



//package com.vicilanaya.cyf.components;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Log {
//
//	List<LogEntry> log = null;
//	
//	public Log() {
//		setLog(new ArrayList<>());
//	}
//
//	public List<LogEntry> getLog() {
//		return log;
//	}
//
//	public void setLog(List<LogEntry> log) {
//		this.log = log;
//	}
//
//	public void addLogEntry(LogEntry logEntry) {
//		log.add(logEntry);
//	}
//	
//	@Override
//	public String toString() {
//		return getLog() + "";
//	}
//
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Log log = new Log();
//		
//
//	} // end main method 
//
//} // end Log class
