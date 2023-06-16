package com.vicilanaya.cyf.components;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

public class LogEntry {

	private LocalDateTime TIME_STAMP = null; // https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html
	private char[] CIPHER_KEY = null;
	private String ORIGINAL_MESSAGE = null;
	private String ENCIPHERED_MESSAGE = null;
	private String DECIPHERED_MESSAGE = null;
	private String ERROR = null;

	public LogEntry(LocalDateTime timeStamp, char[] cipherKey, String originalMessage, String encipheredMessage,
			String decipheredMessage, String error) {
		setTimeStamp(timeStamp);
		setCipherKey(cipherKey);
		setOriginalMessage(originalMessage);
		setEncipheredMessage(encipheredMessage);
		setDecipheredMessage(decipheredMessage);
		setError(error);
	}

	public LocalDateTime getTimeStamp() {
		return TIME_STAMP;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.TIME_STAMP = timeStamp;
	}

	public char[] getCipherKey() {
		return CIPHER_KEY;
	}

	public void setCipherKey(char[] cipherKey) {
		this.CIPHER_KEY = cipherKey;
	}

	public String getOriginalMessage() {
		return ORIGINAL_MESSAGE;
	}

	public void setOriginalMessage(String originalMessage) {
		this.ORIGINAL_MESSAGE = originalMessage;
	}

	public String getEncipheredMessage() {
		return ENCIPHERED_MESSAGE;
	}

	public void setEncipheredMessage(String encipheredMessage) {
		this.ENCIPHERED_MESSAGE = encipheredMessage;
	}

	public String getDecipheredMessage() {
		return DECIPHERED_MESSAGE;
	}

	public void setDecipheredMessage(String decipheredMessage) {
		this.DECIPHERED_MESSAGE = decipheredMessage;
	}

	public String getError() {
		return ERROR;
	}

	public void setError(String error) {
		this.ERROR = error;
	}

	@Override
	public String toString() {
		return "[TIME_STAMP=" + getTimeStamp() + "] [CIPHER_KEY=" + Arrays.toString(getCipherKey())
				+ "] [ORIGINAL_MESSAGE=" + getOriginalMessage() + "] [ENCIPHERED_MESSAGE=" + getEncipheredMessage()
				+ "] [DECIPHERED_MESSAGE=" + getDecipheredMessage() + "] [ERROR=" + getError() + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogEntry logEntry = new LogEntry(
				new LocalDateTime(new LocalDate(2023, 1, 23), new LocalTime(0, 0, 0, 0)), 
				['F', 'V', 'A'], "originalMessage1", "encipheredMessage1",
				"decipheredMessage1", "error1");

	} // end main method

} // end LogEntry class
