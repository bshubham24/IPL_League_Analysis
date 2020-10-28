package com.capgi.ipl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.capgi.csvbuilder.CsvException;
import com.google.gson.Gson;

public class IplLeagueAnalyserMostRunsTest {
	public static final String BATTING_STATS_PATH = "F:\\Capgemini_training1\\java_eclipse\\IplLeagueAnalysis\\IPL2019FactsheetMostRuns.csv";
	private IplLeagueAnalyser iplLeagueAnalyser;

	@Before
	public void initialize() throws IplLeagueAnalyserException, IOException, CsvException {
		iplLeagueAnalyser = new IplLeagueAnalyser();
		iplLeagueAnalyser.loadRunsData(BATTING_STATS_PATH);
	}

	@Test
	public void givenMostRunsDataShouldReturnHighestBatAvgCricketer()
			throws IplLeagueAnalyserException, IOException, CsvException {
		String sortedRunsData = iplLeagueAnalyser.highestBatAvg();
		Batting[] battingCsv = new Gson().fromJson(sortedRunsData, Batting[].class);
		assertEquals("MS Dhoni", battingCsv[0].getPlayer());
	}
}
