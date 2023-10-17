package tests;

import dto.UserDTO;
import dto.UserDTOLombok;
import dto.UserDTOWith;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{

    @BeforeTest
    public void preconditionsLogin(){
        logoutIfLogin();
    }

    @Test
    public void positiveLoginUserDTO(){
        UserDTO userDTO = new UserDTO("awqfwf@gmail.com", "Beer12345!");
        app.getUserHelper().login(userDTO);
        Assert.assertTrue(app.getUserHelper().validateContactTextDisplaysMainMenu());
    }

    @Test
    public void positiveLoginUserDTOWith(){
        UserDTOWith userDTOWith = new UserDTOWith()
                .withEmail("awqfwf@gmail.com")
                .withPassword("Beer12345!");
        app.getUserHelper().login(userDTOWith);
        Assert.assertTrue(app.getUserHelper().validateContactTextDisplaysMainMenu());
    }
    @Test
    public void positiveLogin(){
        UserDTOLombok userDTOLombok = UserDTOLombok.builder()
                .email("awqfwf@gmail.com")
                .password("Beer12345!")
                .build();
        app.getUserHelper().loginUserDToLombok(userDTOLombok);
        Assert.assertTrue(app.getUserHelper().validateContactTextDisplaysMainMenu());
    }

    @Test
    public void negativePasswordWithoutSymbol() {
        UserDTOLombok userDTOLombok = UserDTOLombok.builder()
                .email("awqfwf@gmail.com")
                .password("Beer12345")
                .build();
        app.getUserHelper().negativeLogin(userDTOLombok);
        Assert.assertTrue(app.getUserHelper().loginFailedErrorMessage());
    }

    @Test
    public void negativePasswordWithoutNumbers() {
        UserDTOLombok userDTOLombok = UserDTOLombok.builder()
                .email("awqfwf@gmail.com")
                .password("Beerawgw!")
                .build();
        app.getUserHelper().negativeLogin(userDTOLombok);
        Assert.assertTrue(app.getUserHelper().loginFailedErrorMessage());
    }

    @Test
    public void negativePasswordWithoutLetters() {
        UserDTOLombok userDTOLombok = UserDTOLombok.builder()
                .email("awqfwf@gmail.com")
                .password("125512345!")
                .build();
        app.getUserHelper().negativeLogin(userDTOLombok);
        Assert.assertTrue(app.getUserHelper().loginFailedErrorMessage());
    }
}
