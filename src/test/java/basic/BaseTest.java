package basic;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import web.pages.MapsPage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    //private StartPage startPage;
    private MapsPage mapsPage;
    public static final String SCREENSHOT_PATH = System.getProperty("user.dir") + "/screenshots";

    @BeforeClass
    public void startBrowser() {
        //startPage=openStartPage();
        mapsPage = openMapsPage();
    }

//    public StartPage openStartPage() {
//        open(web.data.WebsiteProperty.URL);
//        WebDriver driver = Selenide.webdriver().driver().getWebDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        return new StartPage();
//    }

    public MapsPage openMapsPage() {
        open(web.data.WebsiteProperty.URL);
        WebDriver driver = Selenide.webdriver().driver().getWebDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return new MapsPage();
    }

    @AfterClass
    public void tearDown() {
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWindow();
    }

//    public StartPage getStartPage() {
//        return startPage;
//    }

    public MapsPage getMapsPage() {
        return mapsPage;
    }

}
