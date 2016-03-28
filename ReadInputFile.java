package TwitterAssignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author William
 * @Date 3/28/16
 * A main class ReadInputFile method which returns either a user
 * or a message ArrayList from an input file, if the file exists. Code is designed
 * as generally as possible to allow for updates with agreed upon Message/User
 * objects & their object elements (lines 27/28/29/31/32, 33's parameters,
 * etc are arbitrary).
 */
    public static ArrayList ReadInputFile(String inputName) throws FileNotFoundException {
        ArrayList<User> uList = new ArrayList<User>();
        ArrayList<Message> mList = new ArrayList<Message>();
        try {
            if (inputName.equals("usersFile.txt")) {
                File inFile = new File(inputName);
                try (Scanner inTxt = new Scanner(inFile)) {
                    int firstLineIfNotApplicable = inTxt.nextInt();
                    String username;
                    String description;
                    while (inTxt.hasNext()) {
                        username = inTxt.next();
                        description = inTxt.next();
                        User u = new User(username, description);
                        uList.add(u);
                    }
                }
                return uList;
            }
            if (inputName.equals("messageFile.txt")) {
                File inFile = new File(inputName);
                try (Scanner inTxt = new Scanner(inFile)) {
                    int firstLineIfNotApplicable = inTxt.nextInt();
                    String messageID;
                    String userID;
                    String message;
                    while (inTxt.hasNext()) {
                        messageID = inTxt.next();
                        userID = inTxt.next();
                        message = inTxt.next();
                        Message m = new Message(messageID, userID, message);
                        mList.add(m);
                    }
                }
                return mList;
            }
        }
        catch (FileNotFoundException e) {
            // Establish blank files if none exist
            // Broad idea, we can edit as needed
            File outFile = new File ("usersFile.txt");
            FileWriter fWriter = new FileWriter(outFile, true);
            PrintWriter pWriter = new PrintWriter(fWriter);
            pWriter.print("");
            pWriter.close();
            return uList;
            
            File outFile = new File ("messageFile.txt");
            FileWriter fWriter = new FileWriter(outFile, true);
            PrintWriter pWriter = new PrintWriter(fWriter);
            pWriter.print("");
            pWriter.close();
            return uList;
        }
    } 
