import java.util.ArrayList;
import java.util.List;
public class ClimbingClub {
    /** The list of climbs completed by members of the club.
     * Guaranteed not to be null. Contains only non-null references. */
    private static List<ClimbInfo> climbList;

    /** Creates a new ClimbingClub object. */
    public  ClimbingClub() {
        climbList = new ArrayList<ClimbInfo>();
    }

    /** Adds a new climb with name peakName and time climbTime to the list of climbs.
     * @param peakName the name of the mountain peak climbed
     * @param climbTime the number of minutes taken to complete the climb
     */
    public static void addClimb(String peakName, int climbTime) {
        climbList.add(new ClimbInfo(peakName, climbTime));
    }

    public static void addClimbByName(String peakname, int climbTime){
        boolean added = false;
        if (climbList.size() == 0 ){
            climbList.add(new ClimbInfo(peakname, climbTime));
            added = true;
        }
        for (int i = 0; i < climbList.size() && !added; i++) {
            if(climbList.get(i).getPeakName().compareTo(peakname)>=0){
                climbList.add(i, new ClimbInfo(peakname, climbTime));
                added = true;
            }
        }
        if(!added){
            climbList.add(new ClimbInfo(peakname, climbTime));
        }
    }

    /** @return the number of distinct names in the list of climbs */
    public int distinctPeakNames() {
        if (climbList.size() == 0) {
            return 0;
        }
        ClimbInfo currInfo = climbList.get(0);
        String prevName = currInfo.getPeakName();
        String currName = null;
        int numNames = 1;
        for (int k = 1; k < climbList.size(); k++) {
            currInfo = climbList.get(k);
            currName = currInfo.getPeakName();
            if (prevName.compareTo(currName) != 0) {
                numNames++;
                prevName = currName;
            }
        }
        return numNames;
    }

    public static void main(String[] args) {
        ClimbingClub cavaliers = new ClimbingClub();
        cavaliers.addClimbByName("a", 12);
        cavaliers.addClimbByName("b", 15);
        cavaliers.addClimbByName("c", 14);
        cavaliers.addClimbByName("d", 11);
        cavaliers.addClimbByName("a", 12);
        cavaliers.addClimbByName("c", 14);
        cavaliers.addClimbByName("d", 11);
        cavaliers.addClimbByName("z", 14);
        cavaliers.addClimbByName("h", 11);
        cavaliers.addClimbByName("d", 11);
        for (ClimbInfo climb : cavaliers.climbList){
            System.out.println(climb.getPeakName() + " " + climb.getClimbTime());
        }
        /**
         * b) i no
         * ii yes
         */

    }
}
