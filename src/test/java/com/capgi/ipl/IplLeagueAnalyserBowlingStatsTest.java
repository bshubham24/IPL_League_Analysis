package com.capgi.ipl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.capgi.csvbuilder.CsvException;
import com.google.gson.Gson;

public class IplLeagueAnalyserBowlingStatsTest {
	public static final String BOWLING_STATS_PATH = "F:\\Capgemini_training1\\java_eclipse\\IplLeagueAnalysis\\IPL2019FactsheetMostWkts.csv";
	private IplLeagueAnalyser iplLeagueAnalyser;
	List<Bowling> bowlingStatsList;

	@Before
	public void initialize() throws IplLeagueAnalyserException, IOException, CsvException {
		iplLeagueAnalyser = new IplLeagueAnalyser();
		bowlingStatsList = iplLeagueAnalyser.loadIplData(BOWLING_STATS_PATH, Bowling.class);

	}

	@Test
	public void givenBowlingStatsShouldReturnHighestBowlingAvgCricketer()
			throws IplLeagueAnalyserException, IOException, CsvException {

		String sortedRunsData = iplLeagueAnalyser.sortIplDataBasedOnCategory(bowlingStatsList, "maxBowlingAvg");
		Bowling[] bowlingCsv = new Gson().fromJson(sortedRunsData, Bowling[].class);
		assertEquals("Krishnappa Gowtham", bowlingCsv[0].getPlayer());
	}

	@Test
	public void givenBowlingStatsShouldReturnHighestBowlingStrikeRateCricketer()
			throws IplLeagueAnalyserException, IOException, CsvException {

		String sortedRunsData = iplLeagueAnalyser.sortIplDataBasedOnCategory(bowlingStatsList, "bestBowlingStrikeRate");
		Bowling[] bowlingCsv = new Gson().fromJson(sortedRunsData, Bowling[].class);
		assertEquals("Krishnappa Gowtham", bowlingCsv[0].getPlayer());
	}

	@Test
	public void givenBowlingStatsShouldReturnBestBowlingEconomyCricketer()
			throws IplLeagueAnalyserException, IOException, CsvException {

		String sortedRunsData = iplLeagueAnalyser.sortIplDataBasedOnCategory(bowlingStatsList, "bestBowlingEconomy");
		Bowling[] bowlingCsv = new Gson().fromJson(sortedRunsData, Bowling[].class);
		assertEquals("Shivam Dube", bowlingCsv[0].getPlayer());
	}

	@Test
	public void givenBowlingStatsShouldReturnHighestBowlingStrikeRateAndMax4wAnd5wCricketer()
			throws IplLeagueAnalyserException, IOException, CsvException {

		String sortedRunsData = iplLeagueAnalyser.sortIplDataBasedOnCategory(bowlingStatsList,
				"bestBowlingStrikeRateWith4wAnd5w");
		Bowling[] bowlingCsv = new Gson().fromJson(sortedRunsData, Bowling[].class);
		assertEquals("Krishnappa Gowtham", bowlingCsv[0].getPlayer());
	}

	@Test
	public void givenBowlingStatsShouldReturnHighestBowlingAvgAndStrikeRateCricketer()
			throws IplLeagueAnalyserException, IOException, CsvException {

		String sortedRunsData = iplLeagueAnalyser.sortIplDataBasedOnCategory(bowlingStatsList,
				"bestBowlingAvgAndStrikeRate");
		Bowling[] bowlingCsv = new Gson().fromJson(sortedRunsData, Bowling[].class);
		assertEquals("Krishnappa Gowtham", bowlingCsv[0].getPlayer());
	}

	@Test
	public void givenBowlingStatsShouldReturnHighestWicketsAndAvgCricketer()
			throws IplLeagueAnalyserException, IOException, CsvException {

		String sortedRunsData = iplLeagueAnalyser.sortIplDataBasedOnCategory(bowlingStatsList,
				"highestWktsAndBestBowlingAvg");
		Bowling[] bowlingCsv = new Gson().fromJson(sortedRunsData, Bowling[].class);
		assertEquals("Imran Tahir", bowlingCsv[0].getPlayer());
	}
}
