package web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class StartPage extends BasePage {

    public final SelenideElement startPageTitle = $x("//img[@alt='Google']");

    @Override
    public boolean isExist() {
        return startPageTitle.isDisplayed();
    }

}
