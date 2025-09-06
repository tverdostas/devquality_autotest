package tests;

import com.codeborne.selenide.*;
import enums.MiddleMenu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pages.MainPage;

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
                openPage().
                getMainHeaderButton().
                checkMainHeaderButton();
    }

/*    @ParameterizedTest
    @EnumSource(MiddleMenu.class)
    void allButtonsInMiddleMenuIsVisibleTest(MiddleMenu middleMenu) {
        open("https://tatarstan.mts.ru/personal");

        ElementsCollection elements = $$x("//div[@class='navigation-menu-slider__container']/descendant::h3[text()='" + middleMenu.getDisplayName() + "' and @class='navigation-menu-card__title']");
        elements.filter(visible);
    }*/

    @ParameterizedTest
    @EnumSource(MiddleMenu.class)
    void allButtonsInMiddleMenuIsVisibleWithAssertionTest(MiddleMenu middleMenu) {
        mainPage.
                openPage().
                verifyMenuItemIsVisible(middleMenu.getDisplayName());
    }

    @Test
    void modalWindowPersonalAccountHaveCorrectHeaderTest(){
        mainPage.
                openPage().
        clickSignInButton().
        mainHeaderIsVisible();
    }
/*    @Test
    void modalWindowReplenishmentOfBalanceHaveCorrectHeaderTest(){
        open("https://tatarstan.mts.ru/personal");
        $x("//span[contains(@class,'mm-web-button__label') and text()='Пополнить']").click();
        $x("//h2[text()='Личные кабинеты']");
  }*/

    @Test
    void fieldWithPhoneNumberInBalanceHaveCorrectPlaceholderTest(){
        mainPage.
                openPage().
                phoneNumberInReplenishmentOfBalanceHaveCorrectPlaceholder();
    }

    @Test
    void fieldWithPhoneNumberMoveToMtsHaveCorrectPlaceholderTest(){
        mainPage.
                openPage().
                phoneNumberInMoveToMtsBlockHaveCorrectPlaceholder();
    }

    @Test
    void submitButtonIsDisabledForEmptyMoveToMtsTest(){
/*        SelenideElement submitButton = $x("//span[text()='Перейти в МТС']/ancestor::button[@type='submit']");

        open("https://tatarstan.mts.ru/personal");
        submitButton.click();
        submitButton.shouldHave(attribute("disabled", ""));*/

        mainPage.
                openPage().
                submitButtonMoveToMtsClick().
                submitButtonMoveToMtsCheckIsDisabled();
    }
}
