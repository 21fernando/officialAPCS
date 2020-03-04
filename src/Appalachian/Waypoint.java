package Appalachian;

public class Waypoint{
    private String featureType, name, state;
    private double latitude, longitude, sDist, kDist;
    private int elevation;

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

    public String getFeatureType(){return featureType;}
    public String getName(){return name;}
    public String getState() { return state; }
    public double getkDist() { return kDist; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public double getsDist() { return sDist; }
    public int getElevation() { return elevation; }

    public String toString(){
        return this.featureType + "\t" + this.name + "\t" + this.state + "\t" + this.latitude + "\t" + this.longitude + "\t" + this.sDist + "\t" + this.kDist + "\t" + elevation;
    }

}
