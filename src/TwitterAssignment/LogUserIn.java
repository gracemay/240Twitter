package TwitterAssignment;


import java.util.ArrayList;

/**
 * @Author William
 * @Date 3/25/16
 * LogUserIn class contains a constructor, a checkLoginSuccess method, and a getUsername method.
 */
public class LogUserIn {

    public ArrayList<String> uList;
    public ArrayList<String> pList;
    public String u;
    public String p;

    public LogUserIn(ArrayList<String> uL, ArrayList<String> pL, String user, String pswd) {
        this.uList = uL;
        this.pList = pL;
        this.u = user;
        this.p = pswd;
    }

    // Checks all username AList indexes for username match,
    // then checks password AList index for pswd match
    public boolean checkLoginSuccess(ArrayList<String> uList, ArrayList<String> pList, String u, String p){
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

    // Getter method
    public String getUsername(boolean pswdCheck) {
        if (pswdCheck){
            return u;
        } else {
            return "";
        }
    }
}