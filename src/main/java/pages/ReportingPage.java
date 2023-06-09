package pages;

import org.openqa.selenium.By;

import static settings.SharedSteps.*;

public class ReportingPage {

    private final By coursesPageLocator = By.id("btnMyCoursesList");
    private final By sortByList = By.id("CoursesOrderBy");
    public void goToCoursesPage(){
        clickOnElement(coursesPageLocator);
    }

    public void selectFromSortList(){
        advancedWait();
        selectFromDropDownByIndex(3,sortByList);
    }

}
