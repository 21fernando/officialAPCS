package InheritanceHomework;

public class PointOnLine implements Place{
    private int xCor;
    public PointOnLine(int x){
        xCor = x;
    }
    public int getxCor(){
        return xCor;
    }
    public int distance(Place other){
        if(other instanceof PointOnLine) {
            return Math.abs(((PointOnLine) other).getxCor() - this.getxCor());
        }
        throw new IllegalArgumentException("Cant compare point on a line to other types of places!");
    }
}

