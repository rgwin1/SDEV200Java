import java.util.Scanner;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;

public class Exercise20_11 {
    public static void main(String[] args) throws FileNotFoundException {
        //verify that args[0] is not empty
        if (args.length == 0) {
            System.out.println("No file specified.");
            return;
        } else {
            //create file to scan over
            File file = new File(args[0]);
            //invoke scanner on file
            Scanner input = new Scanner(file);
            //create Stack to track grouping symbols
            Stack<Character> groupingStack = new Stack<>();  
            boolean isValid = true;
            //while file has more lines
            while (input.hasNextLine() && isValid) {
                String line = input.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (c == '(' || c == '{' || c == '[') {
                        groupingStack.push(c);
                    } else if (c == ')' || c == '}' || c == ']') {
                        if (groupingStack.isEmpty()) {
                            isValid = false;
                            break;
                        }
                        char open = groupingStack.pop();
                        if ((c == ')' && open != '(') ||
                            (c == '}' && open != '{') ||
                            (c == ']' && open != '[')) {
                            isValid = false;
                            break;
                        }
                    }
                }
            }
            input.close();
            //final stack state determines validity
            if (isValid && groupingStack.isEmpty()) {
                System.out.println("The file has correct pairs of grouping symbols.");
            } else {
                System.out.println("The file has incorrect pairs of grouping symbols.");
            }
        }
    }
}