package com.example.springboot.util;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import com.example.sprintboot.model.CSVUser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 25/09/17.
 */
public class OpenCSVReadAndParseToBean {
    //private static final String SAMPLE_CSV_FILE_PATH = "src/main/resources/csv/users-with-header.csv";

    public static ArrayList<String> parseCSV(final String csvFilePath) throws IOException {
    	ArrayList<String> csvFileNames = new ArrayList<String>();
        try (
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
        ) {
            CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVUser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<CSVUser> csvUserIterator = csvToBean.iterator();

            while (csvUserIterator.hasNext()) {
                CSVUser csvUser = csvUserIterator.next();
                csvFileNames.add(csvUser.getName());
                System.out.println("Name : " + csvUser.getName());
                System.out.println("Email : " + csvUser.getEmail());
                System.out.println("PhoneNo : " + csvUser.getPhoneNo());
                System.out.println("Country : " + csvUser.getCountry());
                System.out.println("==========================");
            }
        }
        return csvFileNames;
    }

    // Reads all CSV contents into memory (Not suitable for large CSV files)
    private static void readAllBeansAtOnce(CsvToBean csvToBean) {
        List<CSVUser> csvUsers = csvToBean.parse();

        for(CSVUser csvUser: csvUsers) {
            System.out.println("Name : " + csvUser.getName());
            System.out.println("Email : " + csvUser.getEmail());
            System.out.println("PhoneNo : " + csvUser.getPhoneNo());
            System.out.println("Country : " + csvUser.getCountry());
            System.out.println("==========================");
        }
    }
}


