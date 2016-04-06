package TwitterAssignment;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
 * @author Evan Shipman
 * Date: (4/3/16) Added pList and usernameList for LogUserIn, added methods to update the user and message files,
 * some misc. formatting stuff also put some Main functionality and a method for searching messages.
 * @author William Scheid
 * Date: (4/1/16) Added the updated input method and calls from the main method, with updated parameter read-ins.
 * Date: (4/6/16) Solved issue, learned to pull LOL
 * */

public class Main {
    //data members
    private static ArrayList<String> pList = new ArrayList<String>();
    private static ArrayList<String> usernameList = new ArrayList<String>();
    protected static SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");     //added to
    protected static SimpleDateFormat sdfMessages = new SimpleDateFormat("MM/dd/yyy hh:mm a");
    //added username and passwd to be data memebers.
    protected static String username = "", passwd = "";

    public static void main(String[] args) throws FileNotFoundException, NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
        //GUI graphical = new GUI();
        //graphical.start();
        ArrayList<User> userList = new ArrayList<User>();
        ArrayList<Message> messageList = new ArrayList<Message>();
        userList = readUserInput("UsersFile.txt");
        messageList = readMessageInput("MessageFile.txt");

        Scanner in = new Scanner(System.in);

        boolean done = LogIn(in);
        if(done)
            WhileLoggedIn(messageList, in);
        else
            System.out.println("User is not logged in.");

    }

    //this method logs the user in
    public static boolean LogIn(Scanner in){
        boolean done = false, success = false;
        System.out.println("Please enter log-in information (leave blank to quit)");
        while (!done)
        {
            System.out.print("Username:");
            username = in.next();
            System.out.print("Password:");
            passwd = (in.next());

            if (username.equals("") || passwd.equals(""))
                done = true;

            LogUserIn lui = new LogUserIn(usernameList, pList, username, passwd);
            success = lui.checkLoginSuccess(usernameList, pList, username, passwd);
            done = (success);

            if(!done){
                System.out.println("Error: Incorrect username or password.");
            }
        }
        return done;
    }

    //this method will run until the user is loged out.
    public static void WhileLoggedIn(ArrayList<Message> messageList, Scanner in){
        boolean done = false, success = false;
        Scanner command = new Scanner(System.in);
        while (!success){
            System.out.print("What would you like to do?\n"
                    + "1.) Post Messages\n"
                    + "2.) View Messages\n"
                    + "3.) Search Messages\n"
                    + "4.) Delete account\n"
                    + "else, logout/quit\n"
                    + "command:");
            switch (command.nextInt()) {
                case 1:
                    //added a try catch statement for java.io.IOException
                    boolean work = false;
                    do {
                        try {
                            //get public or private message
                            System.out.print("Private message (Y/N)? ");
                            boolean privateMessage;
                            in.nextLine();
                            String ans = in.nextLine().toLowerCase();
                            if(ans.equalsIgnoreCase("n"))
                                privateMessage = false;
                            else
                                privateMessage = true;
                            //ask for message
                            System.out.println("Please enter the message:");
                            String content = in.nextLine();
                            Message msg = new Message(username, (int) (System.nanoTime() % Integer.MAX_VALUE), content, System.currentTimeMillis(), privateMessage);
                            //simple message ID for now
                            addMessage(messageList, msg); //until we come up with something
                            work = true;
                        }catch (java.io.IOException e){
                            System.out.println("Error With Message. Try again!");
                        }
                    } while(!work);
                    break;                                                                                                        //better
                case 2:
                    for (Message message : messageList) {
                        if (!message.privacy) {
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
                            System.out.println(m.getUser() + "  on " + sdfMessages.format(new Date(m.getDate())) + "\n" + m.getMessage() + "\n");
                    break;
                case 4:
                    System.out.println("Are you sure you want to delete your account? (Y/N)");
                    if(in.nextLine().equalsIgnoreCase("y"))
                        System.out.println("THis is the part where we delete");
                    else

                    break;
                default:
                    success = false;
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
            System.out.println(user);
            messageID = Integer.parseInt(inTxt2.nextLine());
            //message = inTxt2.nextLine();
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
        String dateMade;
        String description;
        int followersCount;
        int followingCount;
        String followers;
        String following;
        while (inTxt.hasNext()) {
            username = inTxt.nextLine();
            System.out.println(username);
            password = inTxt.nextLine();
            email = inTxt.nextLine();
            dateMade = inTxt.nextLine();
            //description = inTxt.nextLine();
            description = inTxt.nextLine();
            followersCount = Integer.parseInt(inTxt.nextLine());
            followingCount = Integer.parseInt(inTxt.nextLine());
            //followers = inTxt.nextLine();
            followers = inTxt.nextLine();
            //following = inTxt.nextLine();
            following = inTxt.nextLine();

            User u = new User(username, password, email, description, followersCount, followingCount, followers, following);
            uList.add(u);
            pList.add((password));
            usernameList.add(username);
        }
        return uList;
    }


    public static void addMessage(ArrayList<Message> mList, Message m) throws IOException
    {
        mList.add(m);
        FileWriter fw = new FileWriter(new File("MessageFile.txt"));
        for (Message msg : mList)
        {
            fw.write(msg.getUser() + "\n");
            fw.write(msg.getMessageID() + "\n");
            fw.write(msg.getMessage() + "\n");
            fw.write(Long.toString(msg.getDate()) + "\n");
            fw.write(Boolean.toString(msg.getPrivacy()) + "\n");
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
            fw.write(user.getUsername() + "\n");
            fw.write(user.getPassword() + "\n");
            fw.write(user.getEmail() + "\n");
            fw.write(user.getRegisterDate() + "\n");
            fw.write(user.description + "\n");
            fw.write(user.getFollowers() + "\n");
            fw.write(user.getFollowing() + "\n");
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
            fw.write(followers + "\n");
            fw.write(following + "\n");
        }
        fw.close();
    }

    public static boolean hasTerms(Message msg, String[] terms)
    {
        for (int i = 0; i < terms.length; i++)
            if (msg.getMessage().contains(terms[i]))
                return true;
        return false;
    }



}
