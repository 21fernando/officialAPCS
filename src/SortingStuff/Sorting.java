package SortingStuff;

import Appalachian.Waypoint;

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

    public static void mergeSort(int[] nums){
        if(nums.length <2){ return; }
        else{
            int mid = nums.length/2;
            int[] p1 = Arrays.copyOfRange(nums, 0, mid); // use copy of range
            int[] p2 = Arrays.copyOfRange(nums, mid, nums.length);
            mergeSort(p1);
            mergeSort(p2);
            merge(nums, p1,p2) ;
        }
    }

    public static void merge(int[] nums, int[]p1, int[]p2){
        int index1 = 0;
        int index2 = 0;
        while(index1<p1.length && index2<p2.length){
            if(p1[index1]>p2[index2]){
                nums[index1+index2] = p2[index2];
                index2++;
            }else{
                nums[index1+index2] = p1[index1];
                index1++;
            }
        }
        while(index1<p1.length){
            nums[index1+index2] = p1[index1];
            index1++;
        }
        while(index2<p2.length){
            nums[index1+index2] = p2[index2];
            index2++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {12,3 ,-6, 200, 5, 6,8, 12, 30, 47, 96, 70,30,22, 24, 25, 26,22, 23};
        int[] small = new int[]{1,2,3,4,5,7};
        int[] large = new int[100];
        for (int i = 0; i < 100; i++) {
            large[i] = (int) (Math.random() * 10000);
        }
        System.out.println(Arrays.toString(large));
        mergeSort(large);
        System.out.println(Arrays.toString(large));
    }

}
