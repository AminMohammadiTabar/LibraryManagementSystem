package model.bl;

import model.da.UserDA;
import model.entity.User;

import java.sql.SQLException;

public class UserBL {
    public static Boolean isUserAuthorised(String username,String password) throws Exception {
        try(UserDA userDA=new UserDA()){
            if(userDA.isUserAuthorised(username,password)!=0){
                return true;
            }
            else {
                return false;
            }
        }
    }
    public static Boolean isUserActive(User user) throws Exception {
        try(UserDA userDA=new UserDA()){
            return userDA.isUserActive(user);
        }
    }
}
