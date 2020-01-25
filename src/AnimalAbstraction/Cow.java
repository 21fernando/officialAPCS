package AnimalAbstraction;

public class Cow extends Animal {

    private boolean spotted;

    public Cow(int numLegs, boolean isFemale, String color, boolean spotted){
        super(numLegs,isFemale,color);
        this.spotted = spotted;
    }

    public boolean getIsSpotted() { return spotted; }

    public String speak(){
        return "MOO";
    }

    public String agriculturalProduct(){return "beef";};
}
