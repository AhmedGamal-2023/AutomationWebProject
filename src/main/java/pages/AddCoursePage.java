package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static settings.SharedSteps.*;

public class AddCoursePage {

    private final By addCourseFieldLocator = By.id("txtCourseName");
    private final By gradeListLocator = By.id("courseGrade");
    private final By courseTeacherLocator = By.xpath("//span[contains(text(),'Course Teacher')]");
    private final By teacherNameLocator = By.id("ui-select-choices-row-0-0");
    private final By createCourseButtonLocator = By.id("btnSaveAsDraftCourse");

    public AddCoursePage addCourseName(String courseName)  {
        advancedWait();
        sendTextToElement(courseName, addCourseFieldLocator);
        return this;
    }

    public AddCoursePage selectGradeYear(String gradeYear) {
        selectFromDropDownByVisibleText(gradeYear, gradeListLocator);
        return this;
    }

    public AddCoursePage selectCourseTeacher(){
        clickOnElement(courseTeacherLocator);
        clickOnElement(teacherNameLocator);
        return this;
    }

    public void clickOnCreateCourse(){
        clickOnElement(createCourseButtonLocator);
        handlePopUp();
    }
}
