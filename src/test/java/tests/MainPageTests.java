package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.MiddleMenu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pages.MainPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class MainPageTests {
    @BeforeAll
    static void browserConfigurations(){
        Configuration.baseUrl = "https://tatarstan.mts.ru/personal";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    @AfterEach
    public void closeWebDriver(){
        Selenide.closeWebDriver();
    }

    MainPage mainPage = new MainPage();
    @Test
    void startPageIsPersonalClientsTest() {
        mainPage.
                openPage()
                .getMainHeaderButton()
                .checkMainHeaderButton();
    }

    @ParameterizedTest
    @EnumSource(MiddleMenu.class)
    void allButtonsInMiddleMenuIsVisibleTest(MiddleMenu middleMenu) {
        open("https://tatarstan.mts.ru/personal");
        ElementsCollection selenideElements = $$x("//div[@class='navigation-menu-slider__container']/descendant::h3[text()='" + middleMenu.getDisplayName() + "' and @class='navigation-menu-card__title']").shouldBe(visible);
    }
    @Test
    void modalWindowPersonalAccountHaveCorrectHeaderTest(){
        open("https://tatarstan.mts.ru/personal");
        $x("//span[@class='mm-web-button__label' and text()='Войти']").click();
        $x("//h2[@class='mts-universal-modal__title']").shouldHave(text("Личные кабинеты"));
    }
    @Test
    void modalWindowReplenishmentOfBalanceHaveCorrectHeaderTest(){
        open("https://tatarstan.mts.ru/personal");
        $x("//span[contains(@class,'mm-web-button__label') and text()='Пополнить']").click();
  }

    @Test
    void fieldWithPhoneNumberInBalanceHaveCorrectPlaceholderTest(){
        open("https://tatarstan.mts.ru/personal");
        $x("//input[@name='phone']").shouldHave(attribute("placeholder", "XXX XXX-XX-XX"));
    }

    @Test
    void fieldWithPhoneNumberMoveToMtsHaveCorrectPlaceholderTest(){
        open("https://tatarstan.mts.ru/personal");
        $x("//input[@formcontrolname='phone']").shouldHave(attribute("placeholder", "XXX XXX-XX-XX"));
    }

    @Test
    void errorTextIsCorrectForEmptyMoveToMtsTest(){
        SelenideElement submitButton = $x("//span[text()='Перейти в МТС']/ancestor::button[@type='submit']");

        open("https://tatarstan.mts.ru/personal");
        submitButton.click();
        submitButton.shouldHave(attribute("disabled", ""));
    }
}
