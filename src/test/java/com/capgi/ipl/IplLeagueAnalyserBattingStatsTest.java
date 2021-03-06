package com.capgi.ipl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.capgi.csvbuilder.CsvException;
import com.google.gson.Gson;

public class IplLeagueAnalyserBattingStatsTest {
	public static final String BATTING_STATS_PATH = "F:\\Capgemini_training1\\java_eclipse\\IplLeagueAnalysis\\IPL2019FactsheetMostRuns.csv";
	private IplLeagueAnalyser iplLeagueAnalyser;
	List<Batting> battingStatsList;

	@Before
	public void initialize() throws IplLeagueAnalyserException, IOException, CsvException {
		iplLeagueAnalyser = new IplLeagueAnalyser();
		battingStatsList = iplLeagueAnalyser.loadIplData(BATTING_STATS_PATH, Batting.class);

	}

	@Test
	public void givenMostRunsDataShouldReturnHighestBatAvgCricketer()
			throws IplLeagueAnalyserException, IOException, CsvException {

		String sortedRunsData = iplLeagueAnalyser.sortIplDataBasedOnCategory(battingStatsList, "battingAvg");
		Batting[] battingCsv = new Gson().fromJson(sortedRunsData, Batting[].class);
		assertEquals("MS Dhoni", battingCsv[0].getPlayer());
	}

	@Test
	public void givenMostRunsDataShouldReturnHighestStrikeRateCricketer()
			throws IplLeagueAnalyserException, IOException, CsvException {

		String sortedRunsData = iplLeagueAnalyser.sortIplDataBasedOnCategory(battingStatsList, "strikeRate");
		Batting[] battingCsv = new Gson().fromJson(sortedRunsData, Batting[].class);
		assertEquals("Ishant Sharma", battingCsv[0].getPlayer());
	}

	@Test
	public void givenMostRunsDataShouldReturnHighestSixAndFourScoringCricketer()
			throws IplLeagueAnalyserException, IOException, CsvException {

		String sortedRunsData = iplLeagueAnalyser.sortIplDataBasedOnCategory(battingStatsList, "sixAndFours");
		Batting[] battingCsv = new Gson().fromJson(sortedRunsData, Batting[].class);
		assertEquals("Andre Russell", battingCsv[0].getPlayer());
	}

	@Test
	public void givenMostRunsDataShouldReturnHighestStrikeRateAndMaxBoundariesCricketer()
			throws IplLeagueAnalyserException, IOException, CsvException {

		String sortedRunsData = iplLeagueAnalyser.sortIplDataBasedOnCategory(battingStatsList,
				"highestStrikeRateAndMaxBoundaries");
		Batting[] battingCsv = new Gson().fromJson(sortedRunsData, Batting[].class);
		assertEquals("Ishant Sharma", battingCsv[0].getPlayer());
	}

	@Test
	public void givenMostRunsDataShouldReturnHighestAverageAndBestStrikeRateCricketer()
			throws IplLeagueAnalyserException, IOException, CsvException {

		String sortedRunsData = iplLeagueAnalyser.sortIplDataBasedOnCategory(battingStatsList,
				"highestStrikeRateAndMaxAvg");
		Batting[] battingCsv = new Gson().fromJson(sortedRunsData, Batting[].class);
		assertEquals("MS Dhoni", battingCsv[0].getPlayer());
	}

	@Test
	public void givenMostRunsDataShouldReturnMaxRunsAndBestAverageCricketer()
			throws IplLeagueAnalyserException, IOException, CsvException {

		String sortedRunsData = iplLeagueAnalyser.sortIplDataBasedOnCategory(battingStatsList, "MaxRunsAndMaxAvg");
		Batting[] battingCsv = new Gson().fromJson(sortedRunsData, Batting[].class);
		assertEquals("David Warner", battingCsv[0].getPlayer());
	}

	@Test
	public void givenMostRunsDataShouldReturnMaxHundredAndBestAverageCricketer()
			throws IplLeagueAnalyserException, IOException, CsvException {

		String sortedRunsData = iplLeagueAnalyser.sortIplDataBasedOnCategory(battingStatsList, "MaxHundredAndBestAvg");
		Batting[] battingCsv = new Gson().fromJson(sortedRunsData, Batting[].class);
		assertEquals("David Warner", battingCsv[0].getPlayer());
	}

	@Test
	public void givenMostRunsDataShouldReturnBestAverageWithZeroHundredAndFiftyCricketer()
			throws IplLeagueAnalyserException, IOException, CsvException {

		String sortedRunsData = iplLeagueAnalyser.sortIplDataBasedOnCategory(battingStatsList,
				"BestAvgWithoutZeroHundredAndFifty");
		Batting[] battingCsv = new Gson().fromJson(sortedRunsData, Batting[].class);
		assertEquals("Marcus Stoinis", battingCsv[0].getPlayer());
	}
}
