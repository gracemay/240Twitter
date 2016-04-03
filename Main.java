package TwitterAssignment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
 * @author Evan Shipman
 * @author William Scheid
 */
public class Main {
    
    private static ArrayList<String> pList = new ArrayList<>();
    private static ArrayList<String> usernameList = new ArrayList<>();
    protected static SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");     //added to 
    protected static SimpleDateFormat sdfMessages = new SimpleDateFormat("MM/dd/yyy hh:mm a");
    
    /*
        (4/3/16) Evan: Added the pList and usernameList for the LogUserIn, added methods to update the user and message files, some misc. formatting stuff
                       also put some Main functionality and a method for searching messages. I wasn't able to finish the switch statements
                       Currently there is one problem I'm noticing. When I run it, there is a NullPointerException that I think is somewhere around where
                       it reads the input files. I can fix it but I won't be able to get to it again until tonight or early tomorrow morning
                        The error could just be something I did and don't see yet.
    
                       I sincerely apologize for any and all messy code pieces
    
                        I have an idea to have display method in message class that takes user as input so it handles privacy and formatting
    */
    
    // (4/1/16) William: I added the updated input method and calls from the main method, with updated parameter read-ins.
    //
    // TO BE DONE: Next, the User and Message classes must be updated to incorporate the new CONSTRUCTOR parameters as follows:
    // public Message(String user, int messageID, String message, int date, boolean privacy) {
    // User(String usname, String pswd, String email, String regdate, String description, int numbFollwers, int numbFollwing, String followers, String following){
    //
    // This is probably a task for two different people(?), seeing as it then involves manipulating the class constructor
    // and changing / adding methods.
    //
    public static ArrayList ReadInputFile(String inputName) throws FileNotFoundException, NoSuchAlgorithmException, UnsupportedEncodingException {
        ArrayList<User> uList = new ArrayList<>();
        ArrayList<Message> mList = new ArrayList<>();
        
        try {
            if (inputName.equals("usersFile.txt")) {
                File inFile = new File(inputName);
                try (Scanner inTxt = new Scanner(inFile)) {
                    int firstLineIfNotApplicable = inTxt.nextInt();
                    String username;
                    String password;
                    String email;
                    String dateMade;
                    String description;
                    int followersCount;
                    int followingCount;
                    String followers;
                    String following;
                    while (inTxt.hasNext()) {
                        username = inTxt.next();
                        password = inTxt.next();
                        email = inTxt.next();
                        dateMade = inTxt.next();
                        description = inTxt.next();
                        followersCount = inTxt.nextInt();
                        followingCount = inTxt.nextInt();
                        followers = inTxt.next();
                        following = inTxt.next();
                        User u = new User(username, password, email, description, followersCount, followingCount, followers, following);
                        uList.add(u);
                        pList.add((password));
                        usernameList.add(username);
                    }
                }
                return uList;
            } else if (inputName.equals("messageFile.txt")) {
                File inFile = new File(inputName);
                try (Scanner inTxt = new Scanner(inFile)) {
                    int firstLineIfNotApplicable = inTxt.nextInt();
                    String user;
                    int messageID;
                    String message;
                    int date;
                    boolean privacy;
                    while (inTxt.hasNext()) {
                        user = inTxt.next();
                        messageID = inTxt.nextInt();
                        message = inTxt.next();
                        date = inTxt.nextInt();
                        privacy = inTxt.nextBoolean();
                        //Message m = new Message(user, messageID, message, date, privacy);
                        Message m = new Message(user, messageID, message, privacy);
                        mList.add(m);
                    }
                }
                return mList;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No 'UsersFile.txt' or 'MessageFile.txt' found.");
        }
        
        return null;
    }
    
    public static void addMessage(ArrayList<Message> mList, Message m) throws IOException
    {
        mList.add(m);
        FileWriter fw = new FileWriter(new File("messageFile.txt"));
        for (Message msg : mList)
        {
            fw.write(msg.getUser());
            fw.write(msg.getMessageID());
            fw.write(msg.getMessage());
            fw.write(Long.toString(msg.getDate()));
            fw.write(Boolean.toString(msg.getPrivacy()));
        }
        fw.close();
    }
    
    public static void addUser(ArrayList<User> uList, User u) throws IOException
    {
        uList.add(u);
        FileWriter fw = new FileWriter(new File("usersFile.txt"));
        for (User user : uList)
        {
            String followers = "", following = "";
            fw.write(user.getUsername());
            fw.write(user.getPassword());
            fw.write(user.getEmail());
            fw.write(user.getRegisterDate());
            fw.write(user.description);
            fw.write(user.getFollowers());
            fw.write(user.getFollowing());
            for (int i = 0; i < user.followers.length; i++)
            {
                followers += user.followers[i];
                if (i != user.followers.length - 1)
                    followers += ";";
            }
            for (int i = 0; i < user.followings.length; i++)
            {
                following += user.followings[i];
                if (i != user.followings.length - 1)
                    following += ";";
            }
            fw.write(followers);
            fw.write(following);
        }
        fw.close();
    }
    
    public static boolean hasTerms(Message msg, String[] terms)
    {
        for (int i = 0; i < terms.length; i++)
            if (msg.getMessage().contains(terms[i]));
                return true;
    }
    
    
    public static void main(String[] args) throws FileNotFoundException, NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
        //GUI graphical = new GUI();
        //graphical.start();
        ArrayList<User> userList = new ArrayList<>();
        ArrayList<Message> messageList = new ArrayList<>();
        userList = ReadInputFile("UsersFile.txt");
        messageList = ReadInputFile("MessageFile.txt");

        Scanner in = new Scanner(System.in);
        boolean done = false, success = false;
        String username = "", passwd = "";
        System.out.println("Please enter log-in information (leave blank to quit)");
        while (!done)
        {
            System.out.print("Username:");
            username = in.next();
            System.out.print("Password:");
            passwd = Hash.md5(in.next());
            
            if (username.equals("") || passwd.equals(""))
                done = true;
            
            LogUserIn lui = new LogUserIn(usernameList, pList, username, passwd);
            success = lui.checkLoginSuccess(usernameList, pList, username, passwd);
            done = (success)? true : false;
            System.out.println("Error: Incorrect username or password.");
        }
        while (success)
        {
            Scanner command = new Scanner(System.in);
            System.out.print("What would you like to do?\n"
                    + "1.) Post Messages\n"
                    + "2.) View Messages\n"
                    + "3.) Search Messages\n"
                    + "4.) Delete account\n"
                    + "else, logout/quit\n"
                    + "command:");
            switch (command.nextInt())
            {
                case 1:
                    System.out.print("Public message (Y/N)? ");
                    boolean privateMessage = (in.next().equalsIgnoreCase("N")) ? true : false;
                    System.out.println("Please enter the message:");
                    String content = in.next();
                    Message msg = new Message(username, (int) (System.nanoTime() % Integer.MAX_VALUE), content, privateMessage); //simple message ID for now
                    addMessage(messageList, msg);                                                                                 //until we come up with something
                    break;                                                                                                        //better
                case 2:
                    for (Message message: messageList)
                    {
                        if (!message.privacy)
                        {
                            System.out.println("@" + message.getUser() + "  on " + sdfMessages.format(new Date(message.getDate())));
                            System.out.println(message.getMessage() + "\n");
                        }
                    }
                    break;
                case 3:     //can be optimized later to search by relevance
                    System.out.println("Enter search terms separated by spaces:");
                    String[] terms = in.next().split(" ");
                    for (Message m : messageList) 
                        if (hasTerms(m, terms))
                            System.out.println("@" + m.getUser() + "  on " + sdfMessages.format(new Date(m.getDate())) + m.getMessage() + "\n");
                    break;
                case 4:
                    
                    break;
                default:
                    
                    break;
            }
        }
    }
    
}
