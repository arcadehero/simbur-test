package com.simbirsoft.testtask.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomerLoginPage {

    private final SelenideElement loginButton = $x("//*[text()=\"Login\"]");

    private final SelenideElement dropDownList = $("#userSelect");
    private String chosenUser = "//*[text()=\"%s\"]";


    @Step("Click on drop down menu")
    public CustomerLoginPage clickOnDropDownMenu() {
        dropDownList.shouldBe(visible).click();
        return this;
    }

    @Step("Click on select user")
    public CustomerLoginPage selectUser(String user) {
        String selectedUser = String.format(chosenUser, user);
        $x(selectedUser).shouldBe(visible).shouldBe(clickable).click();
        return this;
    }
    @Step("Click on login button")
    public UserAccountPage clickOnLoginButton() {
        loginButton.shouldBe(visible).click();
        return Selenide.page(UserAccountPage.class);
    }
}
