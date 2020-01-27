package AnimalAbstraction;

public abstract class Animal {
    //abstract classes can contain private data
    //interfaces can only contain a list of methods -- all public
    private int numLegs;
    private boolean isFemale;
    private String color;

    public Animal(){
        numLegs = 0;
        color = null;
        isFemale = false;
    }

    public Animal(int numLegs, boolean isFemale, String color){
        this.numLegs = numLegs;
        this.isFemale = isFemale;
        this.color = color;
    }

    public Animal(Animal other){
        this.numLegs = other.numLegs;
        this.isFemale = other.isFemale;
        this.color = other.color;
    }

    public String toString(){
        return speak();
    }

    public int getNumLegs(){return numLegs;}
    public boolean getIsFemale(){return isFemale;}
    public String getColor() {return color;}



    public abstract String speak();
    public abstract String agriculturalProduct();


}
