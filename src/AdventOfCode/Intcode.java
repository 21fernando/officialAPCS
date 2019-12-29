package AdventOfCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Intcode {

    //public static Integer[] temp = new Integer[]{3, 225, 1, 225, 6, 6, 1100, 1, 238, 225, 104, 0, 2, 106, 196, 224, 101, -1157, 224, 224, 4, 224, 102, 8, 223, 223, 1001, 224, 7, 224, 1, 224, 223, 223, 1002, 144, 30, 224, 1001, 224, -1710, 224, 4, 224, 1002, 223, 8, 223, 101, 1, 224, 224, 1, 224, 223, 223, 101, 82, 109, 224, 1001, 224, -111, 224, 4, 224, 102, 8, 223, 223, 1001, 224, 4, 224, 1, 223, 224, 223, 1102, 10, 50, 225, 1102, 48, 24, 224, 1001, 224, -1152, 224, 4, 224, 1002, 223, 8, 223, 101, 5, 224, 224, 1, 223, 224, 223, 1102, 44, 89, 225, 1101, 29, 74, 225, 1101, 13, 59, 225, 1101, 49, 60, 225, 1101, 89, 71, 224, 1001, 224, -160, 224, 4, 224, 1002, 223, 8, 223, 1001, 224, 6, 224, 1, 223, 224, 223, 1101, 27, 57, 225, 102, 23, 114, 224, 1001, 224, -1357, 224, 4, 224, 102, 8, 223, 223, 101, 5, 224, 224, 1, 224, 223, 223, 1001, 192, 49, 224, 1001, 224, -121, 224, 4, 224, 1002, 223, 8, 223, 101, 3, 224, 224, 1, 223, 224, 223, 1102, 81, 72, 225, 1102, 12, 13, 225, 1, 80, 118, 224, 1001, 224, -110, 224, 4, 224, 102, 8, 223, 223, 101, 2, 224, 224, 1, 224, 223, 223, 4, 223, 99, 0, 0, 0, 677, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1105, 0, 99999, 1105, 227, 247, 1105, 1, 99999, 1005, 227, 99999, 1005, 0, 256, 1105, 1, 99999, 1106, 227, 99999, 1106, 0, 265, 1105, 1, 99999, 1006, 0, 99999, 1006, 227, 274, 1105, 1, 99999, 1105, 1, 280, 1105, 1, 99999, 1, 225, 225, 225, 1101, 294, 0, 0, 105, 1, 0, 1105, 1, 99999, 1106, 0, 300, 1105, 1, 99999, 1, 225, 225, 225, 1101, 314, 0, 0, 106, 0, 0, 1105, 1, 99999, 7, 677, 226, 224, 102, 2, 223, 223, 1005, 224, 329, 101, 1, 223, 223, 108, 226, 226, 224, 102, 2, 223, 223, 1006, 224, 344, 101, 1, 223, 223, 1108, 226, 677, 224, 102, 2, 223, 223, 1006, 224, 359, 1001, 223, 1, 223, 107, 677, 677, 224, 1002, 223, 2, 223, 1005, 224, 374, 1001, 223, 1, 223, 1107, 226, 677, 224, 102, 2, 223, 223, 1005, 224, 389, 1001, 223, 1, 223, 107, 677, 226, 224, 1002, 223, 2, 223, 1005, 224, 404, 101, 1, 223, 223, 8, 226, 677, 224, 102, 2, 223, 223, 1005, 224, 419, 101, 1, 223, 223, 7, 226, 677, 224, 1002, 223, 2, 223, 1005, 224, 434, 101, 1, 223, 223, 1007, 677, 677, 224, 102, 2, 223, 223, 1006, 224, 449, 1001, 223, 1, 223, 107, 226, 226, 224, 1002, 223, 2, 223, 1006, 224, 464, 1001, 223, 1, 223, 1007, 226, 226, 224, 102, 2, 223, 223, 1006, 224, 479, 1001, 223, 1, 223, 1008, 226, 226, 224, 102, 2, 223, 223, 1006, 224, 494, 101, 1, 223, 223, 7, 677, 677, 224, 102, 2, 223, 223, 1005, 224, 509, 1001, 223, 1, 223, 108, 677, 226, 224, 102, 2, 223, 223, 1005, 224, 524, 101, 1, 223, 223, 1108, 677, 226, 224, 1002, 223, 2, 223, 1006, 224, 539, 101, 1, 223, 223, 1108, 677, 677, 224, 102, 2, 223, 223, 1005, 224, 554, 101, 1, 223, 223, 8, 677, 226, 224, 102, 2, 223, 223, 1005, 224, 569, 101, 1, 223, 223, 8, 677, 677, 224, 102, 2, 223, 223, 1005, 224, 584, 101, 1, 223, 223, 1107, 226, 226, 224, 102, 2, 223, 223, 1006, 224, 599, 101, 1, 223, 223, 108, 677, 677, 224, 102, 2, 223, 223, 1006, 224, 614, 101, 1, 223, 223, 1008, 677, 226, 224, 1002, 223, 2, 223, 1005, 224, 629, 1001, 223, 1, 223, 1107, 677, 226, 224, 102, 2, 223, 223, 1005, 224, 644, 101, 1, 223, 223, 1008, 677, 677, 224, 1002, 223, 2, 223, 1005, 224, 659, 101, 1, 223, 223, 1007, 677, 226, 224, 1002, 223, 2, 223, 1005, 224, 674, 1001, 223, 1, 223, 4, 223, 99, 226};
    //public static Integer[] temp = new Integer[]{1, 12, 0, 3, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 6, 1, 19, 1, 19, 5, 23, 2, 10, 23, 27, 2, 27, 13, 31, 1, 10, 31, 35, 1, 35, 9, 39, 2, 39, 13, 43, 1, 43, 5, 47, 1, 47, 6, 51, 2, 6, 51, 55, 1, 5, 55, 59, 2, 9, 59, 63, 2, 6, 63, 67, 1, 13, 67, 71, 1, 9, 71, 75, 2, 13, 75, 79, 1, 79, 10, 83, 2, 83, 9, 87, 1, 5, 87, 91, 2, 91, 6, 95, 2, 13, 95, 99, 1, 99, 5, 103, 1, 103, 2, 107, 1, 107, 10, 0, 99, 2, 0, 14, 0};
    //public static Integer[] temp = new Integer[]{3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9};
    public static Integer[] temp = new Integer[]{3,8,1001,8,10,8,105,1,0,0,21,42,55,76,89,114,195,276,357,438,99999,3,9,1001,9,3,9,1002,9,3,9,1001,9,3,9,1002,9,2,9,4,9,99,3,9,102,2,9,9,101,5,9,9,4,9,99,3,9,102,3,9,9,101,5,9,9,1002,9,2,9,101,4,9,9,4,9,99,3,9,102,5,9,9,1001,9,3,9,4,9,99,3,9,1001,9,4,9,102,5,9,9,1001,9,5,9,1002,9,2,9,101,2,9,9,4,9,99,3,9,101,1,9,9,4,9,3,9,101,1,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,101,1,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,99,3,9,1001,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,99,3,9,102,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,101,2,9,9,4,9,99,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,101,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,1,9,4,9,99,3,9,1001,9,1,9,4,9,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,101,2,9,9,4,9,99};
    //public static Integer[] temp = new Integer[]{3,31,3,32,1002,32,10,32,1001,31,-2,31,1007,31,0,33, 1002,33,7,33,1,33,31,31,1,32,31,31,4,31,99,0,0,0};
    public static ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(temp));
    public static ArrayList<Integer> result = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> phases = new ArrayList<ArrayList<Integer>>();

    public static int output = 0;
    public static int inputCount = 0;

    public static int modeGet(int index, int parameterMode){
        if(parameterMode == 0){
            return numbers.get(numbers.get(index));
        }else if(parameterMode == 1){
            return numbers.get(index);
        }
        return 0;
    }


    public static int oc (int index, int phase, int input){
        int value = numbers.get(index);
        int param1mode = ((value+ "").length()<=2) ? 0 : (value/100)%10;
        int param2mode = ((value+ "").length()<=3) ? 0 : (value/1000)%10;
        int opcode = (value%100 == 99) ? 99: value%10;
        Scanner in = new Scanner(System.in);
        if(opcode == 1){
            numbers.set(modeGet(index + 3, 1), modeGet(index + 1, param1mode) + modeGet(index + 2, param2mode));
            return 4;
        }
        else if (opcode ==2){
            numbers.set(modeGet(index + 3, 1), modeGet(index + 1, param1mode) * modeGet(index + 2, param2mode));
            return 4;
        }
        else if (opcode == 3){
            //System.out.println("Input a number for code 3");
            //int input = in.nextInt();
            if(inputCount%2 == 0){
                numbers.set(numbers.get(index+1),phase);
            }else{
                numbers.set(numbers.get(index+1),input);
            }
            inputCount++;
            return 2;
        }
        else if (opcode ==4){
            //System.out.println("OUTPUT " + modeGet(index+1, param1mode));
            output = modeGet(index+1, param1mode);
            return 2;
        }
        else if (opcode ==5){
            if(modeGet(index+1, param1mode) != 0 ){
                numbers.set(index, modeGet(index+2, param2mode));
                return modeGet(index+2, param2mode)-index;
            }
            return 3;
        }
        else if (opcode ==6){
            if(modeGet(index+1, param1mode) == 0 ){
                numbers.set(index, modeGet(index+2, param2mode));
                return modeGet(index+2, param2mode)-index;
            }
            return 3;
        }
        else if (opcode ==7){
            if(modeGet(index+1, param1mode) < modeGet(index+2, param2mode)){
                numbers.set(modeGet(index+3, 1),1);
            }else{
                numbers.set(modeGet(index+3, 1),0);
            }
            return 4;
        }
        else if (opcode ==8){
            if(modeGet(index+1, param1mode) == modeGet(index+2, param2mode)){
                numbers.set(modeGet(index+3, 1),1);
            }else{
                numbers.set(modeGet(index+3, 1),0);
            }
            return 4;
        }
        else if (opcode == 99){
            //System.out.println("STOPPPPPPP!");
            return numbers.size();
        }
        else{
            System.out.println(value + " UNKNOWN OP CODE");
            //output = -1;
            return numbers.size();
        }
    }

    public static void amplifier(int phase, int input){
        int i =0;
        while(i<numbers.size() ){
            i+=oc(i, phase, input);
        }
        //System.out.println("Phase: " + phase + " Input: " + input + " Output: " + output);
    }

    public static void main(String[] args) {
        Integer[] temp = new Integer[]{-1,-1,-1,-1,-1};
        ArrayList<ArrayList<Integer>> combos = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> nums;
        nums = new ArrayList<Integer>(Arrays.asList(temp));
        for (int first = 0; first<5; first++){
            nums.set(0, first);
            for (int second = 0; second <5 ; second++) {
                if(!nums.contains(second)){
                    nums.set(1, second);
                    for (int third = 0; third < 5; third++) {
                        if(!nums.contains(third)) {
                            nums.set(2, third);
                            for (int fourth = 0; fourth < 5; fourth++) {
                                if(!nums.contains(fourth)) {
                                    nums.set(3, fourth);
                                    for (int fifth = 0; fifth < 5; fifth++) {
                                        if(!nums.contains(fifth)){
                                            nums.set(4,fifth);
                                            phases.add(new ArrayList<Integer>(nums));
                                            output = 0;
                                            inputCount = 0;
                                        }
                                    }
                                    nums.set(4,-1);
                                }

                            }
                            nums.set(3,-1);

                        }

                    }
                    nums.set(2,-1);

                }
            }
            nums.set(1,-1);
        }

        for (ArrayList<Integer> phase : phases){
            amplifier(phase.get(0), output);
            amplifier(phase.get(1), output);
            amplifier(phase.get(2), output);
            amplifier(phase.get(3), output);
            amplifier(phase.get(4), output);
            System.out.println(output);
            output = 0;
        }
       /*
        int max = result.get(0);
        int maxIndex = 0;
        for(int i = 0; i<result.size(); i++){
            if(result.get(i)>max){
                max = result.get(i);
                maxIndex = i;
            }
        }
        System.out.println(max);
        int first = 3;
        int second = 0;
        int third = 1;
        int fourth = 2;
        int fifth = 4;
        amplifier(first, output);
        amplifier(second, output);
        amplifier(third, output);
        amplifier(fourth, output);
        amplifier(fifth, output);
        System.out.println(output);*/
    }

}



