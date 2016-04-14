//package TwitterAssignment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * @Author William
 * @Date 3/25/16
 * LogUserIn class contains does all the grunt work for what the user does while in the system.
 */
public class LogUserIn {
    private static SimpleDateFormat sdfMessages = new SimpleDateFormat("MM/dd/yyy hh:mm a");
    private static Scanner in = new Scanner(System.in);

//    public ArrayList<String> uList;
//    public ArrayList<String> pList;
//    public String u;
//    public String p;
//    
//    public LogUserIn(String user, String pswd) {
////        this.uList = uL;
////        this.pList = pL;
//        this.u = user;
//        this.p = pswd;
//    }

    // Checks all username AList indexes for username match, 
    // then checks password AList index for pswd match 
    public static boolean checkLoginSuccess(ArrayList<User> userList, String u, String p){
        for (int i = 0; i < userList.size(); i++)
            if (userList.get(i).getUsername().equals(u) && userList.get(i).getPassword().equals(p))
                return true;

//        for (int i = 0; i < uList.size(); i++) {
//            if (uList.get(i).equals(u)) {
//                pswdIndex = i;
//            }
//        }


//        for (int i = 0; i < pList.size(); i++) {
//            if (pList.get(pswdIndex).equals(p)) {
//                check = true;
//            }
//        }
        return false;
    }

    public static User getUser(ArrayList<User> userList, String u, String p)
    {
        for (User user : userList)
            if (user.getPassword().equals(p) && user.getUsername().equals(u))
                return user;
        return null;
    }

    public static  void caseCreateAccount(){
        System.out.println("To create an account on Twitter. Please enter a username:");
        String createUsername = in.nextLine();
        System.out.println("Please enter a password:");
        String createPassword = in.nextLine();
        System.out.println("Please enter an email address:");
        String createEmail = in.nextLine();
        System.out.println("Please enter a one-line description about yourself.");
        String createDescription = in.nextLine();
        int createFollowersCount = 0;
        int createFollowingCount = 0;
        String createFollowersNames = "";
        String createFollowingNames = "";

        User createUser = new User(createUsername,createPassword, createEmail, createDescription,createFollowersCount, createFollowingCount, createFollowersNames, createFollowingNames);
        Main.userList.add(createUser);
        
        try{
            updateUserFile();
        }catch (java.io.IOException e){
            System.out.println("Error updating User File");
        }
    }

    //adds a message. called from main.java case one
    public static void caseAddMessage(){
        boolean work = false;
        do {
            try {
                //get public or private message
                System.out.print("Public message (Y/N)? ");
                boolean privateMessage;
                String ans = in.nextLine();
                if(ans.equalsIgnoreCase("y"))
                    privateMessage = false;
                else
                    privateMessage = true;
                //ask for message
                System.out.println("Please enter the message:");
                String content = in.nextLine();
                Message msg = new Message(Main.username, (int) (System.nanoTime() % Integer.MAX_VALUE), content, System.currentTimeMillis(), privateMessage);
                //simple message ID for now
                Main.messageList.add(msg);
                updateMessagesFile(Main.messageList); //until we come up with something
                work = true;
            }catch (Exception e){
                System.out.println("Error With Message. Try again!");
            }
        } while(!work);
    }

    //prints out messages; still need work about public and private
    //@param messageList array and boolean to determine the result
    //if true no one is logged in, if false no one is logged in
    public static void casePrint(boolean loggedInSituation){
        for (Message message : Main.messageList) {
            //if loggedInSituation and privacy is true only print out public:  if loggedInSituation is false and message is false or the follower
            if ((loggedInSituation && message.privacy) ||
                    (!loggedInSituation && ( message.privacy || (!message.privacy && Main.currentUser.isFollowing(message.getUser()))))) {
                System.out.println(message.getUser() + "  on " + sdfMessages.format(new Date(message.getDate())));
                System.out.println(message.getMessage() + "\n");
            }
        }
    }

    //searches for a message
    public static void caseSearch(){
        System.out.println("Enter search terms separated by spaces:");
        String[] terms = in.nextLine().split(" ");
        for (Message m : Main.messageList)
            if (hasTerms(m, terms))
                System.out.println(m.getUser() + "  on " + sdfMessages.format(new Date(m.getDate())) + "\n" + m.getMessage() + "\n");
    }

    //deletes account
    public static void caseDeleteAccount(){
        System.out.println("Are you sure you want to delete your account? (Yes/No): ");
        if (in.nextLine().equalsIgnoreCase("Yes") && !Main.currentUser.equals(null))
        {
            Main.userList.remove(Main.currentUser);
            try{
                updateUserFile();
            }catch (java.io.IOException e){System.out.println("There is an error with added messages.");}

            ArrayList<Message> temp = new ArrayList<Message>();
            for (Message m : Main.messageList)
                if (m.getUser().equals(Main.currentUser.getUsername()) && m.getPrivacy() == true)
                    temp.add(m);
            for (Message m : temp)
                Main.messageList.remove(m);
            try{
                updateMessagesFile(Main.messageList);
            }catch (java.io.IOException e){System.out.println("There is an error with deleting all messages.");}

        }
        System.exit(0);     //until we add a log out function
    }

