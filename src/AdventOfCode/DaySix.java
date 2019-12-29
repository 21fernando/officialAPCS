package AdventOfCode;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class DaySix {

    public static ArrayList<Planet> planets = new ArrayList<>();
    public static void readIn(){
        Scanner in = null;
        try{
            in = new Scanner(new File("/Users/21fernando/officialAPCS/src/AdventOfCode/orbit.txt"));
            while (in.hasNext()){
                String line = in.nextLine();
                String name1 = line.substring(0,3);
                String name2 = line.substring(4,7);
                int index1 = -1;
                int index2 = -1;
                for (int i = 0; i< planets.size(); i++){
                    if(planets.get(i).name.equals(name1)){
                        index1 = i;
                    }else if(planets.get(i).name.equals(name2)){
                        index2 = i;
                    }
                }

                if(index1 == -1 && index2 == -1){
                    //System.out.println("2 new");
                    Planet a = new Planet(name1);
                    planets.add(a);
                    Planet b = new Planet(name2);
                    planets.add(b);
                    b.parent=a;
                    a.children.add(b);
                }else if (index1 >=0 && index2 == -1){
                    //System.out.println("new child");
                    Planet a = new Planet(name2);
                    planets.add(a);
                    planets.get(index1).children.add(a);
                    a.parent=planets.get(index1);
                }else if (index1 ==-1 && index2>=0){
                    //System.out.println("new parent");
                    Planet a = new Planet(name1);
                    planets.add(a);
                    a.children.add(planets.get(index2));
                    planets.get(index2).parent=a;
                }else{
                    //System.out.println(("nun new"));
                    planets.get(index1).children.add(planets.get(index2));
                    planets.get(index2).parent = planets.get(index1);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }



    public static int numOrbits(Planet p, ArrayList<Planet> input){
        if(p.name.equals("COM")) return 0;
        //System.out.println(p);
        input.add(p);
        return numOrbits(p.parent,input )+1;
    }

    public static int distance(Planet p, ArrayList<Planet> input){
        if(p.name.equals("COM")) return 0;
        //System.out.println(p);
        input.add(p);
        return numOrbits(p.parent,input )+1;
    }

    public static void main(String[] args) {
        readIn();
        /*int index = 9;
        for(int i =0; i<planets.size();i++){
            if(planets.get(i).name.equals("COM"))
                index =  i;
            i+= planets.size();
        }
        Arrays.asList(new Planet[]{p})
        System.out.println(index);*/
        ArrayList<Planet>  santaPath = new ArrayList<>();
        ArrayList<Planet> youPath = new ArrayList<>();
        Planet santa = null;
        Planet you = null;
        for(Planet p : planets){
           if(p.name.equals("SAN")){
               //System.out.println(searchFromPlanet(p, 0, new ArrayList<Planet>()));
               santa = p;
           }else if (p.name.equals("YOU")){
               you = p;
           }
        }
        while(!santa.name.equals("COM")){
            santaPath.add(santa);
            santa = santa.parent;
        }
        while(!you.name.equals("COM")){
            youPath.add(you);
            you = you.parent;
        }
        System.out.println(santaPath);
        System.out.println(youPath);

        int min = 100000;
        for(int i = 0; i<santaPath.size(); i++){
            for(int j = 0; j<youPath.size(); j++){
                if(santaPath.get(i).equals(youPath.get(j))){
                    System.out.println(i+j);
                    if(i+j<min) min = i+j;
                }
            }
        }
        System.out.println(min);

    }

}
