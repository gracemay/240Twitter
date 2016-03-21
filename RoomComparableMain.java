import java.util.*;
public class RoomComparableMain {
   public static void main (String [] args) {
      ArrayList<RoomComparable> rmcomparable = new ArrayList<RoomComparable>();
      rmcomparable.add(new RoomComparable ("322", "ITCC",30));
      rmcomparable.add(new RoomComparable("210", "Monroe",50));
      rmcomparable.add(new RoomComparable("433", "UC",100));
      rmcomparable.add(new RoomComparable("120", "Trinkle",75));
      rmcomparable.add(new RoomComparable("280", "Jepson",20));
      for (RoomComparable rcable : rmcomparable){
         System.out.println(rcable.getBuildingName() + " "+ rcable.getRoomNumber()+ " " + rcable.getCapacity);
      }
      Collections.sort(rcmparable);
      for (RoomComparable rcable : rmcomparable){
         System.out.println(rcable.getBuildingName() + " "+ rcable.getRoomNumber()+ " " + rcable.getCapacity);
      }
   }
}