package end_to_end;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AddCoursePage;
import pages.CoursesPage;
import pages.LoginPage;
import pages.ReportingPage;

import static org.testng.Assert.assertTrue;
import static settings.SharedSteps.acceptAlert;
import static settings.SharedSteps.refreshPage;

public class CreateCourse{

    private final LoginPage login = new LoginPage();
    private final ReportingPage reportingPage = new ReportingPage();
    private final CoursesPage coursesPage = new CoursesPage();
    private final AddCoursePage addCoursePage = new AddCoursePage();


    @Given("Open the Winjigo website")
    public void openTheWinjigoWebsite() {
        
    }
    @When("sign in with username {string} and password {string}")
    public void signInWithUsernameAndPassword(String email, String password) {
        login.Register(email,password);
    }

    @And("open the courses page from left side navigation bar")
    public void openTheCoursesPageFromLeftSideNavigationBar() {
        reportingPage.goToCoursesPage();
    }

    @And("click on the create course button")
    public void clickOnTheCreateCourseButton() {
        coursesPage.addCourse();
    }

    @And("fill in the course basic info and click save course name is {string} grade year is {string}")
    public void fillInTheCourseBasicInfoAndClickSaveCourseNameIsGradeYearIs(String courseName, String gradeYear) {
        addCoursePage
                .addCourseName(courseName)
                .selectGradeYear(gradeYear)
                .selectCourseTeacher()
                .clickOnCreateCourse();
    }

    @Then("Back to courses list page and assert that course title is displayed {string}")
    public void backToCoursesListPageAndAssertThatCourseTitleIsDisplayed(String courseName) {
        reportingPage.goToCoursesPage();
        reportingPage.selectFromSortList();
        boolean actualResult = coursesPage.validateThatCourseNameIsDisplayed(courseName);
        assertTrue(actualResult,"Course not found");
    }
}
