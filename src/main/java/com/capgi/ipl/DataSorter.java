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
		final Comparator<Object> strikeRateAndBoundaries = Comparator.comparing(bat -> ((Batting) bat).getStrikeRate())
				.thenComparing(bat -> ((Batting) bat).getNoOfFours() + ((Batting) bat).getNoOfSixes());
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

	public String maxHundredAndMaxAvg(List<Batting> runsList) throws IplLeagueAnalyserException {
		if (runsList == null || runsList.size() == 0)
			throw new IplLeagueAnalyserException("No Code Data", ExceptionType.NO_DATA);
		final Comparator<Object> runsAndAvg = Comparator.comparing(bat -> ((Batting) bat).getCentury())
				.thenComparing(bat -> ((Batting) bat).getAverage());
		List<Batting> sortedList = runsList.stream().sorted(runsAndAvg).collect(Collectors.toList());
		Collections.reverse(sortedList);
		String sortedRunsDataJson = new Gson().toJson(sortedList);
		System.out.println(sortedRunsDataJson);
		return sortedRunsDataJson;
	}

	public String highestBowlingAvg(List<Bowling> bowlList) throws IplLeagueAnalyserException {
		if (bowlList == null || bowlList.size() == 0)
			throw new IplLeagueAnalyserException("No Code Data", ExceptionType.NO_DATA);
		List<Bowling> sortedList = bowlList.stream().sorted(Comparator.comparing(bowl -> bowl.getAverage()))
				.collect(Collectors.toList());
		Collections.reverse(sortedList);
		String sortedRunsDataJson = new Gson().toJson(sortedList);
		return sortedRunsDataJson;

	}

	public String bestBowlingStrikeRate(List<Bowling> bowlList) throws IplLeagueAnalyserException {
		if (bowlList == null || bowlList.size() == 0)
			throw new IplLeagueAnalyserException("No Code Data", ExceptionType.NO_DATA);
		List<Bowling> sortedList = bowlList.stream().sorted(Comparator.comparing(bowl -> bowl.getStrikeRate()))
				.collect(Collectors.toList());
		Collections.reverse(sortedList);
		String sortedRunsDataJson = new Gson().toJson(sortedList);
		return sortedRunsDataJson;

	}

	public String bestBowlingEconomy(List<Bowling> bowlList) throws IplLeagueAnalyserException {
		if (bowlList == null || bowlList.size() == 0)
			throw new IplLeagueAnalyserException("No Code Data", ExceptionType.NO_DATA);
		List<Bowling> sortedList = bowlList.stream().sorted(Comparator.comparing(bowl -> bowl.getEconomy()))
				.collect(Collectors.toList());
		String sortedRunsDataJson = new Gson().toJson(sortedList);
		return sortedRunsDataJson;

	}

	public String bestBowlingStrikeRateWith4wAnd5w(List<Bowling> bowlList) throws IplLeagueAnalyserException {
		if (bowlList == null || bowlList.size() == 0)
			throw new IplLeagueAnalyserException("No Code Data", ExceptionType.NO_DATA);
		final Comparator<Object> strikeRateAnd4N5WicketHauls = Comparator
				.comparing(bowl -> ((Bowling) bowl).getStrikeRate())
				.thenComparing(bowl -> ((Bowling) bowl).getFourWickets() + ((Bowling) bowl).getFiveWickets());
		List<Bowling> sortedList = bowlList.stream().sorted(strikeRateAnd4N5WicketHauls).collect(Collectors.toList());
		Collections.reverse(sortedList);
		String sortedRunsDataJson = new Gson().toJson(sortedList);
		return sortedRunsDataJson;

	}

	public String bestBowlingAvgAndStrikeRate(List<Bowling> bowlList) throws IplLeagueAnalyserException {
		if (bowlList == null || bowlList.size() == 0)
			throw new IplLeagueAnalyserException("No Code Data", ExceptionType.NO_DATA);
		final Comparator<Object> bowlAvgAndStrikeRate = Comparator.comparing(bowl -> ((Bowling) bowl).getAverage())
				.thenComparing(bowl -> ((Bowling) bowl).getStrikeRate());
		List<Bowling> sortedList = bowlList.stream().sorted(bowlAvgAndStrikeRate).collect(Collectors.toList());
		Collections.reverse(sortedList);
		String sortedRunsDataJson = new Gson().toJson(sortedList);
		return sortedRunsDataJson;

	}

	public String highestWktsAndBestBowlingAvg(List<Bowling> bowlList) throws IplLeagueAnalyserException {
		if (bowlList == null || bowlList.size() == 0)
			throw new IplLeagueAnalyserException("No Code Data", ExceptionType.NO_DATA);
		final Comparator<Object> highestWktsAndBestBowlAvg = Comparator
				.comparing(bowl -> ((Bowling) bowl).getNoOfWickets())
				.thenComparing(bowl -> ((Bowling) bowl).getAverage());
		List<Bowling> sortedList = bowlList.stream().sorted(highestWktsAndBestBowlAvg).collect(Collectors.toList());
		Collections.reverse(sortedList);
		String sortedRunsDataJson = new Gson().toJson(sortedList);
		return sortedRunsDataJson;

	}

	public String bestBowlingAndBattingAvgCricketer(List<AllRounder> allRounderList) throws IplLeagueAnalyserException {
		if (allRounderList.size() == 0)
			throw new IplLeagueAnalyserException("No Code Data", ExceptionType.NO_DATA);
		List<AllRounder> sortedList = allRounderList.stream()
				.sorted(Comparator.comparing(player -> player.getAverageRuns() + player.getAverageWickets()))
				.collect(Collectors.toList());
		Collections.reverse(sortedList);
		String sortedRunsDataJson = new Gson().toJson(sortedList);
		return sortedRunsDataJson;
	}

	public String bestAllRounder(List<AllRounder> allRounderList) throws IplLeagueAnalyserException {
		if (allRounderList.size() == 0)
			throw new IplLeagueAnalyserException("No Code Data", ExceptionType.NO_DATA);
		List<AllRounder> sortedList = allRounderList.stream()
				.sorted(Comparator.comparing(player -> player.getRuns() + player.getWickets()))
				.collect(Collectors.toList());
		Collections.reverse(sortedList);
		String sortedRunsDataJson = new Gson().toJson(sortedList);
		return sortedRunsDataJson;
	}

}
