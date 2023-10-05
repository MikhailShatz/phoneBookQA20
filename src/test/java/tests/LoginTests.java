package tests;

import dto.UserDTO;
import dto.UserDTOWith;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{
    @Test
    public void positiveLoginUserDTO(){
        UserDTO userDTO = new UserDTO("awqfwf@gmail.com", "Beer12345!");
        app.getUserHelper().login(userDTO);
    }

    @Test
    public void positiveLoginUserDTOWith(){
        UserDTOWith userDTOWith = new UserDTOWith()
                .withEmail("awqfwf@gmail.com")
                .withPassword("Beer12345!");
        app.getUserHelper().login(userDTOWith);
    }
}
