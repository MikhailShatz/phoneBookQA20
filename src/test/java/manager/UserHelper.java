package manager;

import dto.UserDTO;
import dto.UserDTOWith;
import org.openqa.selenium.*;


public class UserHelper extends  BaseHelper {
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    By btnLoginNavigatorMenu = By.xpath("//a[contains(@href, '/login')]");
    By inputEmailLoginForm = By.xpath("//input[@name='email']");
    By inputPasswordLoginForm = By.xpath("//input[@name='password']");
    By btnRegistrationForm = By.xpath("//button[@name='registration']");
    By btnLoginForm = By.xpath("//button[@name='login']");
    By btnSignOut = By.xpath("//button[text() = 'Sign Out']");

    public void login(UserDTO userDTO){
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, userDTO.getEmail());
        typeTextBase(inputPasswordLoginForm, userDTO.getPassword());
        clickBase(btnLoginForm);
        clickBase(btnSignOut);
    }

    public void login(UserDTOWith userDTO){
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, userDTO.getEmail());
        typeTextBase(inputPasswordLoginForm, userDTO.getPassword());
        clickBase(btnLoginForm);
        clickBase(btnSignOut);
    }



//    public boolean validatePopUpMessageSuccessAfterLogin(){
//        return isTextEqual(, "CONTACTS");
//    }
}
