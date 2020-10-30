package com.capgi.ipl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.capgi.csvbuilder.CsvException;
import com.google.gson.Gson;

public class IplLeagueAnalyserAllRounderStatsTest {
	private IplLeagueAnalyser iplLeagueAnalyser;
	List<AllRounder> allRounderStatsList;

	@Before
	public void initialize() throws IplLeagueAnalyserException, IOException, CsvException {
		iplLeagueAnalyser = new IplLeagueAnalyser();
	}

	@Test
	public void givenAllRounderDataShouldReturnBestBowlAndBatAvgCricketer()
			throws IplLeagueAnalyserException, IOException, CsvException {

		String sortedRunsData = iplLeagueAnalyser.sortIplDataBasedOnCategory(allRounderStatsList,
				"bestBowlingAndBattingAvg");
		AllRounder[] allRounderCsv = new Gson().fromJson(sortedRunsData, AllRounder[].class);
		assertEquals("Krishnappa Gowtham", allRounderCsv[0].getPlayer());
	}

	@Test
	public void givenMostRunsDataShouldReturnBestAllRounder()
			throws IplLeagueAnalyserException, IOException, CsvException {

		String sortedRunsData = iplLeagueAnalyser.sortIplDataBasedOnCategory(allRounderStatsList, "bestAllRounder");
		AllRounder[] allRounderCsv = new Gson().fromJson(sortedRunsData, AllRounder[].class);
		assertEquals("Andre Russell", allRounderCsv[0].getPlayer());
	}

}
