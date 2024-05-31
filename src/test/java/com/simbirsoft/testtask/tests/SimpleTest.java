package com.simbirsoft.testtask.tests;

import com.simbirsoft.testtask.pages.HomePage;
import com.simbirsoft.testtask.pages.TransactionsPage;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static com.simbirsoft.testtask.util.CsvFileHelper.csvReportGenerator;
import static com.simbirsoft.testtask.util.FibonacciNumberGenerator.calculateFibonacciBasedOnCurrentMonth;
import static com.simbirsoft.testtask.util.FibonacciNumberGenerator.getRequiredNumberForTest;
import static com.simbirsoft.testtask.util.FileAttachmentHelper.attachCSVFileToAllureReport;

public class SimpleTest extends BaseTest {

    @Test
    public void simpleTest() throws IOException {
        String user = "Harry Potter";
        var amount = String.valueOf(calculateFibonacciBasedOnCurrentMonth(getRequiredNumberForTest()));

        new HomePage()
                .verifyHomePageIsOpened()
                .clickOnCustomerLoginButton()
                .clickOnDropDownMenu()
                .selectUser(user)
                .clickOnLoginButton()
                .verifyUserAccountPageIsOpened()
                .clickOnDepositButton()
                .insertAmount(amount)
                .clickDepositSubmitButton()
                .verifySuccessfulNotificationMessageIsShown("Deposit Successful")
                .clickOnWithdrawalButton()
                .insertAmount(amount)
                .clickWithdrawalSubmitButton()
                .verifySuccessfulNotificationMessageIsShown("Transaction successful")
                .verifyBalanceForZeroAmount()
                .clickOnTransactionsButton()
                .verifyTransactionsPageIsOpened()
                .verifyCreditTransactionIsShown()
                .verifyDebidTransactionIsShown();

        List<String> transactionsData = new TransactionsPage()
                .parseTableForData();

        csvReportGenerator(transactionsData);
        attachCSVFileToAllureReport();
    }
}
