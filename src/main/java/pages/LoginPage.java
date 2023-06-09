package pages;

import org.openqa.selenium.By;

import static settings.SharedSteps.clickOnElement;
import static settings.SharedSteps.sendTextToElement;

public class LoginPage {
    private final By emailLocator = By.id("Email");
    private final By passwordLocator = By.id("inputPassword");
    private final By loginButtonLocator = By.id("btnLogin");
    public void Register(String email , String password){
        sendTextToElement(email,emailLocator);
        sendTextToElement(password,passwordLocator);
        clickOnElement(loginButtonLocator);
    }
}
