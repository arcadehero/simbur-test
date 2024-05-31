package com.simbirsoft.testtask.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.simbirsoft.testtask.util.DateFormatterHelper;
import io.qameta.allure.Step;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.simbirsoft.testtask.util.DateFormatterHelper.changeDateFormat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.error.ShouldBe.shouldBe;

public class TransactionsPage {

    private SelenideElement transactionsTable = $("table.table");

    private SelenideElement dateTimeFirstTransaction = $("#anchor0 > :nth-child(1)");
    private SelenideElement amountFirstTransaction = $("#anchor0 > :nth-child(2)");
    private SelenideElement transactionTypeFirstTransaction = $("#anchor0 > :nth-child(3)");

    private SelenideElement dateTimeSecondTransaction = $("#anchor1 > :nth-child(1)");
    private SelenideElement amountSecondTransaction = $("#anchor1 > :nth-child(2)");
    private SelenideElement transactionTypeSecondTransaction = $("#anchor1 > :nth-child(3)");


    @Step("Verify transactions page is opened")
    public TransactionsPage verifyTransactionsPageIsOpened() {
        Selenide.sleep(2000);
        assertThat(transactionsTable.shouldBe(visible).isDisplayed()).isTrue();
        return this;
    }

    @Step("Verify credit transaction is shown")
    public TransactionsPage verifyCreditTransactionIsShown() {
        assertThat(transactionTypeFirstTransaction.shouldBe(visible).getText()).isEqualTo("Credit");
        return this;
    }

    @Step("Verify debit transaction is shown")
    public TransactionsPage verifyDebidTransactionIsShown() {
        assertThat(transactionTypeSecondTransaction.shouldBe(visible).getText()).isEqualTo("Debit");
        return this;
    }

    public List<String> parseTableForData() {
        String firstTransactionData = String.join(" ",
                changeDateFormat(dateTimeFirstTransaction.shouldBe(visible).getText()),
                amountFirstTransaction.shouldBe(visible).getText(),
                transactionTypeFirstTransaction.shouldBe(visible).getText());

        String secondTransactionData = String.join(" ",
                changeDateFormat(dateTimeSecondTransaction.shouldBe(visible).getText()),
                amountSecondTransaction.shouldBe(visible).getText(),
                transactionTypeSecondTransaction.shouldBe(visible).getText());

        return Arrays.asList(firstTransactionData, secondTransactionData);

    }
}
