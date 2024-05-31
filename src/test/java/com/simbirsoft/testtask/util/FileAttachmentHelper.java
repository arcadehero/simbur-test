package com.simbirsoft.testtask.util;

import io.qameta.allure.Attachment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileAttachmentHelper {

    @Attachment(value = "CSV Attachment", type = "text/csv")
    public static byte[] attachCSVFileToAllureReport() throws IOException {
        String filePath = "src/test/resources/transactions.csv";
        return Files.readAllBytes(Paths.get(filePath));
    }
}
