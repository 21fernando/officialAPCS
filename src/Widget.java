import java.util.*;

public class Widget /*implements Comparable<Widget>*/ {

    private String name;
    private int id;
    private double cost;

    public Widget(){
        name = "";
        id = 0;
        cost = 0.0;
    }

    public String getName(){return name;}
    public int getId(){return id;}
    public double getCost() {return cost; }

    public Widget(String name, int id, double cost){
        this.name = name;
        this.id = id;
        this.cost = cost;
    }

    public boolean equals(Object o){
        if (o instanceof Widget){
            Widget temp = (Widget)o;
            return (this.name.equals(temp.name) && this.id == temp.id);
        }
        return false;
    }

    public String toString(){
        return name + " " + id + " " + cost;
    }

    /**
     * This<other return -int
     * This>other return +int
     * This == other 0
     * @param o
     * @return
     */
    /*public int compareTo(Widget o) {
        //return this.name.compareTo(o.name);
        //return this.id - o.id;
        //return new Double(this.cost).compareTo(o.cost);
        if (!this.name.equals(o.name)){
            return this.name.compareTo(o.name);
        }if (this.id != o.id){
            return this.id-o.id;
        }
        return new Double(this.cost).compareTo(o.cost);
    }*/

    public static void main(String[] args) {
        ArrayList<Widget> myDB = new ArrayList<>();
        myDB.add(new Widget("Bass-O-Matic", 1234, 16.99));
        myDB.add(new Widget("Bass-O-Matic", 1234, 20.0));
        myDB.add(new Widget("Sham-Wowdget", 2231, 9.99));
        myDB.add(new Widget("Sham-Wowdget", 2, 9.99));
        myDB.add(new Widget("Progressive Cal Cunningham running for US Senate", 1121, 199.99));
        myDB.add(new Widget("Progressive Cal Cunningham running for US Senate", 1121, 199.99));
        System.out.println(myDB);
        Collections.sort(myDB,new WidgetComparator(false));
        System.out.println(myDB);
    }
}
