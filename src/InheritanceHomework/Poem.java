package InheritanceHomework;

public abstract class Poem {

    public abstract int numLines();

    public abstract int getSyllables(int k);

    public void printRythm(){
        for (int i = 1; i <= numLines() ; i++) {
            int numSyl = getSyllables(i);
            for(int s= 0; s<numSyl; s++){
                System.out.print((s!=numSyl-1)? "ta-": "ta");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        Poem haiku = new Haiku();
        Poem limerick = new Limerick();
        haiku.printRythm();
        limerick.printRythm();
        System.out.println(haiku.getClass());
    }

}
