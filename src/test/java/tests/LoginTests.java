package tests;

import dto.UserDTO;
import dto.UserDTOLombok;
import dto.UserDTOWith;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{
//    @Test
//    public void positiveLoginUserDTO(){
//        UserDTO userDTO = new UserDTO("awqfwf@gmail.com", "Beer12345!");
//        app.getUserHelper().login(userDTO);
//    }
//
//    @Test
//    public void positiveLoginUserDTOWith(){
//        UserDTOWith userDTOWith = new UserDTOWith()
//                .withEmail("awqfwf@gmail.com")
//                .withPassword("Beer12345!");
//        app.getUserHelper().login(userDTOWith);
//    }
    @Test
    public void positiveLogin(){
        UserDTOLombok userDTOLombok = UserDTOLombok.builder()
                .email("awqfwf@gmail.com")
                .password("Beer12345!")
                .build();
        app.getUserHelper().loginUserDToLombok(userDTOLombok);
    }
}
