package TwitterAssignment;
/**
 * @author Evan Shipman
 */
public class Main {
    // ReadInputFile method to be added after testing is completed tonight
    
    public static void main(String[] args) throws FileNotFoundException {
        //GUI graphical = new GUI();
        //graphical.start();
        ArrayList<User> userList = new ArrayList();
        ArrayList<Message> messageList = new ArrayList();
        userList = ReadInputFile("UsersFile.txt");
        messageList = ReadInputFile("MessageFile.txt");
        
    }
    
}
