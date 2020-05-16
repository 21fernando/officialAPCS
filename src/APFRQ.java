import java.util.ArrayList;

public class APFRQ {
    public void drawLine(int x1, int y1, int x2, int y2){
        System.out.println(x1 + " " + y1 + " , " + x2 +  " "  + y2);
    }

    public void drawSquare(int x, int y, int len){
        if(x+len>10){
            len = 10-x;
        }
        if(y-len<0){
            len = y;
        }
        drawLine(x,y, x, y-len); // left side
        drawLine(x,y, x+len, y); // top side
        drawLine(x+len,y, x+len, y-len); // right side
        drawLine(x,y-len, x+len, y-len); // bottom side
        System.out.println("side length = " + len + ", area = " + Math.pow(len,2));
    }

    public static void longestStreak(String str){

        int longest = 1;
        char longLetter = str.charAt(0);
        int length = 0;
        char letter = str.charAt(0);
        for (int i=1; i< str.length(); i++){
            if (str.charAt(i) == letter){
                length++;
                if(length>longest){
                    longest = length;
                    longLetter = letter;
                }
            }else{
                letter = str.charAt(i);
                length = 1;
            }
        }
        System.out.println(longLetter + " " + longest);
    }

    public static void ing(){
        String[] words = new String[]{"ten", "fading", "post", "card", "thunder", "hinge", "trailing", "batting"};
        for (String word: words){
            if(word.length()>3 && word.substring(word.length()-3).equals("ing")){
                System.out.println(word);
            }
        }
    }

    public static int hailstoneLength(int n){
        int length =1;
        while (n!=1){
            if(n%2==0){
                n/=2 ;
            }else{
                n= (n*3 )+1;
            }
            length++;
        }
        return length;
    }

    public static boolean isSelfDivisor(int number){
        int temp = number;
        int divisor;
        while(temp>0){
            divisor = temp%10;
            if(divisor == 0){
                return false;
            }
            if(number%divisor != 0){
                return false;
            }
            temp/=10;
        }
        return true;
    }
    public static int getPeakIndex(int[] array){
        if(array.length <3){
            return -1;
        }
        for( int j=1; j<array.length-1; j++){
            if(array[j]>array[j-1] && array[j] > array[j+1]){
                return j;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        APFRQ app = new APFRQ();
        app.drawSquare(7,2,4);
        longestStreak("CCAAAAATTT!");
        ing();
        System.out.println(hailstoneLength(8));
        ArrayList<String> s = new ArrayList<>();
        for(String st: s){
            st.toLowerCase();
        }
        System.out.println(isSelfDivisor(28));
        System.out.println(10.0/3);
        System.out.println(getPeakIndex(new int[]{1,2,3,5,7}));
        System.out.println("".length());
    }

}
