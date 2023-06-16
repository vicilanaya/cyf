package com.vicilanaya.cyf.components;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

public class LogEntry {

	private LocalDateTime timeStamp = null;
	// https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html
	// https://www.javatpoint.com/java-localdatetime
	private char[] cipherKey = null;
	private String originalMessage = null;
	private String encipheredMessage = null;
	private String decipheredMessage = null;
	private String error = null;

	public LogEntry(char[] cipherKey, String originalMessage, String encipheredMessage, String decipheredMessage,
			String error) {
		setTimeStamp();
		setCipherKey(cipherKey);
		setOriginalMessage(originalMessage);
		setEncipheredMessage(encipheredMessage);
		setDecipheredMessage(decipheredMessage);
		setError(error);
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp() {
		this.timeStamp = LocalDateTime.now();
		;
	}

	public char[] getCipherKey() {
		return cipherKey;
	}

	public void setCipherKey(char[] cipherKey) {
		this.cipherKey = cipherKey;
	}

	public String getOriginalMessage() {
		return originalMessage;
	}

	public void setOriginalMessage(String originalMessage) {
		this.originalMessage = originalMessage;
	}

	public String getEncipheredMessage() {
		return encipheredMessage;
	}

	public void setEncipheredMessage(String encipheredMessage) {
		this.encipheredMessage = encipheredMessage;
	}

	public String getDecipheredMessage() {
		return decipheredMessage;
	}

	public void setDecipheredMessage(String decipheredMessage) {
		this.decipheredMessage = decipheredMessage;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "[TIME_STAMP=" + getTimeStamp() + "] [CIPHER_KEY=" + Arrays.toString(getCipherKey())
				+ "] [ORIGINAL_MESSAGE=" + getOriginalMessage() + "] [ENCIPHERED_MESSAGE=" + getEncipheredMessage()
				+ "] [DECIPHERED_MESSAGE=" + getDecipheredMessage() + "] [ERROR=" + getError() + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogEntry logEntry = new LogEntry("FLORENCE".toCharArray(), "originalMessage1", "encipheredMessage1",
				"decipheredMessage1", "error1");

	} // end main method

} // end LogEntry class
