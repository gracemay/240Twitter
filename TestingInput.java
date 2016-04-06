
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestingInput {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner inTxt = new Scanner(new File("messageFile.txt"));
            String user;
            int messageID;
            String message;
            long date;
            boolean privacy;
        while (inTxt.hasNext()){
            System.out.println("HERE");
            user = inTxt.next();
                System.out.println(user);
            messageID = inTxt.nextInt();
                System.out.println(messageID);
            message = inTxt.nextLine();
            message = inTxt.nextLine();
                System.out.println(message);
            date = inTxt.nextLong();
                System.out.println(date);
            privacy = inTxt.nextBoolean();
                System.out.println(privacy);
        }

    }
}