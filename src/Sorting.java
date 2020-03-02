import java.util.ArrayList;
import java.util.Arrays;
public class Sorting {

    public static void selectionSort(int[] nums){
        for (int out = 0; out < nums.length; out++) {
            int min = nums[out];
            int index  = out;
            for(int in = out+1; in<nums.length; in ++){
                if(nums[in]<min){
                    min = nums[in];
                    index = in;
                }
            }
            int temp  = min;
            nums[index] = nums[out];
            nums[out] = temp;
        }
    }

    public static void insertionSort(int[] nums){



    }

    public static void mergeSort(int[] nums, int low, int high){
        if(high-low <=2){
            if(nums.length == 2 && nums[0]>nums[1]){
                int temp = nums[1];
                nums[1] = nums[0];
                nums[0] = temp;
            }
        }
        else{
            //SPLITTING HERE
            int mid = high/2;
            int[] p1 = new int[mid];
            int[] p2 = new int[high-mid];
            for (int i = 0; i <mid ; i++) {
                p1[i] = nums[i];
            }
            for (int i = mid; i <high; i++) {
                p2[i-mid] = nums[i];
            }
            //RECURSION HERE
            mergeSort(p1, 0, p1.length);
            mergeSort(p2, 0, p2.length);
            //MERGING HERE
            int index1 = 0;
            int index2 = 0;
            int masterIndex = 0;
            while(index1<p1.length && index2<p2.length){
                if(p1[index1]> p2[index2]){
                    nums[masterIndex] = p2[index2];
                    index2++;
                }else if(p1[index1] <= p2[index2]){
                    nums[masterIndex] = p1[index1];
                    index1++;
                }masterIndex++;

            }
            while(index1<p1.length){
                nums[masterIndex] = p1[index1];
                index1++; masterIndex++;
            }
            while(index2<p2.length){
                nums[masterIndex] = p2[index2];
                index2++; masterIndex++;
            }
        }
    }



    public static void main(String[] args) {
        int[] nums = {12,3 ,-6, 200, 5, 6,8, 12, 30, 47, 96, 70,30,22, 24, 25, 26,22, 23};
        int[] small = new int[]{1,2,3,4,5,7};
        int[] large = new int[100];
        for (int i = 0; i < 100; i++) {
            large[i] = (int)(Math.random()*10000);
        }
        //int[]nums = {1,2,3,4,6,5};
        System.out.println(Arrays.toString(large));
        mergeSort(large,0,large.length);
        System.out.println(Arrays.toString(large));
    }

}
