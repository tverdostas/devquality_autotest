package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement mainHeaderButton = $x("//a[@eventid='vntMtsCrossTopLinks' and contains(@class, 'is-active')]");
    private static final String SPECIFIC_MENU_ITEM_XPATH =
            "//div[@class='navigation-menu-slider__container']/descendant::h3[text()='%s' and @class='navigation-menu-card__title']";
    private final SelenideElement signInButton = $x("//span[@class='mm-web-button__label' and text()='Войти']");
    private final SelenideElement mainHeader = $x("//h2[@class='mts-universal-modal__title']");
    private final SelenideElement phoneNumber = $x("//input[@name='phone']");
    private final SelenideElement moveToMtsPhone = $x("//input[@formcontrolname='phone']");

    private final SelenideElement submitButtonInMoveToMtsBlock = $x("//span[text()='Перейти в МТС']/ancestor::button[@type='submit']");

    public MainPage mainHeaderIsVisible(){
        mainHeader.shouldHave(text("Личные кабинеты"));
        return this;
    }

    public MainPage clickSignInButton(){
        signInButton.click();
        return this;
    }
    public MainPage getMainHeaderButton(){
        return this;
    }

    public MainPage checkMainHeaderButton(){
        mainHeaderButton.shouldBe(visible);
        return this;
    }

    public MainPage openPage(){
        open("https://tatarstan.mts.ru/personal");
        return this;
    }

    public void verifyMenuItemIsVisible(String menuText) {
        ElementsCollection elements = getMenuItemsByText(menuText);
        elements.filter(visible);
    }

    public ElementsCollection getMenuItemsByText(String menuText) {
        String xpath = String.format(SPECIFIC_MENU_ITEM_XPATH, menuText);
        return $$x(xpath).filter(visible);
    }

    public MainPage phoneNumberInReplenishmentOfBalanceHaveCorrectPlaceholder() {
        phoneNumber.shouldHave(attribute("placeholder", "XXX XXX-XX-XX"));
        return this;
    }

    public MainPage phoneNumberInMoveToMtsBlockHaveCorrectPlaceholder() {
        moveToMtsPhone.shouldHave(attribute("placeholder", "XXX XXX-XX-XX"));
        return this;
    }

    public MainPage submitButtonMoveToMtsClick(){
        submitButtonInMoveToMtsBlock.click();
        return this;
    }

    public MainPage submitButtonMoveToMtsCheckIsDisabled(){
        submitButtonInMoveToMtsBlock.shouldHave(attribute("disabled", ""));
        return this;
    }
}
