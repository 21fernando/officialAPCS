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

    public static void main(String[] args){

    }

}
