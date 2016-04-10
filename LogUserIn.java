package TwitterAssignment;

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
 * LogUserIn class contains a constructor, a checkLoginSuccess method, and a getUsername method.
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
    //adds a message. called from main.java case one
    public static void case1AddMessage(ArrayList<Message> messageList, String username){
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
                Message msg = new Message(username, (int) (System.nanoTime() % Integer.MAX_VALUE), content, System.currentTimeMillis(), privateMessage);
                //simple message ID for now
                messageList.add(msg);
                updateMessagesFile(messageList); //until we come up with something
                work = true;
            }catch (Exception e){
                System.out.println("Error With Message. Try again!");
            }
        } while(!work);
    }
    //prints out messages; still need work about public and private
    public static void case2Print(ArrayList<Message> messageList){
        for (Message message : messageList) {
            if (!message.privacy) {
                System.out.println(message.getUser() + "  on " + sdfMessages.format(new Date(message.getDate())));
                System.out.println(message.getMessage() + "\n");
            }
        }
    }

    public static void case3Search(ArrayList<Message> messageList){
        System.out.println("Enter search terms separated by spaces:");
        String[] terms = in.nextLine().split(" ");
        for (Message m : messageList)
            if (hasTerms(m, terms))
                System.out.println(m.getUser() + "  on " + sdfMessages.format(new Date(m.getDate())) + "\n" + m.getMessage() + "\n");
    }

    public static void case4Delete(ArrayList<Message> messageList, User currentUser, ArrayList<User> userList){
        System.out.println("Are you sure you want to delete your account? (Yes/No): ");
        if (in.nextLine().equalsIgnoreCase("Yes") && !currentUser.equals(null))
        {
            userList.remove(currentUser);
            updateUserFile(userList);
            ArrayList<Message> temp = new ArrayList<Message>();
            for (Message m : messageList)
                if (m.getUser().equals(currentUser.getUsername()) && m.getPrivacy() == true)
                    temp.add(m);
            for (Message m : temp)
                messageList.remove(m);
            updateMessagesFile(messageList);
        }
        System.exit(0);     //until we add a log out function
    }

    private static void updateUserFile(ArrayList<User> userList) throws IOException
    {
        FileWriter fw = new FileWriter(new File("UsersFile.txt"));
        for (User user : userList)
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

    private static boolean hasTerms(Message msg, String[] terms)
    {
        for (int i = 0; i < terms.length; i++)
            if (msg.getMessage().contains(terms[i]))
                return true;
        return false;
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
    // Getter method
//    public String getUsername(boolean pswdCheck) {
//        if (pswdCheck){
//            return u;
//        } else {
//            return "";
//        }
//    }
}