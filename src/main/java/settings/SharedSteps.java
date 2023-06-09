package settings;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public final class SharedSteps {
    private static final WebDriver driver = DriverFactory.getDriver(WinjigoSettings.browserType);
    private static final WebDriverWait wait = DriverFactory.getDriverWait();

    private static final Actions action = DriverFactory.getDriverAction();

    public static void clickOnElement(By elementPath) {
        wait.until(ExpectedConditions.elementToBeClickable(elementPath)).click();
    }

    public static void clickOnElement(WebElement elementPath) {
        wait.until(ExpectedConditions.elementToBeClickable(elementPath)).click();
    }

    public static void clickOnElementByAction(By elementPath) {
        WebElement element = findElement(elementPath);
        action.moveToElement(element).click().build().perform();
    }

    public static void clickOnElementByJavaScript(By elementPath) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(elementPath));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static void clickOnCheckBox(By checkBoxPath) {
        action.click(driver.findElement(checkBoxPath)).build().perform();
    }

    public static void sendTextToElement(String text, By elementPath) {
        WebElement element = driver.findElement(elementPath);
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    public static void selectFromDropDownByVisibleText(String value, By dropDownPath) {
        findDropDownElement(dropDownPath).selectByVisibleText(value);
    }

    public static void selectFromDropDownByIndex(int index, By dropDownPath) {
        findDropDownElement(dropDownPath).selectByIndex(index);
    }

    public static void selectFromDropDownByValue(String value, By dropDownPath) {
        findDropDownElement(dropDownPath).selectByValue(value);
    }

    public static List<WebElement> findElements(By elementsPath) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(elementsPath)));
    }

    public static void moveToElement(WebElement element) {
        action.moveToElement(element).build().perform();
    }

    public static void refreshPage() {
        driver.navigate().refresh();
    }

    public static void clickTwice(By elementPath) {
        clickOnElement(elementPath);
        clickOnElement(elementPath);
    }

    public static void openNewWindow(String newUrl) {
        driver.switchTo().newWindow(WindowType.WINDOW).get(newUrl);
    }

    public static String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public static void goToWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
    }

    public static void navigatesTo(String url) {
        driver.navigate().to(url);
    }

    public static void advancedWait(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public static void handlePopUp(){
        String JS_DISABLE_UNLOAD_DIALOG = "Object.defineProperty(BeforeUnloadEvent.prototype, 'returnValue', { get:function(){}, set:function(){} });";
        ((JavascriptExecutor)driver).executeScript(JS_DISABLE_UNLOAD_DIALOG);
    }

    public static boolean isDisplayed(By elementPath){
        return driver.findElement(elementPath).isDisplayed();
    }

    private static WebElement findElement(By elementsPath) {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(elementsPath)));
    }

    private static Select findDropDownElement(By dropDownPath) {
        return new Select(driver.findElement(dropDownPath));
    }

}
