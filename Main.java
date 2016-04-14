//package TwitterAssignment;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Evan Shipman
 * Date: (4/3/16) Added pList and usernameList for LogUserIn, added methods to update the user and message files,
 * some misc. formatting stuff also put some Main functionality and a method for searching messages.
 * @author William Scheid
 * Date: (4/1/16) Added the updated input method and calls from the main method, with updated parameter read-ins.
 * Date: (4/6/16) Solved issue, learned to pull LOL
 * Date: (4/6/16) Grace is trying to test her GitHub syncing lots of stuff.
 * BLAHHHH!!!!
 * Evan Shipman:
 * Date: (4/8/16) Changed addMessage and addUser to updateMessageFile and updateUserFile. A new message or user is
 *      added outside of those methods that way we also have a way to remove messages and users without unnecessary
 *      coding. Removed or renamed main methods from other classes so they can still be called. Cleaned up the
 *      checkLoginSuccess method and added a getUser method in the LogUserIn class to help with deleting accounts.
 *      Added a second constructor in User to accept a date as a long, and also changed the data type to a long
 *      because it's much easier to convert from a long rather than back to a long. The User.getRegisterDate() now
 *      returns a long so it must be converted with the formatter if it will be displayed to the user. Added the
 *      case 4 in main (Delete user account)
 *      ** If a user is placed in the UsersFile twice by mistake, deleting the account only removes one of them **
 *      ** Sometimes I've noticed the Scanner doesn't work right after lots of inputs                           **
 *      UPDATE: I think I finished the Scanner errors by changing them to nextLine()
 * Date: (4/10/16) Added delete messages functionality (case 5)
 * Date: (4/11/16) Added case 8 follow/unfollow
 *      UPDATE: Added methods in the User class to follow/unfollow (currently do not work). Any help on those would
 *              be appreciated
 */
public class Main {

    //    private static ArrayList<String> pList = new ArrayList<String>();
//    private static ArrayList<String> usernameList = new ArrayList<String>();
    protected static PreGUI begin = new PreGUI();
    protected static ArrayList<User> userList;
    protected static ArrayList<Message> messageList;
    public static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");     //added to
    public static SimpleDateFormat sdfMessages = new SimpleDateFormat("MM/dd/yyy hh:mm a");
    public static User currentUser;
    //added username and passwd to be data memebers.
    protected static String username = "", passwd = "";
    protected static boolean success;
    //the thing where everything happens
    public static void main(String[] args) throws FileNotFoundException, NoSuchAlgorithmException, UnsupportedEncodingException, IOException, InterruptedException {
//        GUI graphical = new GUI();
//        graphical.start();
        userList = new ArrayList<User>();
        messageList = new ArrayList<Message>();
        userList = readUserInput("UsersFile.txt");
        messageList = readMessageInput("MessageFile.txt");
        PreGUI.start();
//        Scanner in = new Scanner(System.in);
//
//        boolean done = startProgram(in);
//        if(done)
//            WhileLoggedIn(in);
    }

    //this method logs the user in
    public static boolean startProgram(Scanner in) throws IOException {
        boolean success = false;
        boolean cont = false;
        int attempts = 0;
        //will iterate unless the user quits of login. If not loggedin can see all public messages
        do{     //magic do not touch
            System.out.println("Do you wish to: " +
                    "\n1). Create An Account" +
                    "\n2). Login" +
                    "\n3). View Public Messages" +
                    "\n4). Quit" +
                    "\nPlease write out the number you wish to do.");

            switch (Integer.parseInt(in.nextLine())) {
                case 1: //Create an account
                   LogUserIn.caseCreateAccount();
                    cont = true;
                 //   break;
                case 2: //Login
                    System.out.println("Please enter log-in information (leave blank to quit)");
                    while (!success && attempts <= 2) {
                        System.out.print("Username:");
                        username = in.nextLine();
                        System.out.print("Password:");
                        passwd = (in.nextLine());

                        if (username.equals("") || passwd.equals(""))
                            success = false;
                            //LogUserIn lui = new LogUserIn(username, passwd);
                        success = LogUserIn.checkLoginSuccess(userList, username, passwd);
                        currentUser = LogUserIn.getUser(userList, username, passwd);
                        attempts++;
                        if (!success && attempts > 2) {
                            System.out.println("Error: Incorrect username or password.");
                            return false;
                        }else
                            cont = true;
                    }
                    break;
                case 3: //Print messages
                    LogUserIn.casePrint(true);
                    break;
                default:
                    cont = true;
                    System.out.println("Goodbye");
                    break;
            }
        }while(cont == false);
        return success;
    }

