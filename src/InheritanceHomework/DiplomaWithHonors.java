package InheritanceHomework;

public class DiplomaWithHonors extends Diploma {

    public DiplomaWithHonors(String name, String subject){
        super(name,subject);
    }

    public String toString(){
        return super.toString() + "\n *** with honors ***" ;
    }

    public static void main(String[] args) {
        Diploma d = new Diploma("Adam Smith", "Gardening");
        DiplomaWithHonors h = new DiplomaWithHonors("Betsy Smith", "Robotics");
        System.out.println(d);
        System.out.println(h);
    }


}
