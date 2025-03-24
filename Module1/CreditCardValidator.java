import java.util.Scanner;

public class CreditCardValidator {

    //sumOfDoubleEvenPlace
    //sums the digits obtained by doubling every second digit from right to left
    public static int sumOfDoubleEvenPlace(long number){
        String numString = String.valueOf(number);
        int sum = 0;

        //loop through every second digit from the right, starting from second-to-last
        for (int i = numString.length() - 2; i >= 0; i -= 2) {
            int digit = Character.getNumericValue(numString.charAt(i));
            int doubled = digit * 2;
            sum += getDigit(doubled);
        }
        return sum;
    }

    //getDigit
    //returns number if it's a single digit, otherwise returns the sum of its digits
    public static int getDigit(int number){
        if (number < 10){
            return number;
        } else {
            return (number/10) + (number % 10);
        }
    }

    //sumOfOddPlace
    //sums the digits in the odd places from right to left
    public static int sumOfOddPlace(long number){
        String numString = String.valueOf(number);
        int sum = 0;

        //loop through every other digit from the right, starting with the last digit
        for (int i = numString.length() - 1; i >= 0; i -= 2){
            int digit = Character.getNumericValue(numString.charAt(i));
            sum += digit;
        }
        return sum;
    }

    //getSize
    //returns the number of digits in the long value
    public static int getSize(long digit) {
        return String.valueOf(digit).length();
    }

    //getPrefix
    //returns the first k digits of the number, or the number itself if shorter
    public static long getPrefix(long number, int k){
        int lenNumber = String.valueOf(number).length();

        //check if number has fewer digits than k
        if (lenNumber <= k){
            return number;
        } else {
            String prefix = String.valueOf(number).substring(0, k);
            return Long.parseLong(prefix);
        }
    }

    //prefixMatched
    //checks if the number starts with the given prefix
    public static boolean prefixMatched(long number, int d){
        int dLength = getSize(d);
        long prefix = getPrefix(number, dLength);

        if (prefix == d) {
            return true;
        } else {
            return false;
        }
    }

    //isValid
    //checks length, prefix, and applies the luhn algorithm to determine validity
    public static boolean isValid(long number) {
        int size = getSize(number);
        if (size < 13 || size > 16) {
            return false;
        }

        if (!(prefixMatched(number, 4) ||
              prefixMatched(number, 5) ||
              prefixMatched(number, 6) ||
              prefixMatched(number, 37))) {
            return false;
        }

        int sum = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
        return sum % 10 == 0;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a credit card number: ");

        //check if input is a valid long
        if (input.hasNextLong()) {
            long number = input.nextLong();

            //check if number is positive and validate 
            if (number <= 0){
                System.out.println("The number must be greater than 0.");
            } else if (isValid(number)){
                System.out.println(number + " is valid.");
            } else {
                System.out.println(number + " is invalid.");
            }
        } else {
            System.out.println("Invalid input. Please enter a 16-digit credit card number with no spaces (0000123456789000).");
        }

        input.close(); 
    }
}
