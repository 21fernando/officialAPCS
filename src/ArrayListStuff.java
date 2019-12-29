import java.util.ArrayList;
public class ArrayListStuff {

    public static ArrayList<String> reverseList(ArrayList<String> input){
        ArrayList<String> returnVal = new ArrayList<String>(input.size());
        for ( int i=input.size()-1; i>=0; i--){
            returnVal.add(input.get(i));
        }
        return returnVal;
    }

    public static ArrayList<Integer> removeSmallest(ArrayList<Integer> input){
        Integer smallest = input.get(0);
        int smallestIndex = 0;
        for (int i=0; i<input.size(); i++){
            if(input.get(i)< smallest){
                smallest = input.get(i);
                smallestIndex = i;
            }
        }
        input.remove(smallestIndex);
        return input;
    }

    public static ArrayList<Object> removeInBoth(ArrayList<Object> l1, ArrayList<Object> l2){
        int i=0;
        while (i< l1.size()){
            for (int j = 0; j <l2.size() ; j++) {
                if(l1.get(i) == l2.get(j)){
                    l1.remove(i);
                    i--;
                    break;
                }
            }
            i++;
        }
        return(l1);
    }

    public static void removeConsecutiveDuplicates(ArrayList<String> lst){
        for (int i=lst.size()-1; i>0; i--){
            if(lst.get(i).equals(lst.get(i-1))){
                lst.remove(i-1);
            }
        }
    }

    public static void main(String[] args){
        ArrayList<Integer> nums = new ArrayList<>(100);
        System.out.println(nums.size());
        for (int i =0; i<20; i++){
            nums.add((int)(Math.random()*(100)));
        }
        ArrayList<String> strings = new ArrayList<String>(10);
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");
        strings.add("6");
        ArrayList<String> list1= new ArrayList<String>();
        ArrayList<Object> list2= new ArrayList<Object>();
        list1.add("1");
        list1.add("1");
        list1.add("3");
        list1.add("4");
        list1.add("4");
        list1.add("10");
        list1.add("11");
        list1.add("5");
        list1.add("6");

        list2.add("10");
        list2.add("20");
        list2.add("30");
        list2.add("4");
        list2.add("50");
        list2.add("60");
        System.out.println(nums.toString());
        System.out.println(removeSmallest(nums));
        System.out.println(reverseList(strings));
        //System.out.println(removeInBoth(list1, list2));
        removeConsecutiveDuplicates(list1);
        System.out.println(list1);


    }


}
