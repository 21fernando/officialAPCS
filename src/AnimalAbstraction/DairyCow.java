package AnimalAbstraction;


public class DairyCow extends Cow {

    public DairyCow(int numLegs, String color, boolean s){
        super(numLegs, true, color, s);
    }

    public String agriculturalProduct(){return super.agriculturalProduct() + " and milk";}

    public String speak(){
        return "I am a dairy cow "  +  super.speak() + " milk";
    }


    public boolean equals(Object other) {
        if(!( other instanceof DairyCow)) return false;
        DairyCow temp = (DairyCow) other;
        return (this.getNumLegs() == temp.getNumLegs() && this.getIsSpotted() == temp.getIsSpotted() && this.getColor().equals(temp.getColor()));
    }
}
