package com.example.springboot.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.util.OpenCSVReadAndParseToBean;
import com.example.springboot.util.UnzipFile;
import com.example.springboot.util.UnzipUtility;

@RestController
public class HelloController {

	@RequestMapping("/unzip")
	public ArrayList<String> index() {
		final String zipFilePath = "src/main/resources/compressed.zip";
		final String destDir = "src/main/resources";
		ArrayList<String> filenames = new ArrayList<>();
		try {
			//UnzipFile.unzip(zipFilePath, destDir);
			filenames = UnzipUtility.unzip(zipFilePath, destDir);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return filenames;
	}
	
	@RequestMapping("/readcsv")
	public  ArrayList<String> readCSV() {
		ArrayList<String> csvFilenames = new ArrayList<>();
		final String SAMPLE_CSV_FILE_PATH = "src/main/resources/csv/users-with-header.csv";
		try {
			//OpenCSVReadAndParseToBean.parseCSV(SAMPLE_CSV_FILE_PATH);
			csvFilenames = OpenCSVReadAndParseToBean.parseCSV(SAMPLE_CSV_FILE_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return csvFilenames;
	}
	
	@RequestMapping("/missingfiles")
	public  ArrayList<String> missingFiles() {
		ArrayList<String> csvFilenames = new ArrayList<>();
		ArrayList<String> filenames = new ArrayList<>();
		final String zipFilePath = "src/main/resources/compressed.zip";
		final String destDir = "src/main/resources";
		final String SAMPLE_CSV_FILE_PATH = "src/main/resources/csv/users-with-header.csv";
		try {
			//OpenCSVReadAndParseToBean.parseCSV(SAMPLE_CSV_FILE_PATH);
			csvFilenames = OpenCSVReadAndParseToBean.parseCSV(SAMPLE_CSV_FILE_PATH);
			filenames = UnzipUtility.unzip(zipFilePath, destDir);
			//remove all elements from second list
			csvFilenames.removeAll(filenames);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return csvFilenames;
	}

	
}
