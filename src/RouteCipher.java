import java.util.Arrays;

public class RouteCipher {

    private static String[][] letterBlock;
    private static int numRows = 2;
    private static int numCols = 3;

    private static void fillBlock(String str){
        letterBlock = new String[numRows][numCols];
        int index = 0;
        for (int r = 0; r< numRows; r++){
            for (int c=0; c<numCols; c++){
                if (index < str.length()) {
                    letterBlock[r][c] = str.substring((r * numCols) + c, (r * numCols) + c + 1);
                }else{
                    letterBlock[r][c] = "A";
                }
                index++;
            }
        }
    }

    private static String encryptBlock(){
        String str = "";
        for(int c = 0; c<numCols; c++){
            for (int r = 0; r<numRows; r++){
                str+= letterBlock[r][c];
            }
        }
        return (str);
    }

    public static String encryptMessage(String message)    {
        String str = "";
        while(message.length() > numRows*numCols) {
            fillBlock(message);
            str += encryptBlock();
            message = message.substring(numRows*numCols);
        }
        fillBlock(message);     // fill block with what's left of message
        str += encryptBlock();  // then run column-major order to add to str
        return str;
    }
    public static void main(String[] args) {

        System.out.println(encryptMessage("Meet at midnight"));
    }

}

