import java.util.Scanner;

public class Exercise12_9 {
    public static void main(String[] args){
        //create scanner input
        Scanner input = new Scanner(System.in);
        //get user input, string as binary number
        System.out.print("Enter a binary number: ");
        String binary = input.nextLine();
        //test try/catch block with newly defined BinaryFormatException 
        try {
            System.out.print(BinaryConverter.bin2Dec(binary));
        } catch (BinaryFormatException e) {
            System.out.println(e.getMessage());
        }        
        input.close();
    }
}

//define Exception that checks if a string is not a binary number
class BinaryFormatException extends Exception {
    public BinaryFormatException(String message) {
        super(message);
    }
}

//create binaryconverter method to convert number from binary to decimal
class BinaryConverter {
    public static int bin2Dec(String binary)throws BinaryFormatException {
        int numDec = 0;
        for (int i = 0; i < binary.length(); i++) {
            char num = binary.charAt(i);
            if (num != '0' && num != '1') {
                throw new BinaryFormatException("Not a binary digit");
            }
        }
        //if no exceptions occur, convert to dec and return
        numDec = Integer.parseInt(binary, 2);
        return numDec;
    }
}

            




