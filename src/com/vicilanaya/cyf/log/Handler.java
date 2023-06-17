package com.vicilanaya.cyf.log;

import java.util.logging.ConsoleHandler;
import java.util.logging.LogRecord;

public class Handler extends ConsoleHandler {

	
	
	@Override
    public void publish(LogRecord record) {
        //add own logic to publish
        super.publish(record);
    }

    @Override
    public void flush() {
        super.flush();
    }

    @Override
    public void close() throws SecurityException {
        super.close();
    }
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

} // end Handler class
