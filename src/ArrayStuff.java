import java.util.Arrays;

public class ArrayStuff{

    public static void swap(int[] arr){
        if ( arr.length>1){
            int firstNum = arr[0];
            arr[0]=arr[arr.length-1];
            arr[arr.length-1] = firstNum;
        }
    }

    public static char getRandomChar(char[] nums){
        char[] rps = {'r','r','r','p','p','p','p','p','s','s','s','s','s','s'};
        return rps[(int)(Math.random()*rps.length)];
    }

    public static double[] getRoots(int a, int b, int c){
        if(a==0){
            throw new IllegalArgumentException("a==0");
        }
        if ( Math.pow(b,2)-4*a*c <0){
            throw new IllegalArgumentException("Imaginary roots");
        }
        double smallRoot = (-1*b - (Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a));
        double largeRoot = (-1*b + (Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a));
        double[] roots = {smallRoot,largeRoot};
        double[] root = {smallRoot};
        return (smallRoot==largeRoot)? root : roots;

    }

    public static int[] fibonacci( int n){
        if (n<0)
            return null;
        else if (n==0)
            return new int[]{0};
        else{
            int[] nums = new int[n+1];
            nums[0]=0;
            nums[1]=1;
            for (int i=2; i<=n; i++){
                nums[i]=nums[i-1]+nums[i-2];
            }
            return nums;
        }
    }

    private static double positiveMax(double[][] m){
        double max = 0;
        for (int r = 0; r<m.length ; r++){
            for (int c = 0; c< m[r].length ; c++){
                Double temp = m[r][c];
                if( temp.compareTo(max)>0)
                    max = m[r][c];
            }
        }
        return max;
    }

    public static int sumArray( int[] nums){
        int sum =0;
        for (int i:nums){
            sum+=i;
        }
        return sum;
    }

    public static int[] sum2d (int[][] t){
        int[] sums = new int[t[0].length];
        for (int i =0; i<sums.length; i++){
            sums[i] = sumArray(t[i]);
        }
        return sums;
    }

    public static boolean isMedian(double[]sample, double m){
        int greaterThan = 0;
        int lessThan = 0;
        for (int i=0; i<sample.length; i++){
            if(sample[i]>m)
                greaterThan ++;
            else if(sample[i]<m)
                lessThan++;
        }

        return greaterThan==lessThan;
    }
    public static String[] usedWordArray = {"how", "now", "brown", "cow"};
    public static int countNotInWordBank(String[] wordArray)	{
        int count = 0;
        for(String word: wordArray){
            for(String usedWord: usedWordArray){
                if(word.equals(usedWord)){
                    count--;
                }
            }
            count++;
        }
        return count;
    }

    public static String[] notInVocab(String[] wordArray)	{
        String[] notFounds = new String[countNotInWordBank(wordArray)];
        int index = 0; boolean found = false;
        for(String word: wordArray){
            found = false;
            for(String usedWord: usedWordArray){
                if(word.equals(usedWord)){
                    found = true;
                }
            }
            if (!found){notFounds[index]=word;index++;}
        }
        return notFounds;
    }


    public static void main(String[] args){
        /*System.out.println(Arrays.toString(fibonacci(1)));
        int[] nums = {1,2,3,4,5};
        double[] dubs = {1,2,3,4,5};
        System.out.println(sumArray(nums));
        System.out.println(isMedian(dubs, 3));
        String word = "problem";
        System.out.println(word.substring(0,3) + " + " + word.substring(3));*/
        String[] words = {"hello", "cow", "people", "look", "brown", "brown"};
        System.out.println(countNotInWordBank(words));
        System.out.println(Arrays.toString(notInVocab(words)));
        int n = 5;
        int[][] m = new int[n][n];
        for(int j = 0; j < n; j++)	{
            for(int k = j; k < n; k++)	{
                m[j][k] = k + 1;
                m[k][j] = k - 1;
            }
        }
        for (int[] i : m){
            System.out.println(Arrays.toString(i));
        }
    }

}
