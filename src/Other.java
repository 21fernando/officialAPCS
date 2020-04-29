import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Other {
    int width, length, height;
    public Other (double a, double b){
        System.out.println(a+ b);
    }

    public void quadratize (){
        int area = width*length;
        int length = (int)Math.sqrt(width*height);
        if(Math.abs( area - Math.pow(length,2)) < Math.abs(area - Math.pow(length+1, 2))){
            width = length;
            height = length;
        }else{
            width = length +1;
            height = length +1;
        }
    }

    public static int calls = 0;

    public static long mystery(int n)	{
        calls++;
        if(n <= 1)
            return 1;
        else
            return n * mystery(n-1);
    }

    public static int foo(int n)		{
        if(n == 1 || n == 2)
            return 1;
        else
            return foo(n-1) + foo(n-2);
    }

    public static int binarySearch(int[] list, int n, int low, int high)	{
        int mid = (low+high)/2;
        if(low>high){
            return -1;
        }
        if(n>list[mid]){
            return binarySearch(list, n, mid+1, high);
        }
        else if(n<list[mid]){
            return binarySearch(list, n, low, mid-1);
        }
        else{
            return n;
        }
    }


    public static ArrayList<String> merge(ArrayList<String> list1, ArrayList<String> list2)	{
        ArrayList<String> fin = new ArrayList<String>();
        int i1 = 0;
        int i2 = 0;
        while(i1<list1.size() && i2<list2.size()){
            int comp = list1.get(i1).compareTo(list2.get(i2));
            if(comp>0){
                fin.add(list2.get(i2));
                i2++;
            }
            else{
                fin.add(list1.get(i1));
                i1++;
            }
        }
        while(i1<list1.size()){
            fin.add(list1.get(i1));
            i1++;
        }
        while(i2<list2.size()){
            fin.add(list2.get(i2));
            i2++;
        }
        return fin;
    }

    public static boolean isFine(String str){
        return str.length()<2 || (str.charAt(0) <str.charAt(1) && isFine(str.substring(1)));
    }

    public static int iter = 0;
    public static int someFun(int n){
        iter ++;
        if(n<=0) {
            return 2;
        }
        else{
            return someFun(n-1)*someFun(n-1);
        }
    }

    public static String process(String s){
        int n = s.length();
        if(n<2) return s;
        else{
            return s.charAt(n-1)+process(s.substring(1,n-1))+s.charAt(0);
        }
    }

    public static void main(String[] args){
        System.out.println(mystery(7));
        System.out.println(calls);
        System.out.println(foo(8));
        System.out.println(binarySearch(new int[]{1,2,3,4,5,6,7,8,9,10}, 90, 0, 9));
        String[] names1 = {"Albert", "Brenda", "David", "Eugenia", "Fred", "Jenny", "Millicent", "Peter", "Susan", "Thomas"};
        String[] names2 = {"Andrew", "Christine", "David", "Ed", "Fred", "Jane", "Millicent", "Peter", "Regina", "Sarah", "Thomas", "Zadie"};

// copy contents of names1 and names2 into two ArrayList objects
        ArrayList<String> list1 = new ArrayList<String>(Arrays.asList(names1));
        ArrayList<String> list2 = new ArrayList<String>(Arrays.asList(names2));

        someFun(5);
        System.out.println(iter);
        System.out.println(process("hello"));
    }


}
