package com.capgi.ipl;

import java.io.IOException;
import java.util.List;

import com.capgi.csvbuilder.CsvException;

public class IplLeagueAnalyser {

	public <E> List<E> loadIplData(String csvFilePath, Class<E> csvClass)
			throws IplLeagueAnalyserException, IOException, CsvException {
		return new CsvFileLoader().loadCsvData(csvFilePath, csvClass);
	}

	public String sortIplDataBasedOnCategory(List iplDataList, String category)
			throws IplLeagueAnalyserException, IOException, CsvException {
		DataSorter dataSorter = new DataSorter();
		switch (category) {
		case "battingAvg": {
			return dataSorter.highestBatAvg(iplDataList);
		}
		case "strikeRate": {
			return dataSorter.highestStrikeRate(iplDataList);
		}
		case "sixAndFours": {
			return dataSorter.highestNoOfSixAndFours(iplDataList);
		}
		case "highestStrikeRateAndMaxBoundaries": {
			return dataSorter.highestStrikeRateWithMaxBoundaries(iplDataList);
		}
		case "highestStrikeRateAndMaxAvg": {
			return dataSorter.highestStrikeRateAndMaxAvg(iplDataList);
		}
		case "MaxRunsAndMaxAvg": {
			return dataSorter.maxRunsAndMaxAvg(iplDataList);
		}
		case "MaxHundredAndBestAvg": {
			return dataSorter.maxHundredAndMaxAvg(iplDataList);
		}
		case "BestAvgWithoutZeroHundredAndFifty": {
			return dataSorter.maxAvgWithoutHundredAndFifty(iplDataList);
		}
		case "maxBowlingAvg": {
			return dataSorter.highestBowlingAvg(iplDataList);
		}
		case "bestBowlingStrikeRate": {
			return dataSorter.bestBowlingStrikeRate(iplDataList);
		}
		case "bestBowlingEconomy": {
			return dataSorter.bestBowlingEconomy(iplDataList);
		}
		case "bestBowlingStrikeRateWith4wAnd5w": {
			return dataSorter.bestBowlingStrikeRateWith4wAnd5w(iplDataList);
		}
		case "bestBowlingAvgAndStrikeRate": {
			return dataSorter.bestBowlingAvgAndStrikeRate(iplDataList);
		}
		case "highestWktsAndBestBowlingAvg": {
			return dataSorter.highestWktsAndBestBowlingAvg(iplDataList);
		}
		case "bestBowlingAndBattingAvg": {
			iplDataList = AllRounderPlayers.getAllRounderPlayers();
			return dataSorter.bestBowlingAndBattingAvgCricketer(iplDataList);
		}
		case "bestAllRounder": {
			iplDataList = AllRounderPlayers.getAllRounderPlayers();
			return dataSorter.bestAllRounder(iplDataList);
		}
		default: {
			System.out.println("Invalid choice!");
			return null;
		}
		}
	}
}
