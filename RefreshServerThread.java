//package TwitterAssignment;

import TwitterAssignment.Main;
import TwitterAssignment.Message;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author evan
 */
public class RefreshServerThread extends Thread
{
    
    Socket socket;
    static ArrayList<Message> mList;
    
    public RefreshServerThread(Socket socket)
    {
        super("RefreshServerThread");
        this.socket = socket;
    }
    
    @Override
    public void run()
    {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true))
        {
            String msgs = "";
            for (int i = mList.size() - 1; i > 0; i--)
                msgs += mList.get(i).getUser() + "\n" + mList.get(i).getDate() + "\n" + mList.get(i).getMessage() + "\n";
            out.write(msgs.toCharArray());
        }
        catch (Exception ex)
        {
            Logger.getLogger(RefreshServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
}
