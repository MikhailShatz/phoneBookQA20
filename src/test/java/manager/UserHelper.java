package manager;

import dto.UserDTO;
import dto.UserDTOLombok;
import dto.UserDTOWith;
import org.openqa.selenium.*;


public class UserHelper extends  BaseHelper {
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    By btnLoginNavigatorMenu = By.xpath("//a[@href='/login']");
    By inputEmailLoginForm = By.xpath("//input[@name='email']");
    By inputPasswordLoginForm = By.xpath("//input[@name='password']");
    By btnRegistrationForm = By.xpath("//button[@name='registration']");
    By textContacts = By.xpath("//a[@href='/contacts']");
    By btnLoginForm = By.xpath("//button[@name='login']");
    By btnSignOut = By.xpath("//button[contains(text(), 'Sign Out')]");

    By errorMessage1 = By.xpath("//div[contains(text(), 'Login Failed with code 401')]");
    By errorMessage2 = By.xpath("//div[contains(text(), 'Registration failed with code 400')]");
    By errorMessage3 = By.xpath("//div[contains(text(), 'Registration failed with code 409')]");
    String btnSignOutJS = "document.querySelector('button').click();";

    public void login(UserDTO user){
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, user.getEmail());
        typeTextBase(inputPasswordLoginForm, user.getPassword());
        clickBase(btnLoginForm);
       // clickBase(btnSignOut);
        pause(5);
    }

    public void login(UserDTOWith user){
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, user.getEmail());
        typeTextBase(inputPasswordLoginForm, user.getPassword());
        clickBase(btnLoginForm);
      //  clickBase(btnSignOut);
        pause(5);
    }

    public void loginUserDToLombok(UserDTOLombok user) {
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, user.getEmail());
        typeTextBase(inputPasswordLoginForm, user.getPassword());
       // clickBase(btnLoginForm);
        clickByXY(btnLoginForm, 5, 10);
       // clickBase(btnSignOut);
        pause(5);
    }
    public void fillRegistrationForm(UserDTOLombok user) {
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, user.getEmail());
        typeTextBase(inputPasswordLoginForm, user.getPassword());
        clickBase(btnRegistrationForm);
       // clickBase(btnSignOut);
    }

    public boolean btnLogoutExist(){
        return isElementExist(btnSignOut);
    }

    public void logout(){
       // clickBase(btnSignOut);
        clickByJS(btnSignOutJS);
    }



    public boolean validateContactTextDisplaysMainMenu() {
        String expectedResult = "CONTACTS".toUpperCase();
        return isTextEqual(textContacts, expectedResult);
    }

    public void pause(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public void negativeLogin(UserDTOLombok user) {
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, user.getEmail());
        typeTextBase(inputPasswordLoginForm, user.getPassword());
        clickBase(btnLoginForm);
        pause(10);
        alert();
    }

    public void negativeRegistration(UserDTOLombok user) {
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, user.getEmail());
        typeTextBase(inputPasswordLoginForm, user.getPassword());
        clickBase(btnRegistrationForm);
        pause(10);
        alert();
    }

    public boolean loginFailedErrorMessage() {
        return isTextEqual(errorMessage1, "Login Failed with code 401");
    }

    public boolean registrationFailedErrorMessage() {
        return isTextEqual(errorMessage2, "Registration failed with code 400");
    }


    public boolean registrationFailedErrorMessage2() {
        return isTextEqual(errorMessage3, "Registration failed with code 409");
    }
}
