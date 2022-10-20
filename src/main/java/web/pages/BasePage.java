package web.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$x;

public abstract class BasePage {

    private static final WebDriver driver = Selenide.webdriver().driver().getWebDriver();
    private final SelenideElement productButton = $x("//a[@class='gb_A' and @role='button']");
    private final SelenideElement mapsPageButton = $x("//a[contains(@href,'https://maps.google.co.il/maps')]");

    public abstract boolean isExist();

    //The idea is to get the google.co.il page then navigate to maps
//    public MapsPage getMapPage() {
//        productButton.click();
//        mapsPageButton.parent().click();
//        return new MapsPage();
//    }

    public void saveScreenshots(String fileName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(fileName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void clearScreenShots(String directoryName) {
        try {
            FileUtils.deleteDirectory(new File(directoryName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkIfFileDownloaded(String fileName) {
        return new File(fileName).isFile();
    }

}
