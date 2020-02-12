public class Recursion {

    public static int multiply(int a, int b){
        if(a==1) return b;
        return multiply(a-1,b)+b;
    }

    public static void main(String[] args) {
        System.out.println(multiply(16,4));
    }
}
