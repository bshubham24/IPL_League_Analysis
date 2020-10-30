package com.capgi.ipl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.capgi.csvbuilder.CsvException;

public class AllRounderPlayers {
	public static List<AllRounder> getAllRounderPlayers() throws IplLeagueAnalyserException, IOException, CsvException {
		String BATTING_STATS_PATH = "F:\\Capgemini_training1\\java_eclipse\\IplLeagueAnalysis\\IPL2019FactsheetMostRuns.csv";
		String BOWLING_STATS_PATH = "F:\\Capgemini_training1\\java_eclipse\\IplLeagueAnalysis\\IPL2019FactsheetMostWkts.csv";
		IplLeagueAnalyser iplLeagueAnalyser = new IplLeagueAnalyser();
		List<Batting> battingList = iplLeagueAnalyser.loadIplData(BATTING_STATS_PATH, Batting.class);
		List<Bowling> bowlingList = iplLeagueAnalyser.loadIplData(BOWLING_STATS_PATH, Bowling.class);
		List<AllRounder> allRounderList = new ArrayList<>();
		battingList.stream().forEach(batsman -> {
			Bowling bowlers = bowlingList.stream()
					.filter(bowler -> bowler.getPlayer().equalsIgnoreCase(batsman.getPlayer())).findFirst()
					.orElse(null);
			if (bowlers != null) {
				allRounderList.add(new AllRounder(batsman.getPlayer(), batsman.getRuns(), bowlers.getNoOfWickets(),
						batsman.getAverage(), bowlers.getAverage()));
			}
		});
		return allRounderList;
	}
}
