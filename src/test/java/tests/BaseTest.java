package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    @BeforeAll
    static void browserConfigurations(){
        Configuration.baseUrl = "https://tatarstan.mts.ru/personal";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 40000;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-setuid-sandbox");

        options.addArguments("--disable-application-cache");
        options.addArguments("--enable-do-not-track");
        options.addArguments("--disable-popup-blocking");

        Configuration.browserCapabilities = options;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }

    @AfterEach
    public void closeWebDriver(){
        Selenide.closeWebDriver();
    }
}
