package Appalachian;
import java.util.Comparator;

public class WaypointComparator implements Comparator<Waypoint> {
    private boolean asc;
    private int sort;
    //0 -name, 1 - distance to Springer, 2- distance to Katahdin, 3- elevation
    /**
     * Default constructor
     */
    public WaypointComparator(){
        asc = true;
        sort = 0;
    }
    //overloaded constructor public int compare(Waypoint w1, Waypoint w2)
    public WaypointComparator(boolean a, int s){
        asc = a;
        sort = s;
    }
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
                x = w1.getElevation() - w2.getElevation();
                break;
        }
        return (asc)? x: -x;
    }

}
