package Appalachian;

/**
 * This class encapsulates the properties and functionalities of a waypoint
 * @author 21fernando
 * @version 3/5/2020
 */
public class Waypoint{
    private String featureType, name, state;
    private double latitude, longitude, sDist, kDist;
    private int elevation;
    /**
     * Parameterized constructor for the Waypoint class
     * @param featureType The type of feature
     * @param name Name of the feature
     * @param state State that the feature is in
     * @param latitude Latitude of the feature
     * @param longitude Longitude of the feature
     * @param sDist Distance from the feature to Springer
     * @param kDist Distance from the feature to Kathadin
     * @param elevation Elevation of the Feature
     */
    public Waypoint(String featureType, String name, String state, double latitude, double longitude, double sDist, double kDist, int elevation){
        this.featureType = featureType;
        this.name = name;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
        this.sDist = sDist;
        this.kDist = kDist;
        this.elevation = elevation;
    }

    /**
     * Getter for the name of a waypoint
     * @return the name of a waypoint as a String
     */
    public String getName(){return name;}

    /**
     * Getter for the distance to Kathadin
     * @return the distance to Kathadin as a double
     */
    public double getkDist() { return kDist; }

    /**
     * getter for the distance to Springer
     * @return the distance to Springer as a double
     */
    public double getsDist() { return sDist; }

    /**
     * getter for the elevation
     * @return returns the elevation as an int
     */
    public int getElevation() { return elevation; }

    /**
     * To String method for the Waypoint class
     * @return Returns all the fields of a waypoint in a string
     */
    public String toString(){
        return this.featureType + "\t" + this.name + "\t" + this.state + "\t" + this.latitude + "\t" + this.longitude + "\t" + this.sDist + "\t" + this.kDist + "\t" + elevation;
    }

}
