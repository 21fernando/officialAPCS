package Appalachian;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TrailDatabase {
    private ArrayList<Waypoint>  myPoints;
    public TrailDatabase(){
        myPoints = new ArrayList<>();
    }
    public int getSearchTerm() {
        return 0;
    }
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
    public void printDatabase(){
        for(Waypoint p : myPoints){
            System.out.println(p);
        }
    }
    public void sortDB(WaypointComparator wc){

    }
    public static void main(String[] args){
        TrailDatabase app = new TrailDatabase();
        app.populateDatabase();
        app.printDatabase();
    }


}
