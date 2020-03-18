package Appalachian;
import java.util.Comparator;

/**
 * Comparator for waypoints
 * @author 21fernando
 * @version 3/5/2020
 */
public class WaypointComparator implements Comparator<Waypoint> {
    private boolean asc;
    private int sort;
    //0 -name, 1 - distance to Springer, 2- distance to Katahdin, 3- elevation
    /**
     * Default constructor for Waypoint Constructor
     */
    public WaypointComparator(){
        asc = true;
        sort = 0;
    }

    /**
     * overloaded constructor public int compare(Waypoint w1, Waypoint w2)
     * @param a ascending or descending
     * @param s the int representation of a sort
     */
    public WaypointComparator(boolean a, int s){
        asc = a;
        sort = s;
    }

    /**
     * compare method compares two method
     * @param w1 waypoint 1
     * @param w2 wapoint 2
     * @return an int that represents the comparison between 2 waypoints
     */
    public int compare(Waypoint w1, Waypoint w2){
        int x = 0;
        switch (sort) {
            case 0:
                x = w1.getName().compareTo(w2.getName());
                break;
            case 1:
                x = Double.compare(w1.getsDist(), w2.getsDist());
                break;
            case 2:
                x = Double.compare(w1.getkDist(), w2.getkDist());
                break;
            case 3:
                x =  w1.getElevation() - w2.getElevation() ;
                break;
        }
        return (asc)? x: -x;
    }

}
