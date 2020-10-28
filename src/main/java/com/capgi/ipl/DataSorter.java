package com.capgi.ipl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.capgi.ipl.IplLeagueAnalyserException.ExceptionType;
import com.google.gson.Gson;

public class DataSorter {
	public String highestBatAvg(List<Batting> runsList) throws IplLeagueAnalyserException {
		if (runsList == null || runsList.size() == 0)
			throw new IplLeagueAnalyserException("No Code Data", ExceptionType.NO_DATA);
		List<Batting> sortedList = runsList.stream().sorted(Comparator.comparing(code -> code.getAverage()))
				.collect(Collectors.toList());
		Collections.reverse(sortedList);
		String sortedRunsDataJson = new Gson().toJson(sortedList);
		return sortedRunsDataJson;

	}
}
