//package TwitterAssignment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;


public class TwitterServer
{
    
    public static void start() throws IOException, FileNotFoundException, NoSuchAlgorithmException, InterruptedException
    {

        int portNumber = 4444;
        
        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
            )
        { 
            while (true)
            {
                Socket incoming = serverSocket.accept();
                Socket update = new Socket(incoming.getInetAddress(), portNumber + 1);
                //RefreshServerThread.mList = Main.readMessageInput("messageFile.txt");
                //RefreshServerThread refresher = new RefreshServerThread(update);
                //refresher.start();
                new TwitterServerThread(incoming).start();
            }
        } catch (IOException e)
        {
            System.out.println("Could not listen on port " + portNumber);
        }
    }
}
