package SortingStuff;

import java.util.Arrays;

public class Worker extends Thread{
    private int[] personal;
    Worker(int[] input){
        this.personal = input;
    }
    public void mergeSort(int[] nums){
        if(nums.length <2){ return; }
        else{
            int mid = nums.length/2;
            int[] p1 = Arrays.copyOfRange(nums, 0, mid); // use copy of range
            int[] p2 = Arrays.copyOfRange(nums, mid, nums.length);
            mergeSort(p1);
            mergeSort(p2);
            merge(nums,p1,p2) ;
            //System.out.println(Arrays.toString(nums));
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
    public void run(){
        mergeSort(personal);
    }
    public int[] getPersonal(){return this.personal;}
}
