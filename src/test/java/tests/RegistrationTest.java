package tests;

import dto.UserDTOLombok;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{
    @BeforeTest
    public void preconditionsLogin(){
        logoutIfLogin();
    }


    @Test
    public void positiveRegistration(){
        String email = randomUtils.generateEmail(7);

        UserDTOLombok user = UserDTOLombok.builder()
                .email(email)
                .password("Beer12345!")
                .build();
        app.getUserHelper().fillRegistrationForm(user);
        Assert.assertTrue(app.getUserHelper().validateContactTextDisplaysMainMenu());
    }
    @Test
    public void negativeRegistrationWrongEmail(){
        UserDTOLombok user = UserDTOLombok.builder()
                .email("abc@")
                .password("Beer12345!")
                .build();
        app.getUserHelper().negativeRegistration(user);
        Assert.assertTrue(app.getUserHelper().registrationFailedErrorMessage());


    }

    @Test
    public void negativeRegistrationWrongPassword(){
        String email = randomUtils.generateEmail(7);
        UserDTOLombok user = UserDTOLombok.builder()
                .email(email)
                .password("Beer12345")
                .build();
        app.getUserHelper().negativeRegistration(user);
        Assert.assertTrue(app.getUserHelper().registrationFailedErrorMessage());

    }

    @Test
    public void negativeRegistrationBlankEmail(){
        UserDTOLombok user = UserDTOLombok.builder()
                .email("")
                .password("Beer12345!")
                .build();
        app.getUserHelper().negativeRegistration(user);
        Assert.assertTrue(app.getUserHelper().registrationFailedErrorMessage());

    }
    @Test
    public void negativeRegistrationUserAlreadyExists(){
        UserDTOLombok user = UserDTOLombok.builder()
                .email("awqfwf@gmail.com")
                .password("Beer12345!")
                .build();
        app.getUserHelper().negativeRegistration(user);
        Assert.assertTrue(app.getUserHelper().registrationFailedErrorMessage2());

    }
}
