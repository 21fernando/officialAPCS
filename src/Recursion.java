import java.util.ArrayList;
import java.util.Collections;

public class Recursion {

    public static int multiply(int a, int b){
        if(a==0) return 0;
        if(a==1) return b;
        return multiply(a-1,b) + b;
    }

    public static int binarySearch(ArrayList<Integer> input, int target,  int low, int high){
        int mid = (high+low)/2;
        if(input.get(mid) == target) return mid;
        else if(high<low) return -1;
        else if( input.get(mid) > target){
            return binarySearch(input, target,low, mid-1 );
        }else{
            return binarySearch(input, target, mid+1, high);
        }
    }

    public static void printStars(int n){
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void printTriangle(int n ){
        if(n>1) {
            printTriangle(n - 1);
        }
        printStars(5);

    }

    public static int sumDigits(int n){
        if(n<10) return n;
        return n%10 + sumDigits(n/10);
    }

    public static boolean divThree( int n){
        if(n<10){
            return ( n==0 || n==3 || n==6 || n==9 );
        }return (divThree(sumDigits(n)));
    }

    public static void printx(int n ){
        if (n<=0){
            System.out.print(0);
        }else{
            printx(n-1);
            System.out.print(n);
            printx(n-2);
        }
    }
    public static int power3(int n){

        if(n==0)return 1;
        else{
            int p = power3(n/2);
            p*=p;
            System.out.println("A"+ n);
            if(n%2==1){
                p*=3;
                System.out.println("B"+n);
            }
            return p;
        }
    }

    public static int someFun (int n){
        if(n<=0){
            return 2;
        }else{
            return someFun(n-1)*someFun(n-1);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            nums.add((int)(Math.random()*1001));
        }
        Collections.sort(nums);
        System.out.println(nums);
        int target = (int)(Math.random()*1001);
        System.out.println(target + " at " + binarySearch(nums, target, 0, nums.size()-1));
    }
}
