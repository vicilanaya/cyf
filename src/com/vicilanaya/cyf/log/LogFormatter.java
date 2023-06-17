package com.vicilanaya.cyf.log;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LogFormatter extends Formatter {

    @SuppressWarnings("deprecation")
	@Override
    public String format(LogRecord record) {
        return record.getThreadID()+"::"+record.getSourceClassName()+"::"
                +record.getSourceMethodName()+"::"
                +new Date(record.getMillis())+"::"
                +record.getMessage()+"\n";
    }
    
    
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

} // end Formatter class
