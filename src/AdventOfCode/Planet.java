package AdventOfCode;
import java.util.ArrayList;
public class Planet implements Comparable<Planet>{

    public String name;
    public ArrayList<Planet> children = new ArrayList<>();
    public Planet parent;
    public int direct =0;
    public int indirect = 0;

    public Planet(String name){
        this.name = name;
    }


    @Override
    public int compareTo(Planet o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
