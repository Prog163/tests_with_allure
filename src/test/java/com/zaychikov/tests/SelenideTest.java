package com.zaychikov.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    private final String Url = "https://github.com";
    private final String Directory = "Prog163/tests_with_allure";

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @AfterAll
    static void afterAll() {
        //Оставляю браузер открытым для проверки введённых значений
        Configuration.holdBrowserOpen = true;
//        Пришлось добавить, в фоновом режиме Chrome продолжал работать, CPU на 100% загружается
        Selenide.closeWebDriver();
    }

    @Test
    public void issueSearchTestInGithub() {
        open(Url);
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(Directory);
        $(".header-search-input").submit();
        $(linkText(Directory)).click();
        $("#issues-tab").shouldHave(text("Issues"));
    }
}
