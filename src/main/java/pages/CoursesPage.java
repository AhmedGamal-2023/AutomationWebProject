package pages;

import org.openqa.selenium.By;

import static settings.SharedSteps.*;

public class CoursesPage {

    private final By addCourseButtonLocator = By.id("btnListAddCourse");

    public void addCourse(){
        clickOnElement(addCourseButtonLocator);
    }

    public boolean validateThatCourseNameIsDisplayed(String courseName){
        advancedWait();
        final By courseNameLocator = By.xpath("//a[contains(text(),"+"'"+courseName+"'"+")]");
        return isDisplayed(courseNameLocator);
    }
}
