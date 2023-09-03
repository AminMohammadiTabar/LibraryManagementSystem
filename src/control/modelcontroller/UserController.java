package control.modelcontroller;

import model.bl.UserBL;
import model.entity.User;
import tools.ExceptionWrapper;

public class UserController {
    public static Boolean isUserAuthorised(String username,String password){
        try {
                return UserBL.isUserAuthorised(username,password);
            }
        catch (Exception e) {
                ExceptionWrapper.getMessage(e);
                return false;
        }
    }
    public static Boolean isUserActive(String username,String password){
        User user=new User(username,password);
        try{
            return UserBL.isUserActive(user);
        } catch (Exception e) {
            ExceptionWrapper.getMessage(e);
            return false;
        }
    }
}