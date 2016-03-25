// William Scheid
// Login class ver. 1 (3/25/16)

package loguserin;
import java.util.ArrayList;

public class LogUserIn {

    public ArrayList uList;
    public ArrayList pList;
    public String u;
    public String p;
    
    public LogUserIn(ArrayList uL, ArrayList pL, String user, String pswd) {
        this.uList = uL;
        this.pList = pL;
        this.u = user;
        this.p = pswd;
    }
    
    public boolean checkLoginSuccess(ArrayList uList, ArrayList pList, String u, String p){
        int pswdIndex = 0;
        boolean check = false;
        
        for (int i = 0; i < uList.size(); i++) {
            if (uList.get(i).equals(u)) {
                pswdIndex = i;
            }
        }
        
        for (int i = 0; i < pList.size(); i++) {
            if (pList.get(pswdIndex).equals(p)) {
                check = true;
            }
        }
        return check;
    }
    
    public String getUsername(boolean pswdCheck) {
        if (pswdCheck){
            return u;
        } else {
            return "";
        }
    }
}
