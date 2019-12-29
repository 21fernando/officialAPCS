import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Other {

    /** Precondition: pred and act have the same non-zero length. */
    public static int diff(int[] pred, int[] act)	{
        int num = Integer.MIN_VALUE;
        for (int i = 0; i < pred.length; i++)	{
            // complete this method here
            if (Math.abs(act[i]-pred[i])>num){
                num = Math.abs(act[i]-pred[i]);
            }

        }
        return num;
    }

    public static void hello(int j, int k)	{
        while(j != k && k >= 0)	{
            j++;
            k--;
        }
        System.out.println(j + " " + k);
    }

    private static double compute(int x, int y)	{
        double r = 0;
        if(!(y == 0 || x/y <= 2))
            r = 1 / ((x - 2*y) * (2*x - y));
        return r;
    }


    public static void main(String[] args){

        String[] letterArray = {"A", "B", "C", "D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y", "Z"};
        ArrayList<String> letterList = new ArrayList<>();
        for(String letter : letterArray)
            letterList.add(letter);
        String[] randomLetters = new String[26];
        int randomIndex = 0;
        int i =0;
        while(letterList.size()>0){
            randomIndex = (int)(Math.random()*letterList.size());
            System.out.println(i + " " + randomIndex + " " + letterList.size());
            randomLetters[i] = letterList.remove(randomIndex);
            i++;
        }
        System.out.println(Arrays.toString(randomLetters));
        hello(3,6);

        int x = 5, y = 3;
        System.out.println((double)x * (double)y / 2);
        System.out.println((double)x * (double)(y / 2));
        System.out.println((double)(x * y / 2));

        compute(0,0);
    }

}
