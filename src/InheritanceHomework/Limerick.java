package InheritanceHomework;

public class Limerick extends Poem {

    public int numLines(){
        return 5;
    }

    public int getSyllables(int k){
        int[] numSyl = new int[]{9,9,6,6,9};
        return numSyl[k-1];
    }

}
