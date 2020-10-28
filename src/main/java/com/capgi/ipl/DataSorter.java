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
		List<Batting> sortedList = runsList.stream().sorted(Comparator.comparing(bat -> bat.getAverage()))
				.collect(Collectors.toList());
		Collections.reverse(sortedList);
		String sortedRunsDataJson = new Gson().toJson(sortedList);
		return sortedRunsDataJson;

	}

	public String highestStrikeRate(List<Batting> runsList) throws IplLeagueAnalyserException {
		if (runsList == null || runsList.size() == 0)
			throw new IplLeagueAnalyserException("No Code Data", ExceptionType.NO_DATA);
		List<Batting> sortedList = runsList.stream().sorted(Comparator.comparing(bat -> bat.getStrikeRate()))
				.collect(Collectors.toList());
		Collections.reverse(sortedList);
		String sortedRunsDataJson = new Gson().toJson(sortedList);
		return sortedRunsDataJson;

	}

	public String highestNoOfSixAndFours(List<Batting> runsList) throws IplLeagueAnalyserException {
		if (runsList == null || runsList.size() == 0)
			throw new IplLeagueAnalyserException("No Code Data", ExceptionType.NO_DATA);
		List<Batting> sortedList = runsList.stream()
				.sorted(Comparator.comparing(bat -> bat.getNoOfFours() + bat.getNoOfSixes()))
				.collect(Collectors.toList());
		Collections.reverse(sortedList);
		String sortedRunsDataJson = new Gson().toJson(sortedList);
		return sortedRunsDataJson;

	}

	public String highestStrikeRateWithMaxBoundaries(List<Batting> runsList) throws IplLeagueAnalyserException {
		if (runsList == null || runsList.size() == 0)
			throw new IplLeagueAnalyserException("No Code Data", ExceptionType.NO_DATA);
		final Comparator<Object> strikeRateAndBoundaries = Comparator
				.comparing(bat -> ((Batting) bat).getNoOfFours() + ((Batting) bat).getNoOfSixes())
				.thenComparing(bat -> ((Batting) bat).getStrikeRate());
		List<Batting> sortedList = runsList.stream().sorted(strikeRateAndBoundaries).collect(Collectors.toList());
		Collections.reverse(sortedList);
		String sortedRunsDataJson = new Gson().toJson(sortedList);
		return sortedRunsDataJson;
	}

	public String highestStrikeRateAndMaxAvg(List<Batting> runsList) throws IplLeagueAnalyserException {
		if (runsList == null || runsList.size() == 0)
			throw new IplLeagueAnalyserException("No Code Data", ExceptionType.NO_DATA);
		final Comparator<Object> strikeRateAndavg = Comparator.comparing(bat -> ((Batting) bat).getAverage())
				.thenComparing(bat -> ((Batting) bat).getStrikeRate());
		List<Batting> sortedList = runsList.stream().sorted(strikeRateAndavg).collect(Collectors.toList());
		Collections.reverse(sortedList);
		String sortedRunsDataJson = new Gson().toJson(sortedList);
		return sortedRunsDataJson;
	}

	public String maxRunsAndMaxAvg(List<Batting> runsList) throws IplLeagueAnalyserException {
		if (runsList == null || runsList.size() == 0)
			throw new IplLeagueAnalyserException("No Code Data", ExceptionType.NO_DATA);
		final Comparator<Object> runsAndAvg = Comparator.comparing(bat -> ((Batting) bat).getRuns())
				.thenComparing(bat -> ((Batting) bat).getAverage());
		List<Batting> sortedList = runsList.stream().sorted(runsAndAvg).collect(Collectors.toList());
		Collections.reverse(sortedList);
		String sortedRunsDataJson = new Gson().toJson(sortedList);
		return sortedRunsDataJson;
	}
}
