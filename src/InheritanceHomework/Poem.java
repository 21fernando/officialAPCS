package InheritanceHomework;

public abstract class Poem {

    public abstract int numLines();

    public abstract int getSyllables(int k);

    public void printRythm(){
        for (int i = 1; i <= numLines() ; i++) {
            for(int s= 0; s<getSyllables(i); s++){
                System.out.println("ta-");
            }
            System.out.println("\n");
        }
    }

}
