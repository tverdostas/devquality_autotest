package tests;

import enums.MiddleMenu;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pages.MainPage;

@Execution(ExecutionMode.SAME_THREAD)
public class MainPageTests extends BaseTest {

    MainPage mainPage = new MainPage();
    @Test
    void startPageIsPersonalClientsTest() {
        mainPage
                .openPage()
                .getMainHeaderButton()
                .checkMainHeaderButton();
    }

    @ParameterizedTest
    @EnumSource(MiddleMenu.class)
    void allButtonsInMiddleMenuIsVisibleWithAssertionTest(MiddleMenu middleMenu) {
        mainPage
                .openPage()
                .verifyMenuItemIsVisible(middleMenu.getDisplayName());
    }

    @Test
    void modalWindowPersonalAccountHaveCorrectHeaderTest(){
        mainPage
                .openPage()
                .clickSignInButton()
                .mainHeaderIsVisible();
    }

    @Test
    void fieldWithPhoneNumberInBalanceHaveCorrectPlaceholderTest(){
        mainPage
                .openPage()
                .phoneNumberInReplenishmentOfBalanceHaveCorrectPlaceholder();
    }

    @Test
    void fieldWithPhoneNumberMoveToMtsHaveCorrectPlaceholderTest(){
        mainPage
                .openPage()
                .phoneNumberInMoveToMtsBlockHaveCorrectPlaceholder();
    }

    @Test
    void submitButtonIsDisabledForEmptyMoveToMtsTest(){
        mainPage
                .openPage()
                .submitButtonMoveToMtsClick()
                .submitButtonMoveToMtsCheckIsDisabled();
    }
}
