//package TwitterAssignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TwitterServerThread extends Thread
{
    private Socket socket = null;

    public TwitterServerThread(Socket socket)
    {
        super("TwitterServerThread");
        this.socket = socket;
    }
    
    public TwitterServerThread(String name)
    {
        super(name);
    }
    
    public void run()
    {

        try (
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        )
        {
            String inputLine, outputLine;
            TwitterProtocol handler = new TwitterProtocol();
            outputLine = handler.processInput(null);
            out.println(outputLine);

            while ((inputLine = in.readLine()) != null)
            {
                outputLine = handler.processInput(inputLine);
                //out.println(outputLine);
                if (outputLine.equals("EXIT"))
                    break;
            }
            String output = "";
            for (Message msg : (ArrayList<Message>) Main.readMessageInput("MessageFile.txt"))
                output += (msg.getUser() + "        " + Main.sdfMessages.format(new Date(msg.getDate())) + "" + msg.getMessage() + "");
            //out.println(output);
            socket.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(TwitterServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}