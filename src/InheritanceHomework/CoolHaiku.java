package InheritanceHomework;

public class CoolHaiku extends Haiku {

    public int getSyllables(int k, double d) {return 0;}

    public static void main(String[] args) {
        Haiku c = new CoolHaiku();
        Dog fido = new UnderDog();
        fido.act();
    }
}
