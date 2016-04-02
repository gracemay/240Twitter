package TwitterAssignment;
/**
 * @author Evan Shipman
 * @author William Scheid
 */
public class Main {
    
    // (4/1/16) William: I added the updated input method and calls from the main method, with updated parameter read-ins.
    //
    // TO BE DONE: Next, the User and Message classes must be updated to incorporate the new parameters as follows:
    // public Message(String user, int messageID, String message, int date, boolean privacy) {
    // User(String usname, String pswd, String email, String regdate, String description, int numbFollwers, int numbFollwing, String followers, String following){
    //
    // This is probably a task for two different people, seeing as it then involves manipulating the class constructor
    // and changing / adding methods.
    //
    public static ArrayList ReadInputFile(String inputName) throws FileNotFoundException {
        ArrayList<User> uList = new ArrayList<User>();
        ArrayList<Message> mList = new ArrayList<Message>();
        
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
                        User u = new User(username, password, email, dateMade, description, followersCount, followingCount, followers, following);
                        uList.add(u);
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
                        Message m = new Message(user, messageID, message, date, privacy);
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
    
    public static void main(String[] args) throws FileNotFoundException {
        //GUI graphical = new GUI();
        //graphical.start();
        ArrayList<User> userList = new ArrayList();
        ArrayList<Message> messageList = new ArrayList();
        userList = ReadInputFile("UsersFile.txt");
        messageList = ReadInputFile("MessageFile.txt");
        
    }
    
}
