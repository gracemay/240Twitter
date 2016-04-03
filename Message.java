package TwitterAssignment;

/**
 * @Author Jacqueline
 * @Date 3/21/16
 * Message Class holds all data for the message
 * @Date Edited: 4/2/2016
 */
public class Message {
    //Data Types
    String user;
    int messageID;
    String message;
    int date;
    boolean privacy;

    String[] messageList = new String[140];
    int messageLength; // the end pt of the string
    //add a time stamp

    //constructor
    public Message(String user, int messageID, String message, int date, boolean privacy){
        this.user = user;
        this.messageID = messageID;
        this.message = message;
        this.date = date;
        this.privacy = privacy;
        messageLength = this.message.length()-1;

        for(int x = 0;x < this.message.length(); x++){
            messageList[x] = this.message.substring(x,x+1);
        }
    }

    //getter methods
    public String getMessage(){
        return message;
    }
    public int getMessageLength(){
        return messageLength;
    }
    public int getMessageID(){
        return messageID;
    }
    public int getDate(){
        return date;
    }
    public boolean getPrivacy(){
        return privacy;
    }


    //setter methods
    public void newPrivacy(boolean v){
        privacy = v;
    }

}
//check the class
class TryMessage{
    public static void main(String[] args){
        //create class
        Message pratice = new Message("jec123", 3, "Hello this is a pratice run", 111216, true);

        //check all methods
        System.out.println(pratice.getMessage());
        System.out.println(pratice.getMessageLength());
        System.out.println(pratice.getPrivacy());

    }
}
