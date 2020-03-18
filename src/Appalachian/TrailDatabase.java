package Appalachian;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 * This Trail Database Class imports a database of mountains and other features of the Appalachian trial and sorts them by various criteria
 * @author 21fernando
 * @version 3/5/2020
 */
public class TrailDatabase {
    private ArrayList<Waypoint>  myPoints;
    /**
     * Default constructor for Trail Database Class
     */
    public TrailDatabase(){
        myPoints = new ArrayList<>();
    }
    /**
     * Converts a user's string input to an integer that corresponds to its sort type
     * @param input a String that the user inputs
     * @return the integer code for a sort criteria
     */
    public int getSearchTerm(String input) {
        ArrayList<String> options = new ArrayList<>(Arrays.asList(new String[]{"NA", "DS", "DK", "EL", "Q"}));
        return options.indexOf(input);
    }
    /**
     * Reads in the text file apptrailDB.txt, creates waypoints, and adds them mypoints
     */
    public void populateDatabase(){
        Scanner in =null;
        try{
            in = new Scanner(new File("/Users/21fernando/Downloads/officialAPCS/src/Appalachian/apptrailDB.txt"));
            String[] parts;
            while (in.hasNext()){
                parts = in.nextLine().split("\t");
                myPoints.add(new Waypoint(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]),
                        Double.parseDouble(parts[4]), Double.parseDouble(parts[5]), Double.parseDouble(parts[6]),
                        Integer.parseInt(parts[7])));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * prints the databse by iterating through my points
     */
    public void printDatabase(){
        for(Waypoint p : myPoints){
            System.out.println(p);
        }
    }

    /**
     * Converts the ArrayList to an array, mergesorts the array, converts array to ArrayList
     * @param wps ArrayList of Waypoints to be sorted
     * @param wc A comparator to be used while sorting
     */
    public void sortDB(ArrayList<Waypoint> wps, WaypointComparator wc){
        Waypoint[] temp = new Waypoint[wps.size()];
        for (int i = 0; i < wps.size(); i++) {
            temp[i] = wps.get(i);
        }
        mergeSort(temp, wc);
        for (int i = 0; i < temp.length; i++) {
            wps.set(i,temp[i]);
        }
    }
    // merge sort
    private void mergeSort(Waypoint[] wps, WaypointComparator wc){
        // base case
        if(wps.length <2){ return; }
        else{
            //splitting into 2
            int mid = wps.length/2;
            Waypoint[] p1 = Arrays.copyOfRange(wps, 0, mid);
            Waypoint[] p2 = Arrays.copyOfRange(wps, mid, wps.length);
            //recursive call
            mergeSort(p1,wc);
            mergeSort(p2,wc);
            //merging
            int index1 = 0;
            int index2 = 0;
            while(index1<p1.length && index2<p2.length){
                if(wc.compare(p1[index1], p2[index2])>0){
                    wps[index1+index2] = p2[index2];
                    index2++;
                }else{
                    wps[index1+index2] = p1[index1];
                    index1++;
                }
            }
            //leftovers
            while(index1<p1.length){
                wps[index1+index2] = p1[index1];
                index1++;
            }
            while(index2<p2.length){
                wps[index1+index2] = p2[index2];
                index2++;
            }
        }
    }
    /**
     * Main method for this class, gets user input, sorts database, loops until terminated
     * @param args
     */
    public static void main(String[] args) {
        TrailDatabase app = new TrailDatabase();
        Scanner in = new Scanner(System.in);
        app.populateDatabase();
        System.out.println("*** Welcome to the Appalachian Trail Database ***");
        while (true) {
            System.out.println("+ Menu of search terms to use for sorting waypoints +");
            System.out.println("NA: by name\n" +
                    "DS: by distance to Springer\n" + "DK: by distance to Katahdin\n" + "EL: by elevation");
            System.out.println("Enter your preferred sort by term or 'Q' to quit: ");
            String type = in.nextLine();
            if (type.equalsIgnoreCase("Q")) {
                System.out.println("*** Thank you ***");
                break;}
            System.out.println("Enter 'A' to sort in ascending order or 'D' to sort in descending order: D");
            String ascending = in.nextLine();
            if(app.getSearchTerm(type.toUpperCase())==-1 || !"AD".contains(ascending.toUpperCase())){
                System.out.println("INVALID INPUT");
            }else{
                WaypointComparator wc = new WaypointComparator(ascending.equals("A") ,app.getSearchTerm(type));
                app.sortDB(app.myPoints,wc);
                app.printDatabase();
            }
        }
    }
}
