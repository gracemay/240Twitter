package TwitterAssignment;
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
 * Getter method returns for following/follower list simplified
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
    //changed to simple array for the addTo Followes and Following method
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
    //fill the followers array using the split() method
    void addToFollowers(String followers){
        if (followers.substring(0,1).equals("N/A") && followers.length() >= 4)
            followers.replaceAll("N/A;", "");
        this.followers = followers.split(";");
    }
    //fill the following array using the split() method
    void addToFollowings(String followings){
        if (followings.substring(0,1).equals("N/A") && followings.length() >= 4)
            followings.replaceAll("N/A;", "");
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
    
    public void addFollower(String username)
    {
        if (followers[0].equals("N/A"))
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
        userFollowers++;
    }
    
    public boolean removeFollower(String username)
    {
        String[] temp = new String[followers.length - 1];
        int offset = 0;
        for (int i = 0; i < followers.length; i++)
        {
            if (followers[i].equals(username))
                offset++;
            else
                temp[i] = followers[i - offset];
            
        }
        userFollowers--;
        return (offset != 0);
    }
    
    public void addFollowing(String username)
    {
        if (followings[0].equals("N/A"))
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
    
    public boolean removeFollowing(String username)
    {
        String[] temp = new String[followings.length - 1];
        int offset = 0;
        for (int i = 0; i < followings.length; i++)
        {
            if (followings[i].equals(username))
                offset++;
            else
                temp[i] = followings[i - offset];
            
            
            System.out.println("Temp " + i + " " + temp[i]);
            System.out.println("Following " + i + " " + followings[i]);
        }
        userFollowing--;
        return (offset != 0);
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

    public boolean hasFollower(String follower)
    {
        for (int i = 0; i < followers.length; i++)
            if (followers[i].equals(follower))
                return true;
        return false;
    }
    //returns true if the follower is in the following list
    //param: the follower string
    public boolean isFollowing(String follower)
    {
        for (int i = 0; i < followings.length; i++)
            if (followings[i].equals(follower))
                return true;
        return false;
    }

} //end of User clas

//class PraticeUser{
//    public static void main(String[] args){
//        //User use = new User("Jacqueline", "123456", "jcoates@gmai.com", "11/12/2016", "this is a test",
//        User use = new User("Jacqueline", "123456", "jcoates@gmai.com", "this is a test",
//        3, 3, "jec12;pj34;sam;", "grace12;pet;will.i.am");
//
//        System.out.println(use.getUsername());
//        System.out.println(use.getEmail());
//        System.out.println(use.getFollowers());
//        System.out.println(use.getFollowing());
//        System.out.println(use.getRegisterDate());
//        System.out.println(use.getPassword());
//        use.getFollowerList();
//        use.getFollowingList();
//
//    }
//}
