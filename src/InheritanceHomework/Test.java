package InheritanceHomework;

public class Test{
    public static boolean sameDistance(Place p1, Place p2, Place p3){
        return p1.distance(p2) == p1.distance(p3);
    }
    public static void main(String[] args){
        PointOnLine p1 = new PointOnLine(2);
        PointOnLine p2 = new PointOnLine(0);
        PointOnLine p3 = new PointOnLine(4);
        PointOnLine p4 = new PointOnLine(-1);
        System.out.println(sameDistance(p1,p2,p3));
        System.out.println(sameDistance(p1,p2,p4));
    }
}
