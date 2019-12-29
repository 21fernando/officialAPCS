import com.sun.source.tree.WhileLoopTree;

import java.util.Arrays;
import java.util.WeakHashMap;

public class GrayImage {

    public static final int BLACK = 0;
    public static final int WHITE = 255;

    private static int[][] pixelValues = new int[][]{{221,184,178,84,135},{84,255,255,130,84},{78,255,0,0,78},{84,130,255,130,84}};

    public int countWhitePixels() {
        int whiteCount = 0;
        for(int r = 0; r< pixelValues.length; r++){
            for(int c= 0; c<pixelValues[r].length; c++){
                if(pixelValues[r][c] == WHITE){
                    whiteCount++;
                }
            }
        }
        return whiteCount;
    }

    public static void processImage() {
        for (int r = 0; r < pixelValues.length; r++) {
            for (int c = 0; c < pixelValues[r].length; c++) {
                if (r + 2 < pixelValues.length && c + 2 < pixelValues[r].length) {
                    pixelValues[r][c] -= pixelValues[r + 2][c + 2];
                    if (pixelValues[r][c] < BLACK) {
                        pixelValues[r][c] = BLACK;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        processImage();
        for(int[]row:pixelValues){
            System.out.println(Arrays.toString(row));
        }
    }

}
