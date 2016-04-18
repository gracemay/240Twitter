//package TwitterAssignment;
/**
 * @Author: Grace May
 * @Date: 3/25/2016
 * User class.
 *
 * @Author: Jacqueline Coates
 * @Date Edited: 4/2/2016
 *
 * @Author: William Scheid
 * Date Edited: 4/10/2016
 * Getter methods and variable returns for following/follower list methods rewritten.
 * 
 * @Author: Evan Shipman
 */
public class User{
//extends LogUserIn{
    /** Data members for the User class. **/
    protected String username;
    private String password;
    protected String email;
    protected long date;
    protected String description;
    protected int userFollowers;
    protected int userFollowing;
    public String[] followers;
    public String[] followings;

    //User constructor:edited
    //changed the date to a long to make reading from a file with registration dates persistent
    //      plus it's easier to convert from a long than to a long
    //public User(String usname, String pswd, String email, String dateMade, String description,
    public User(String usname, String pswd, String email, String description,
                int uFollwing, int uFollwers, String followings, String followers){
        username = usname;
        password = pswd;
        this.email = email;
        date = System.currentTimeMillis();
        this.description = description;
        userFollowers = uFollwers;
        userFollowing = uFollwing;
        addToFollowers(followers);
        addToFollowings(followings);
//        this.removeFollower("");
//        this.removeFollowing("");
        
    }
    
    public User(String usname, String pswd, String email, long date, String description,
                int uFollwing, int uFollwers, String followings, String followers){
        username = usname;
        password = pswd;
        this.email = email;
        this.date = date;
        this.description = description;
        userFollowers = uFollwers;
        userFollowing = uFollwing;
        addToFollowers(followers);
        addToFollowings(followings);
    }
    
    /**
     * Converts the follower string from the file to an array of followers
     * @param followers The string of followers separated by semicolons
     */
    void addToFollowers(String followers){
        this.followers = followers.split(";");
    }
    
    /**
     * Converts a string of who this user is following to an array
     * @param followings The string of users this user is following, separated by semicolons
     */
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

    void setRegisterDate(long rdate){
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
    
    /**
     * Adds a new follower to the array of followers
     * @param username The username of the new follower to add
     * @author Evan Shipman
     */
    public void addFollower(String username)
    {
        if (followers[0].equals(";"))
            followers[0] = username;
        else
        {
            String[] temp = new String[followers.length + 1];
            for (int i = 0; i < temp.length; i++)
                if (i < followers.length)
                    temp[i] = followers[i];
            temp[temp.length - 1] = username;
            followers = new String[temp.length];
            for (int i = 0; i < followers.length; i++)
                followers[i] = temp[i];
        }
//        for (User u : Main.userList)
//            if (u.getPassword().equals(password) && u.getUsername().equals(username))
//                u = this;
        userFollowers++;
    }
    
    /**
     * Removes a user from the array of the user's followers
     * @param username the username of the person who is no longer following this user
     * @return true if the removal was successful
     * @author Evan Shipman
     */
    public boolean removeFollower(String username)
    {
        String temp = "";
        for (int i = 0; i < followers.length; i++)
            if (!followers[i].equals(username))
                temp += followers[i] + ";";
        int diff = followers.length;
        followers = temp.split(";");
        userFollowers--;
        return diff > followers.length;
        
    }
    
    /**
     * Adds a user to the array of who this user is following
     * @param username the username of the new user to follow
     * @author Evan Shipman
     */
    public void addFollowing(String username)
    {
        if (followings[0].equals(""))
            followings[0] = username;
        else
        {
            String[] temp = new String[followings.length + 1];
            for (int i = 0; i < temp.length; i++)
                if (i < followings.length)
                    temp[i] = followings[i];
            temp[temp.length - 1] = username;
            followings = new String[temp.length];
            for (int i = 0; i < followings.length; i++)
                followings[i] = temp[i];
        }
        userFollowing++;
    }
    
    /**
     * Removes a user from the array of users this user is following
     * @param username the user to remove
     * @return true if the removal was successful
     * @author Evan Shipman
     */
    public boolean removeFollowing(String username)
    {
        String temp = "";
        for (int i = 0; i < followings.length; i++)
            if (!followings[i].equals(username))
                temp += followings[i] + ";";
        int diff = followings.length;
        followings = temp.split(";");
        userFollowing--;
        return diff > followings.length;
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

    public String getDescription(){
        return description;
    }
    
    public long getRegisterDate(){
        return date;
    }

    public int getFollowing(){
        return userFollowing;
    }

    public int getFollowers(){
        return userFollowers;
    }
    
    public String[] getFollowingList(){
        return followings;
    }

    public String[] getFollowerList(){
        return followers;
    }

    /**
     * Checks if this user has a follower with the given username
     * @param follower the username of the possible follower
     * @return true if the given user is following this user
     * @author Evan Shipman
     */
    public boolean hasFollower(String follower)
    {
        for (int i = 0; i < followers.length; i++)
            if (followers[i].equals(follower))
                return true;
        return false;
    }
    
    /**
     * Checks to see if this user is following the given user
     * @param follower the username of the other user
     * @return true if this user is following the given user
     * @author Evan Shipman
     */
    public boolean isFollowing(String follower)
    {
        for (int i = 0; i < followings.length; i++)
            if (followings[i].equals(follower))
                return true;
        return false;
    }

}