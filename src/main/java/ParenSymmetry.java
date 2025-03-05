import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;

public class ParenSymmetry {

    public Boolean isBalanced(String s) {
        int amount = 0;
        int idx = 0;
        while (idx < s.length()) {
            char c = s.charAt(idx);
            if (c == '(') {
                amount++;
            }
            if (c == ')') {
                amount--;
            }
            if (idx < 0) {
                return false;
            }
            idx++;
            }
        return amount == 0;
    }

    private void checkFile(String filename) {
        // open file named filename
       try {
           File testString = new File("/Users/isiah/Projects/ParenSymmetry/TestStrings0.txt");
           Scanner reader = new Scanner(testString);
           while (reader.hasNextLine()) {
               String data = reader.nextLine();
               System.out.println(isBalanced(data));
           }
           reader.close();
       }catch (FileNotFoundException e) {
           System.out.println("An error occurred. ");
           e.printStackTrace();
       }


        // for each line in the file
            // read the line
            // print whether or not the line's parenthesis are balanced

        // CLOSE the file
    }

    public static void main(String[] args) {
        ParenSymmetry ps = new ParenSymmetry();
        ps.checkFile("TestStrings0.txt");
        Boolean b0 = ps.isBalanced("()");
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);

    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}
