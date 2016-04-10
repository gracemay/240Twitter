//package TwitterAssignment;

import TwitterAssignment.*;
import TwitterAssignment.Main;
import TwitterAssignment.Main;
import java.net.*;
import java.io.*;
import java.nio.file.Files;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TwitterProtocol {
    private static final int WAITING = 0;
    private static final int COMMAND = 1;
    private static final int POST = 2;
    private static final int REFRESH = 3;
    private static final int SENTSECOND = 4;
    private static final int SENTTHIRD = 5;
    private static final int DONE = 99;
    

    
    private int state = WAITING;
    private String post = "";
    private String passwd = "";
    ArrayList<String> users = new ArrayList<>();
    ArrayList<String> passwds = new ArrayList<>();
    
    public TwitterProtocol() throws FileNotFoundException
    {
        Scanner in = new Scanner(new File("users.txt"));
        while (in.hasNext())
        {
            String[] arr = in.nextLine().split(":");
            users.add(arr[0]);
            passwds.add(arr[1]);
        }
    }

    public String processInput(String input) throws FileNotFoundException, IOException, NoSuchAlgorithmException
    {
        String output = "";
        if (input == null)
           state = WAITING;
        
        switch (state)
        {
            case WAITING:
                state = POST;
                break;
            case COMMAND:
                int action = Integer.parseInt(input);
                if (action == 1) state = POST;
                else if (action == 2) state = REFRESH;
                break;
            case POST:
                post = input;
                Message m = new Message(post.split(" ", 2)[0].substring(1), (int) (System.nanoTime() % Integer.MAX_VALUE), post.split(" ", 2)[1], System.currentTimeMillis(), false);
                Main.messageList.add(m);
                Main.updateMessagesFIle();
                //System.out.println(m.getUser() + "        " + sdfMessages.format(new Date(m.getDate())) + "\n" + m.getMessage() + "\n");
                //output = (m.getUser() + "        " + sdfMessages.format(new Date(m.getDate())) + "\n" + m.getMessage() + "\n");
                
//                MulticastSocket socket = new MulticastSocket(4445);
//                InetAddress group = InetAddress.getByName("203.0.113.0");
//                socket.joinGroup(group);
//                DatagramPacket packet;
//                packet = new DatagramPacket("hello".getBytes(), "hello".length(), group, 4445);
//                socket.send(packet);
                
                state = DONE;
                break;
            case REFRESH:
                
                break;
            case SENTSECOND:
                state = DONE;
                break;
            default:
                output = "EXIT";
                break;
        }
        
        return output;
    }
}