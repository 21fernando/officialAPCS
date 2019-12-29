public class ClimbInfo {

    private String peakName = "";
    private int climbTime = 0;

    public ClimbInfo(String peakName, int climbTime) {
        this.peakName=peakName;
        this.climbTime=climbTime;
    }

    public int getClimbTime() {
        return climbTime;
    }

    public String getPeakName() {
        return peakName;
    }
}
