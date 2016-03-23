package TwitterAssignment;

/**
 * @Author Jacqueline
 * @Date 3/21/16
 * Message Class holds all data for the message
 */
public class Message {
    //Data Types
    String[] messageList = new String[140];
    String message;
    int messageLength; // the end pt of the string
    boolean view;
    //add a time stamp

    //constructor
    public Message(String m, boolean v){
        message = m;
        messageLength = m.length()-1;
        view = v;

        for(int x = 0;x < m.length(); x++){
            messageList[x] = m.substring(x,x+1);
        }
    }

    //getter methods
    public String getMessage(){
        return message;
    }
    public int getMessageLength(){
        return messageLength;
    }
    public boolean getView(){
        return view;
    }

    //setter methods
    public void newView(boolean v){
        view = v;
    }

}
//check the class
class TryMessage{
    public static void main(String[] args){
        //create class
        Message pratice = new Message("Hello this is a pratice run", true);

        //check all methods
        System.out.println(pratice.getMessage());
        System.out.println(pratice.getMessageLength());
        System.out.println(pratice.getView());
        //change 
        pratice.newView(false);
        System.out.println(pratice.getView());

    }
}
