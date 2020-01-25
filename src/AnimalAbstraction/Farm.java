package AnimalAbstraction;

import java.util.ArrayList;
public class Farm {

    private ArrayList<Animal> myAnimals;
    public Farm(){
       myAnimals = new ArrayList<>();
       myAnimals.add(new Cow(4, false, "brown", false));
       myAnimals.add(new DairyCow(4, "gray", false));
    }

    public void allSpeak(){
        for(Animal a : myAnimals){
            System.out.println(a);
        }
    }

    public boolean inFarm(Animal other){
        for (Animal a : myAnimals){
            if (a.equals(other))return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Farm f = new Farm();
        f.allSpeak();

    }


}
