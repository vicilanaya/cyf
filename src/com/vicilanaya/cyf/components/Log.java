package com.vicilanaya.cyf.components;

import java.util.ArrayList;
import java.util.List;

public class Log {

	List<LogEntry> log = null;
	
	public Log() {
		setLog(new ArrayList<>());
	}

	public List<LogEntry> getLog() {
		return log;
	}

	public void setLog(List<LogEntry> log) {
		this.log = log;
	}

	public void addLogEntry(LogEntry logEntry) {
		log.add(logEntry);
	}
	
	@Override
	public String toString() {
		return getLog() + "";
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	} // end main method 

} // end Log class
