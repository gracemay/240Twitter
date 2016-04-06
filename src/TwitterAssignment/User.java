package TwitterAssignment;
import java.util.*;
import java.text.*;

/**
 * @Author: Grace May
 * @Date: 3/25/2016
 * User class.
 *
 * @Author: Jacqueline Coates
 * @Date Edited: 4/2/2016
 */
public class User{
//extends LogUserIn{
    /** Data members for the User class. **/
    protected String username;
    private String password;
    protected String email;
    protected String date;
    protected String description;
    protected int userFollowers;
    protected int userFollowing;
    //changed to simple array for the addTo Followes and Following method
    public String[] followers;
    public String[] followings;

    //User constructor:edited
    public User(String usname, String pswd, String email, String description,
                int uFollwers, int uFollwing, String followers, String following){
        username = usname;
        password = pswd;
        this.email = email;
        //date = dateMade;
        this.description = description;
        userFollowers = uFollwers;
        userFollowing = uFollwing;
        addToFollowers(followers);
        addToFollowings(following);
    }
    //fill the followers array using the split() method
    void addToFollowers(String followers){
        this.followers = followers.split(";");
    }
    //fill the following array using the split() method
    void addToFollowings(String followings){
        this.followings = followings.split(";");
    }

    /** These methods below are the setter methods for the User class. **/
    void setUsername(String uname){
        username = uname;
    }

    void setPassword(String pword){
        password = pword;
    }

    void setEmail(String em){
        email = em;
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

    protected String getPassword(){
        return password;
    }

    public String getEmail(){
        return email;
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
    
    public void getFollowingList(){
        for(int x = 0; x < followings.length; x++)
            System.out.println("Following number "+x+": "+followings[x]);
        System.out.println();
    }

    public void getFollowerList(){
        for(int x = 0; x < followers.length; x++)
            System.out.println("Follower number "+x+": "+followers[x]);
        System.out.println();
    }

} //end of User clas

