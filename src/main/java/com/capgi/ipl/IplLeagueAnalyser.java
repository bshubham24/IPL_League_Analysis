package com.capgi.ipl;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.capgi.csvbuilder.CsvBuilderFactory;
import com.capgi.csvbuilder.CsvException;
import com.capgi.csvbuilder.ICSVBuilder;
import com.capgi.ipl.IplLeagueAnalyserException.ExceptionType;
import com.google.gson.Gson;

public class IplLeagueAnalyser {
	List<Batting> runsList = null;

	public int loadRunsData(String csvFile) throws IplLeagueAnalyserException, IOException, CsvException {
		if (!csvFile.contains(".csv")) {
			throw new IplLeagueAnalyserException("Incorrect csv file", ExceptionType.IncorrectCsvFile);
		}
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFile));) {
			ICSVBuilder<Batting> csvBuilder = CsvBuilderFactory.createCSVBuilder();
			runsList = csvBuilder.getCsvBeanList(reader, Batting.class);
			int noOfEntries = runsList.size();
			return noOfEntries;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return 0;
		} catch (RuntimeException e) {
			throw new IplLeagueAnalyserException("File data not correct", ExceptionType.IncorrectData);
		} catch (CsvException e) {
			throw new CsvException("Unable to parse", CsvException.ExceptionType.UNABLE_TO_PARSE);
		}
	}

	public String highestBatAvg() throws IplLeagueAnalyserException {
		if (runsList == null || runsList.size() == 0)
			throw new IplLeagueAnalyserException("No Code Data", ExceptionType.NO_DATA);
		List<Batting> sortedList = runsList.stream().sorted(Comparator.comparing(code -> code.getAverage()))
				.collect(Collectors.toList());
		Collections.reverse(sortedList);
		String sortedRunsDataJson = new Gson().toJson(sortedList);
		return sortedRunsDataJson;

	}
}
