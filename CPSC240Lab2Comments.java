// William Scheid
// Professor Anewalt
// Program to test class field, constructor, and method concepts.
// Output testing cited in written lab component.
package cpsc240lab2comments;
import java.util.Scanner;

/** Room class used to house field variables, Room constructor, 
 *  and Output method.
 * 
 * @author William Scheid
 */
class Room {
    // name field variable holds room name String
    public String name;
    // room field variable holds room number String
    public String room;
    // capacity field variable holds room capacity integer
    public int capacity;
    /** Room constructor declares Scanner object in, and prompts for user
     *  input to assign field variables. No parameters, throws, or returns.
     */
    public void Room() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the UMW building name: ");
        name = in.next( );
        System.out.println("Enter the room number: ");
        room = in.next( );
        System.out.println("Enter the room capacity: ");
        capacity = in.nextInt( );
    }
    
    /** Room output method prints assigned field variables.
     *  No parameters, throws, or returns used.
     */
    public void RoomOutput() {
        System.out.print("You are looking for room "+room+" in "+name+", ");
        System.out.println("which has a room capacity of "+capacity+" people.");
    }   
}
/** Class used to test field variables, Room constructor, 
 *  and Output method all housed within Room class, using a Room object.
 * 
 * @author William Scheid
 */
public class CPSC240Lab2Comments {
    /** Main method declares a Room object, and tests the constructor and method
     *  using room object. No parameters, throws, or returns.
     * @param args taken in as main method argument.
     */
    public static void main(String[] args) {
        // Main program to test Room class
        Room roomObject = new Room();
        roomObject.Room();
        roomObject.RoomOutput();
    }  
}

