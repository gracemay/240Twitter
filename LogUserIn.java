package TwitterAssignment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
/**
 * @Author William
 * @Date 3/25/16
 * LogUserIn class contains a constructor, a checkLoginSuccess method, and a getUsername method.
 */
public class LogUserIn {

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
        for (int i = 0; i < userList.size(); i++)
            if (userList.get(i).getUsername().equals(u) && userList.get(i).getPassword().equals(p))
                return userList.get(i);
        return null;
    }

    public static void case1AddMessage(ArrayList<Message> messageList, String username){
        boolean work = false;
        Scanner in = new Scanner(System.in);
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
                updateMessagesFIle(messageList); //until we come up with something
                work = true;
            }catch (Exception e){
                System.out.println("Error With Message. Try again!");
            }
        } while(!work);
    }

    public static void case2ShowMessages(ArrayList<Message> messageList){
        SimpleDateFormat sdfMessages = new SimpleDateFormat("MM/dd/yyy hh:mm a");
        for (Message message : messageList) {
            if (!message.privacy) {
                System.out.println(message.getUser() + "  on " + sdfMessages.format(new Date(message.getDate())));
                System.out.println(message.getMessage() + "\n");
            }
        }
    }

    private static void updateMessagesFIle(ArrayList<Message> messageList) throws IOException
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
