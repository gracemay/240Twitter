package TwitterAssignment;
import java.util.*;
import java.text.*;

/**
  * Author: Grace May
  * Date: 3/25/2016
  * User class.
*/

public class User{ 
//extends LogUserIn{
   /** Data members for the User class. **/
   public String username;
   private String password;
   public String email;
   public String date;
   public int userFollowers;
   public int userFollowing;
   public String userEmail;
   public ArrayList<String> followAL;
   public ArrayList<User> userAL;
  
   //User constructor
   User(String usname, String pswd, String email, String regdate, int uFollwers, int uFollwing){
      setUsername(usname);
      setPassword(pswd);
      setEmail(email);
      setRegisterDate(regdate);
      setUserFollowers(uFollwers);
      setUserFollowing(uFollwing);
   }
   
   /** These methods below are the setter methods for the User class. **/
   void setUsername(String uname){
      username = uname;
   }
   
   void setPassword(String pword){
      password = pword;
   }

   void setEmail(String em){
      userEmail = em;
   }   
   
   void setRegisterDate(String rdate){
      date = rdate;
   }
   
   void setUserFollowers(int ufwer){
      int addingpeople =0;
      if(addingpeople >= 1){
         ufwer = addingpeople++;
      }
      else{
         ufwer = 0;
      }   
      userFollowers = ufwer;
   }
   
   void setUserFollowing(int ufwing){
      int addedpeople =0;
      if(addedpeople >= 1){
         ufwing = addedpeople++;
      }
      else{
         ufwing = 0;
      }   
      userFollowing = ufwing;
   
   }
   
   /** These methods below are the getter methods for the User class. **/
   public String getUsername(){
      return username;
   }
   
   private String getPassword(){
      return password;
   }
   
   public String getEmail(){
      return userEmail;
   }
   
   public String getRegisterDate(){
      Date date = new Date();
      SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
      String formatDate = sdf.format(date);
      return formatDate;
   }
   
   public int getFollowing(){
      return userFollowing;
   }
   
   public int getFollowers(){
      return userFollowers;
   }
   
 
 //createAccount(). Not entirely sure if this should go in this class or the Main method.
   
 //  deleteAccount(). Not entirely sure if this should go in this class or the Main method.



} //end of User class