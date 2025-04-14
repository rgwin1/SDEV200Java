import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercise21_3 {
    public static void main(String[] args) throws FileNotFoundException {
        //prompt user for input file
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Java source file: ");
        String filename = input.nextLine();

        File file = new File(filename);
        if (file.exists()) {
            System.out.println("The number of keywords in " + filename + " is " + countKeywords(file));
        } else {
            System.out.println("File " + filename + " does not exist");
        }
    }

    public static int countKeywords(File file) throws FileNotFoundException {
        //keyword list including true, false, null
        String[] keywordString = {
            "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum", "extends", "for", "final", "finally",
            "float", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long",
            "native", "new", "package", "private", "protected", "public", "return", "short", "static",
            "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try",
            "void", "volatile", "while", "true", "false", "null"
        };
        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
        int count = 0;
        Scanner input = new Scanner(file);
        boolean inBlockComment = false;
        //scan file line by line
        while (input.hasNextLine()) {
            String line = input.nextLine();
            //remove line comments
            int lineCommentIndex = line.indexOf("//");
            if (lineCommentIndex != -1) {
                line = line.substring(0, lineCommentIndex);
            }
            //remove block comments
            while (true) {
                if (inBlockComment) {
                    int endIndex = line.indexOf("*/");
                    if (endIndex != -1) {
                        line = line.substring(endIndex + 2);
                        inBlockComment = false;
                    } else {
                        line = "";
                        break;
                    }
                } else {
                    int startIndex = line.indexOf("/*");
                    if (startIndex != -1) {
                        int endIndex = line.indexOf("*/", startIndex + 2);
                        if (endIndex != -1) {
                            line = line.substring(0, startIndex) + line.substring(endIndex + 2);
                        } else {
                            line = line.substring(0, startIndex);
                            inBlockComment = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            //remove string literals
            line = line.replaceAll("\"(\\\\.|[^\"\\\\])*\"", "");
            //split line into tokens and check each token
            String[] words = line.split("\\s+|(?=\\W)|(?<=\\W)");
            for (String word : words) {
                if (keywordSet.contains(word)) {
                    count++;
                }
            }
        }
        input.close();
        return count;
    }
}