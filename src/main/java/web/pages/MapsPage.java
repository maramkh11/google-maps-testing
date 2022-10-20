package web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MapsPage extends web.pages.BasePage {

    public static final String PAGE_URL = "maps";
    private final SelenideElement searchInput = $x("/html//input[@id='searchboxinput']");
    private final SelenideElement searchIcon = $x("/html//button[@id='searchbox-searchbutton']");
    private final SelenideElement zoomInButton = $x("//button[@id='widget-zoom-in']");

    @Override
    public boolean isExist() {
        return searchInput.isDisplayed() && searchIcon.isDisplayed();
    }

    public void setSearchInput(String value) {
        searchInput.setValue(value);
    }

    public String getSearchInput() {
        return searchInput.text();
    }

    public void clickOnSearchIcon() {
        searchIcon.click();
    }

    public void clickOnZoomInButton() {
        zoomInButton.click();
    }

}


