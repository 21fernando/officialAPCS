package InheritanceHomework;

public class Haiku extends Poem{

    public int numLines(){
        return 3;
    }

    public int getSyllables(int k){
        int[] numSyl = new int[]{5,7,5};
        return numSyl[k-1];
    }


    public void sayHi(){
        System.out.println("hello world");
    }

}
