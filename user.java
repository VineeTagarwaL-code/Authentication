import java.util.ArrayList;
import java.util.List;

public class user {

    private static List<user> userList = new ArrayList<>();


    String userName ;
    String pass ;

    user(){
     this.userName = null;
     this.pass = "0000";

    }

    user(String userName , String pass){
        this.userName = userName;
        this.pass = pass;

        userList.add(this);
    }

    public void successMessage(){
        System.out.println(this.userName + "'s account created successfully" );
    }

    public  boolean userExists(String inputUserName){
        for(user user : userList ){
            if (user.userName.equals(inputUserName)) {
                return true;
            } 
        }

        return false;
    }

        public  boolean userAC(String inputUserName , String pass){
        for(user user : userList ){
            if (user.userName.equals(inputUserName) && user.pass.equals(pass)) {
                return true;
            } 
        }

        return false;
    }

   protected boolean updateUserName(String input , String userName){
     for(user user : userList ){
            if (user.userName.equals(userName) ) {
                user.userName = input;
                return true;
            } 
        }
        return false;
   }
}
