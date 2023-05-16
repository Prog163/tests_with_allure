package com.zaychikov.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaStepTest {

    private final String Url = "https://github.com";
    private final String Directory = "Prog163/tests_with_allure";

    @Test
    public void issueSearchTestInGithubWithLambda() {
        step("Открыть сайт: " + Url, () -> {
            open(Url);
        });
        step("Выполнить поиск репозитория: " + Directory, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(Directory);
            $(".header-search-input").submit();
        });
        step("Открыть найденный репозиторий", () -> {
            $(linkText(Directory)).click();
        });
        step("Проверить название Issue в репозитории", () -> {
            $("#issues-tab").shouldHave(text("Issues"));
        });
    }
}
