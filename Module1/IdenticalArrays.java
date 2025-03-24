import java.util.Scanner;

public class IdenticalArrays {

    //equals method to check if two 2D arrays are identical
    public static boolean equals(int[][] array1, int[][] array2) {
        //check if row counts match
        if (array1.length != array2.length) return false;

        //loop through each row
        for (int i = 0; i < array1.length; i++) {
            //check if column counts in each row match
            if (array1[i].length != array2[i].length) return false;

            //loop through each column
            for (int j = 0; j < array1[i].length; j++) {
                //compare values at current position
                if (array1[i][j] != array2[i][j]) return false;
            }
        }

        //arrays are identical
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //create/initialize two 3x3 arrays
        int[][] array1 = new int[3][3];
        int[][] array2 = new int[3][3];

        //prompt user for first line of input
        System.out.println("Enter list 1 (9 integers):");
        String line1 = input.nextLine(); //read the entire line
        String[] splitList1 = line1.split(" "); //split into individual numbers

        //fill array1 with values from splitList1
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array1[i][j] = Integer.parseInt(splitList1[i * 3 + j]);
            }
        }

        //prompt user for second line of input
        System.out.println("Enter list 2 (9 integers):");
        String line2 = input.nextLine(); //read the entire line
        String[] splitList2 = line2.split(" "); //split into individual numbers

        //fill array2 with values from splitList2
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array2[i][j] = Integer.parseInt(splitList2[i * 3 + j]);
            }
        }

        //check if arrays are identical and print result
        if (equals(array1, array2)) {
            System.out.println("The two arrays are identical");
        } else {
            System.out.println("The two arrays are not identical");
        }

        input.close(); //close scanner
    }
}
