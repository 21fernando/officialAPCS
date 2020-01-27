package InheritanceHomework;

public class Diploma {

    private String name;
    private String subject;

    public Diploma(String name, String subject){
        this.name = name;
        this.subject = subject;
    }

    public String toString(){
        return "This certifies that " + name + " has completed a MOOC in " + subject;
    }
}
