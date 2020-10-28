package com.capgi.ipl;

public class IplLeagueAnalyserException extends Exception {
	enum ExceptionType {
		IncorrectCsvFile, IncorrectData, NO_DATA, InvalidClass;
	}

	ExceptionType type;

	public IplLeagueAnalyserException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}
}
