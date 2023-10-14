package tests;

import dto.UserDTOLombok;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{
    @Test
    public void positiveRegistration(){
        String email = randomUtils.generateEmail(7);

        UserDTOLombok user = UserDTOLombok.builder()
                .email(email)
                .password("Beer12345!")
                .build();
        app.getUserHelper().fillRegistrationForm(user);
    }
}
