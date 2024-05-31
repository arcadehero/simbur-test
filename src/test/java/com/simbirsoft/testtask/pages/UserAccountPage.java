package com.simbirsoft.testtask.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class UserAccountPage {

    private SelenideElement transactions = $("button[ng-class=\"btnClass1\"]");
    private SelenideElement deposit = $("button[ng-class=\"btnClass2\"]");
    private SelenideElement withdrawal = $("button[ng-class=\"btnClass3\"]");
    private SelenideElement placeholder = $("input[placeholder=amount]");
    private SelenideElement submitButton = $("button[type=submit]");
    private SelenideElement notificationMessage = $("span[ng-show=message]");
    private SelenideElement balance = $("div.borderM > :nth-child(3) > :nth-child(2)");

    @Step("Click user account page is opened")
    public UserAccountPage verifyUserAccountPageIsOpened() {
        assertThat(transactions.shouldBe(visible).isDisplayed()).isTrue();
        return this;
    }

    @Step("Click on deposit button")
    public UserAccountPage clickOnDepositButton() {
        deposit.shouldBe(visible).click();
        return this;
    }

    @Step("Insert amount")
    public UserAccountPage insertAmount(String amount) {
        Selenide.sleep(2000);
        placeholder.shouldBe(clickable).click();
        placeholder.sendKeys(amount);
        return this;
    }

    @Step("Click on on deposit submit button")
    public UserAccountPage clickDepositSubmitButton() {
        submitButton.shouldBe(visible).click();
        return this;
    }

    @Step("Verify successful notification message is shown")
    public UserAccountPage verifySuccessfulNotificationMessageIsShown(String message) {
        assertThat(notificationMessage.shouldBe(visible).getText()).isEqualTo(message);
        return this;
    }

    @Step("Click on withdrawal button")
    public UserAccountPage clickOnWithdrawalButton() {
        withdrawal.shouldBe(visible).click();
        return this;
    }

    @Step("Click on withdrawal submit button")
    public UserAccountPage clickWithdrawalSubmitButton() {
        submitButton.shouldBe(visible).click();
        return this;

    }

    @Step("Verify balance is 0")
    public UserAccountPage verifyBalanceForZeroAmount() {
        Selenide.sleep(2000);
        assertThat(balance.shouldBe(visible).getText()).isEqualTo(String.valueOf(0));
        return this;
    }

    @Step("Click on tranactions button")
    public TransactionsPage clickOnTransactionsButton() {
        transactions.shouldBe(visible).click();
        return Selenide.page(TransactionsPage.class);
    }
}
