package Appalachian;

public class Mergesort {

    /*public static void mergeSort(Waypoint[] wps, WaypointComparator wc){
        if(wps.length <=2){
            if(wps.length == 2 && wps[0]>wps[1]){
                int temp = wps[1];
                wps[1] = wps[0];
                wps[0] = temp;
            }
        }
        else{
            //SPLITTING HERE
            int mid = wps.length/2;
            int[] p1 = new int[mid]; // use copy of range
            int[] p2 = new int[wps.length-mid];
            for (int i = 0; i <mid ; i++) {
                p1[i] = wps[i];
            }
            for (int i = mid; i <wps.length; i++) {
                p2[i-mid] = wps[i];
            }
            //RECURSION HERE
            mergeSort(p1);
            mergeSort(p2);
            //MERGING HERE
            int index1 = 0;
            int index2 = 0;
            int masterIndex = 0;
            while(index1<p1.length && index2<p2.length){
                if(p1[index1]> p2[index2]){
                    wps[masterIndex] = p2[index2];
                    index2++;
                }else if(p1[index1] <= p2[index2]){
                    wps[masterIndex] = p1[index1];
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
    }*/
}