    //deletes messages only
    public static void caseDeleteMessage(){
        for (Message m : Main.messageList)
            if (m.getUser().equals(Main.currentUser.getUsername()))
                System.out.println(Main.messageList.indexOf(m) + ": " + sdfMessages.format(m.getDate()) + "\n" + m.getMessage() + "\n--------------------");
        System.out.println("Which message(s) would you like to delete (numbers separated by spaces)?");
        String[] deletions = in.nextLine().split(" ");
        for (int i = 0; i < deletions.length; i++)
        {
            int index = Integer.parseInt(deletions[i]);
            if (index < Main.messageList.size() && Main.messageList.get(index).getUser().equals(Main.currentUser.getUsername()))
                Main.messageList.remove(Main.messageList.get(index));
        }
        try{
            updateMessagesFile(Main.messageList);
        }catch (java.io.IOException e){System.out.println("There is an error with deleting messages.");}
    }

    //follow a user
    public static void casefollowUser(){
        //follow a user
        System.out.print("Please enter the username of the user you wish to follow:");
        String username = in.nextLine();
        for (User u : Main.userList)
            if (u.getUsername().equals(username))
                if (!Main.currentUser.isFollowing(u.getUsername()))
                {
                    Main.currentUser.addFollowing(username);
                    u.addFollower(Main.currentUser.getUsername());
                }
        try{
            updateUserFile();
        }catch (java.io.IOException e){
            System.out.println("We can't update user file.");}
    }

    //unfollow
    public static void caseUnfollow(){
        System.out.println("People you are following:");
        for (int i = 0; i < Main.currentUser.followings.length; i++)
            System.out.println(i + ".) " + Main.currentUser.followings[i]);
        System.out.print("Which of them would you like to unfollow?");
        String username = in.nextLine();
        boolean removed = Main.currentUser.removeFollowing(username);
        if (removed)
            for (User u : Main.userList)
            {
                if (u.getUsername().equals(username))
                    u.removeFollower(username);
            }
        else
            System.out.println("You are either not following that user, or that user does not exist.");
        try{
            updateUserFile();
        }catch (java.io.IOException e){
            System.out.println("We can't update user file.");}
    }

    public static boolean hasTerms(Message msg, String[] terms)
    {
        for (int i = 0; i < terms.length; i++)
            if (msg.getMessage().toLowerCase().contains(terms[i].toLowerCase()) || msg.getUser().toLowerCase().contains(terms[i].toLowerCase()))
                return true;
        return false;
    }
    //view user profile
    public static void caseViewProfile(){
        System.out.print("Enter username to view user's profile:");
        String userprofile = in.nextLine();
        int ind = -1;
        // THE CURRENT ERROR SOURCE: The next line only reads the first username and ends the loop
        // after that one check. Unsure at the moment how to fix it as it stems from the .size()
        // method of the for loop clearly... but unsure how to resolve the last issue.
        for (int i = 0; i < Main.userList.size(); i++){
            System.out.println(Main.userList.get(i).getUsername()); // only one user location string "User@42a57993"    //fixed error
            // is printed, no matter the user name entered
            if ((Main.userList.get(i).getUsername()).equals(userprofile))
                ind = i;
            break;
        }

        if (ind != -1) {
            System.out.println("Username: "+ Main.userList.get(ind).getUsername() +".");
            System.out.println("User registered on: "+ Main.userList.get(ind).getRegisterDate() +".");
            System.out.println("User follows "+ Main.userList.get(ind).getFollowing() +" other users.");
            System.out.println("User has "+ Main.userList.get(ind).getFollowers() +" followers.");

            String[] namesFollowing = Main.userList.get(ind).getFollowingList();
            String[] namesFollowers = Main.userList.get(ind).getFollowingList();
            for (int i = 0; i < namesFollowing.length; i++) {
                if ((namesFollowing[i]).equals("<"))
                    System.out.print("User is following no other users.");
                else
                    System.out.print(namesFollowing[i]);
            }
            System.out.println();
            for (int i = 0; i < namesFollowers.length; i++) {
                if ((namesFollowers[i]).equals("<"))
                    System.out.print("User has no followers.");
                else
                    System.out.print(namesFollowers[i]);
            }
            System.out.println();
        }
        // If user does not exist
        if (ind == -1) {
            System.out.println("No user exists with the username "+ userprofile +".");
        }
    }

    protected static void updateMessagesFile(ArrayList<Message> messageList) throws IOException
    {
        FileWriter fw = new FileWriter(new File("MessageFile.txt"));
        for (Message msg : messageList)
        {
            System.out.println(msg.getMessage());
            fw.write(msg.getUser() + "\n");
            fw.write(msg.getMessageID() + "\n");
            fw.write(msg.getMessage() + "\n");
            fw.write(Long.toString(msg.getDate()) + "\n");
            fw.write(Boolean.toString(msg.getPrivacy()) + "\n");
        }
        fw.close();
    }

    protected static void updateUserFile() throws IOException
    {
        FileWriter fw = new FileWriter(new File("UsersFile.txt"));
        for (User user : Main.userList)
        {
            String followers = "", following = "";
            fw.write(user.getUsername() + "\n");
            fw.write(user.getPassword() + "\n");
            fw.write(user.getEmail() + "\n");
            fw.write(user.getRegisterDate() + "\n");
            fw.write(user.description + "\n");
            fw.write(user.getFollowing() + "\n");
            fw.write(user.getFollowers() + "\n");
            for (int i = 0; i < user.followings.length; i++)
            {
                followers += user.followings[i];
                if (i != user.followings.length - 1 && !followers.equals(""))
                    followers += ";";
            }
            for (int i = 0; i < user.followers.length; i++)
            {
                following += user.followers[i];
                if (i != user.followers.length - 1 && !following.equals(""))
                    following += ";";
            }
            fw.write(following + "\n");
            fw.write(followers + "\n");
        }
        fw.close();
    }

    // Getter method
//    public String getUsername(boolean pswdCheck) {
//        if (pswdCheck){
//            return u;
//        } else {
//            return "";
//        }
//    }
}