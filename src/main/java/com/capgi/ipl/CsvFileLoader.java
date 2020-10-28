package com.capgi.ipl;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.capgi.csvbuilder.CsvBuilderFactory;
import com.capgi.csvbuilder.CsvException;
import com.capgi.csvbuilder.ICSVBuilder;
import com.capgi.ipl.IplLeagueAnalyserException.ExceptionType;

public class CsvFileLoader<E> {
	List<E> iplDataList = null;

	public List<E> loadCsvData(String csvFile, Class<E> csvClass)
			throws IplLeagueAnalyserException, IOException, CsvException {
		if (!csvFile.contains(".csv")) {
			throw new IplLeagueAnalyserException("Incorrect csv file", ExceptionType.IncorrectCsvFile);
		}
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFile));) {
			ICSVBuilder<E> csvBuilder = CsvBuilderFactory.createCSVBuilder();
			iplDataList = csvBuilder.getCsvBeanList(reader, csvClass);
			return iplDataList;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		} catch (RuntimeException e) {
			throw new IplLeagueAnalyserException("File data not correct", ExceptionType.IncorrectData);
		} catch (CsvException e) {
			throw new CsvException("Unable to parse", CsvException.ExceptionType.UNABLE_TO_PARSE);
		}
	}
}
