package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.MiddleMenu;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement mainHeaderButton = $x("//a[@eventid='vntMtsCrossTopLinks' and contains(@class, 'is-active')]");
    private ElementsCollection middleMenuButtons(MiddleMenu middleMenu){
        return ($$x("//div[@class='navigation-menu-slider__container']/descendant::h3[text()='"+ middleMenu.getDisplayName() +"' and @class='navigation-menu-card__title']"));
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
}
