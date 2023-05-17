package com.zaychikov.tests;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class StepsForAnnotationStepTest {

    @Step("Открыть сайт")
    public void openWebsiteUrl(String url) {
        open(url);
    }

    @Step("Выполнить поиск репозитория")
    public void searchRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Открыть найденный репозиторий")
    public void openRepository(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Проверить название колонки Issue в репозитории")
    public void checkColumnNameIssue() {
        $("#issues-tab").shouldHave(text("Issues"));
    }
}
