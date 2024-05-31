package com.simbirsoft.testtask.util;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CsvFileHelper {

    public static void csvReportGenerator(List<String> data) throws IOException {
        String csvFilePath = "src/test/resources/transactions.csv";


        try (FileWriter fileWriter = new FileWriter(csvFilePath, StandardCharsets.UTF_8)) {
            fileWriter.write("\uFEFF");
            fileWriter.write("Дата-времяТранзакции Сумма ТипТранзакции");
            fileWriter.write("\n");
            for (String line : data){
                fileWriter.write(line);
                fileWriter.write("\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
