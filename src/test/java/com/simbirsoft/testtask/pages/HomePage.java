package com.simbirsoft.testtask.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePage extends BasePage {

    private final SelenideElement customerLoginButton = $x("//*[text()=\"Customer Login\"]");

    private final SelenideElement bankManagerLoginButton = $x("//*[text()=\"Bank Manager Login\"]");


    @Step("Verify home page is opened")
    public HomePage verifyHomePageIsOpened() {
        assertThat(Selenide.title()).isEqualTo("XYZ Bank");
        return this;
    }

    @Step("Click on customer login button")
    public CustomerLoginPage clickOnCustomerLoginButton() {
        customerLoginButton.shouldBe(visible).click();
        return new CustomerLoginPage();
    }
}