    //this method will run until the user is loged out.
    public static void WhileLoggedIn(Scanner in) throws IOException{
        boolean done = false, success = false;
        Scanner command = new Scanner(System.in);
        while(!success){
            System.out.print("What would you like to do?\n"
                    + "1.) Post Messages\n"
                    + "2.) View Messages\n"
                    + "3.) Search Messages\n"
                    + "4.) Delete Account\n"
                    + "5.) Delete Messages\n"
                    + "6.) Follow a User\n"
                    + "7.) Unfollow a User\n"
                    + "8.) View User Profile\n"
                    + "else, logout/quit\n"
                    + "command:");
            switch (Integer.parseInt(command.nextLine())) {
                case 1:
                    //added a try catch statement for java.io.IOException
                    LogUserIn.caseAddMessage();
                     break;
                case 2:
                    //prints out messages
                    LogUserIn.casePrint(false);
                    break;
                case 3:
                    //can be optimized later to search by relevance
                    LogUserIn.caseSearch();
                    break;
                case 4:
                    //delete account
                    LogUserIn.caseDeleteAccount();
                    break;
                case 5:
                    //delete messages
                    LogUserIn.caseDeleteMessage();
                    break;
                case 6:
                    //add a follower
                   LogUserIn.casefollowUser();
                    break;
                case 7:
                    //Unfollow a user
                    LogUserIn.caseUnfollow();
                    break;
                case 8:
                   //view user profile
                    LogUserIn.caseViewProfile();
                    break;
                default:
                    success = true;
                    break;
            }
        }
    }

    public static ArrayList readMessageInput(String inputName) throws FileNotFoundException, NoSuchAlgorithmException, UnsupportedEncodingException {
        ArrayList<Message> mList = new ArrayList<Message>();
        File inFile2 = new File(inputName);
        Scanner inTxt2 = new Scanner(inFile2);
        String user;
        int messageID;
        String message;
        long date;
        boolean privacy;
        while (inTxt2.hasNext()) {
            user = inTxt2.nextLine();
            messageID = Integer.parseInt(inTxt2.nextLine());
            message = inTxt2.nextLine();
            date = Long.parseLong(inTxt2.nextLine());
            privacy = Boolean.parseBoolean(inTxt2.nextLine());
            Message m = new Message(user, messageID, message, date, privacy);
            mList.add(m);
        }
        return mList;
    }

    public static ArrayList readUserInput(String inputName) throws FileNotFoundException, NoSuchAlgorithmException, UnsupportedEncodingException {
        ArrayList<User> uList = new ArrayList<User>();
        File inFile = new File(inputName);
        Scanner inTxt = new Scanner(inFile);
        String username;
        String password;
        String email;
        long dateMade;
        String description;
        int followersCount;
        int followingCount;
        String followers;
        String following;
        while (inTxt.hasNext()) {
            username = inTxt.nextLine();
            password = inTxt.nextLine();
            email = inTxt.nextLine();
            dateMade = Long.parseLong(inTxt.nextLine());
            description = inTxt.nextLine();
            followingCount = Integer.parseInt(inTxt.nextLine());
            followersCount = Integer.parseInt(inTxt.nextLine());
            following = inTxt.nextLine();
            followers = inTxt.nextLine();
            User u = new User(username, password, email, dateMade, description, followingCount, followersCount, following, followers);
            uList.add(u);
//            pList.add((password));
//            usernameList.add(username);
        }
        return uList;
    }

    //public static void writeUserFileOutput() throws FileNotFoundException{    
    //   PrintWriter writer = new PrintWriter("UsersFile.txt");
    //   for (int i = 0; i < userList.size(); i++) {
    //       writer.println(userList.get(i).getUsername());
    //       writer.println(userList.get(i).getPassword());
    //       writer.println(userList.get(i).getEmail());
    //       writer.println(userList.get(i).getRegisterDate());
    //       writer.println(userList.get(i).getFollowing());
    //       writer.println(userList.get(i).getFollowers());
    //       writer.println(userList.get(i).getFollowingList());
    //       writer.println(userList.get(i).getFollowerList());
    //   }
    //   writer.close();
    // }
   
    //public static void writeMessageFileOutput() throws FileNotFoundException {    
    //   PrintWriter writer = new PrintWriter("MessageFile.txt");
    //   for (int i = 0; i < messageList.size(); i++) {
    //       writer.println(messageList.get(i).getUser());
    //       writer.println(messageList.get(i).getMessageID());
    //       writer.println(messageList.get(i).getMessage());
    //       writer.println(messageList.get(i).getDate());
    //       writer.println(messageList.get(i).getPrivacy());
    //   }
    //   writer.close();
    //}
}
