import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 * Base Converter is a program that converts numbers between bases (2-16) on a text file
 * @version Monday 10/22/19
 * @author 21fernando
 */
public class BaseConverter {
    private String hexStr;

    /**
     * Constructor for this class. hexStr is a field used in converting between bases
     */
    public BaseConverter() {
        hexStr = "0123456789ABCDEF";
    }

    /**
     * converts a string to an int in base 10
     *
     * @param num      the value of a number to be converted a string
     * @param fromBase the base of a number to be converted as a string
     * @return returns the number in base 10 as an integer
     */
    public int strToInt(String num, String fromBase) {
        int newInt = 0;
        for (int i = 0; i < num.length(); i++) {
            newInt += Math.pow(Double.parseDouble(fromBase), num.length() - 1 - (i * 1.0)) * hexStr.indexOf(num.substring(i, i + 1));
        }
        return newInt;
    }

    /**
     * Convert a base-10 int to a String number of base toBase.
     *
     * @param num    number in base ten
     * @param toBase desired base for the number
     * @return the number in the new base
     */
    public String intToStr(int num, int toBase) {
        //i is the iterative variable in the wile loop. It is set to the number of digits of the given base 10 number in the new base
        int i = (int) Math.floor(Math.log(num) / Math.log(toBase)); //https://www.dotnetperls.com/double-truncate-java
        String newNum = "";
        while (i >= 0) {
            int multiple = (int) (num / Math.pow(toBase * 1.0, i * 1.0));
            num -= multiple * Math.pow(toBase * 1.0, i * 1.0);
            newNum += hexStr.charAt(multiple);
            i--;
        }
        return (newNum.equals("")) ? "0" : newNum;
    }

    /**
     * Opens the file stream, inputs data one line at a time, converts, prints the result to the console window and writes data to the output stream.
     * EXTRA: utilizes JFileChooser GUI to prompt user file selection/
     */
    public void inputConvertPrintWrite() {
        Scanner in = null;
        PrintStream ps = null;
        try {
            // uncomment this if you want to use the file chooser, make sure to set directory before running
            // learnt how to use file chooser from here: https://www.youtube.com/watch?v=9VrtranTJnc
            /**/
            JFileChooser choose = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Data file", "dat");
            choose.setFileFilter(filter);
            choose.setCurrentDirectory(new File("/Users/21fernando/Desktop/CompSci19-20/datafiles/"));
            choose.setDialogTitle("Pick a file to convert the bases!");
            if (choose.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                in = new Scanner(choose.getSelectedFile());
            }/**/
            //comment next line out if using file chooser
            //in = new Scanner(new File("datafiles/values10.dat"));
            ps = new PrintStream("datafiles/converted.dat");
            while (in.hasNext()) {
                String[] line = in.nextLine().split("\t");
                if (Integer.parseInt(line[1]) > 16 || Integer.parseInt(line[1]) < 2) {
                    System.out.println("Invalid input base " + line[1]);
                } else if (Integer.parseInt(line[2]) > 16 || Integer.parseInt(line[2]) < 2) {
                    System.out.println("Invalid output base " + line[2]);
                } else {
                    String newBase = intToStr(strToInt(line[0], line[1]), Integer.parseInt(line[2]));
                    ps.println(line[0] + "\t" + line[1] + "\t" + newBase + "\t" + line[2]);
                    System.out.println(line[0] + " base " + line[1] + " = " + newBase + " base " + line[2]);
                }
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("There was and error finding or writing the file!");
            e.printStackTrace();
        }
    }

    /**
     * Main method for base converter
     *
     * @param args command line args if necessary
     */
    public static void main(String[] args) {
        BaseConverter app = new BaseConverter();
        app.inputConvertPrintWrite();
    }
}