import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileProcessor {

    /**
     * Processes arithmetic expressions line-by-line in the given file.
     *
     * @param filePath Path to a file containing arithmetic expressions.
     */

    public static List<linkedList> createLinkedLists(String operator, String line, linkedList num1List, linkedList num2List){
        String[] split = line.split(operator);
        String num1 = split[0];
        String num2 = split[1];
        if (operator == "\\+")
            operator = "+";
        else if (operator == "\\*")
            operator = "*";
        else
            operator = "^";
        System.out.print(num1 + " " + operator + " " + num2 + " = " );
        int num1len = num1.length();
        int num2len = num2.length();
        for (int i = num1len -1; i >= 0; i--){  // add number to linked list in reverse
            num1List.add(num1.charAt(i) - '0');}
        for (int i = num2len -1; i >= 0; i--)  {// add second num to linked list in reverse
            num2List.add(num2.charAt(i) - '0');}
        List<linkedList> listNums = new ArrayList<>();
        listNums.add(0, num1List);
        listNums.add(1, num2List);

        return listNums;

    }

    public static void processFile(String filePath) {
        File infile = new File(filePath);
        try (Scanner scan = new Scanner(infile)) {
            while (scan.hasNext()) {
                // TODO: Process each line of the input file here.
                String line = scan.nextLine(); // scan one line at a time

                line = line.replace(" ", "");
                linkedList num1List = new linkedList();
                linkedList num2List = new linkedList();
                if (line.contains("+")) {  // is addition
                    List<linkedList> listNums = createLinkedLists("\\+", line, num1List, num2List);
                    linkedList res = Calculator.add(listNums.get(0), listNums.get(1));  // do addition calculation
                    res.reverse();
                    res.printList();
                    }
                else if (line.contains("*")) {  // is mult
                    List<linkedList> listNums = createLinkedLists("\\*", line, num1List, num2List);
                    linkedList res = Calculator.multi(listNums.get(0), listNums.get(1));  // do mult
                    res.reverse();
                    res.printList();
                    // do multiplication calc
                    }
                else if (line.contains("^")) {  // is exponent
                    List<linkedList> listNums = createLinkedLists("\\^", line, num1List, num2List);
                    num2List.reverse();
                    int num2 = Integer.parseInt(num2List.toString());
                    linkedList res = Calculator.exp(listNums.get(0), num2); // res = call exponent fcn in Calculator.java
                    res.reverse();
                    res.printList();
                }
            }


        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }
}

