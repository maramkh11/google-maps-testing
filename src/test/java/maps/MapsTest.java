package maps;

import basic.BaseTest;
import com.codeborne.selenide.WebDriverRunner;
import jdk.jfr.Description;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import web.pages.MapsPage;

public class MapsTest extends BaseTest {

    private static final String TEST_NAME = "Find Rome - italy city zoom 3 times and save screenshot";
    private static final String SEARCH_NAME = "Rome Italy";
    private static String MAPS_SCREENSHOT_FOLDER = "/maps";
    private static final String DIRECTORY_PATH = SCREENSHOT_PATH + MAPS_SCREENSHOT_FOLDER;
    private String fileNamePattern = DIRECTORY_PATH + "/screenshot%s.png";
    private MapsPage mapsPage;
    private int numberOfAction = 3;

    @Description(TEST_NAME)
    @Test
    public void test() {
        navigateToMapsPage();
        searchInMaps();
        saveScreenShotAndZoomIn(numberOfAction);
        clearScreenShots();
    }

    @Description("Navigate to google maps page")
    private void navigateToMapsPage() {
        mapsPage = getMapsPage();
        var actualUrl = WebDriverRunner.url();
        Assertions.assertThat(actualUrl)
                .withFailMessage("The current page is not '' page")
                .contains(MapsPage.PAGE_URL);
    }

    //TODO-add validation
    private void searchInMaps() {
        mapsPage.setSearchInput(SEARCH_NAME);
        mapsPage.clickOnSearchIcon();
    }

    private void saveScreenShotAndZoomIn(int numberOfAction) {
        for (int i = 0; i < numberOfAction; i++) {
            zoomIn();
            saveScreenShot(i);
        }
    }

    //TODO-add validation
    @Description("Zoom in")
    private void zoomIn() {
        mapsPage.clickOnZoomInButton();
    }

    @Description("Save screenshot in screenshot/maps folder")
    private void saveScreenShot(int index) {
        String fileName = String.format(fileNamePattern, index);
        mapsPage.saveScreenshots(fileName);
        boolean isFileExist = mapsPage.checkIfFileDownloaded(fileName);
        Assertions.assertThat(isFileExist)
                .withFailMessage("The File is not Exist")
                .isTrue();
    }

    @Description("Clear the screenshot/maps folder")
    private void clearScreenShots() {
        mapsPage.clearScreenShots(DIRECTORY_PATH);
    }

}
