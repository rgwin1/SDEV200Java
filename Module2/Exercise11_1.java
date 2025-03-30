import java.util.Scanner;

class Exercise11_1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //intialize input variables
        Double side1 = 0.0;
        Double side2 = 0.0;
        Double side3 = 0.0;

        //declare boolean values for input validation
        Boolean side1valid = false;
        Boolean side2valid = false;
        Boolean side3valid = false;

        //side1 input validation check
        while (!side1valid) {
            System.out.print("Please enter the length for side 1 of the triangle: ");
            String side1input = input.nextLine();

            try {
                side1 = Double.parseDouble(side1input);
                side1valid = true;
            } catch (NumberFormatException e) {
                System.out.println("You did not enter a valid number for side 1, please enter a number: ");
            }
        }
        //side2 input validation check
        while (!side2valid) {
            System.out.print("Please enter the length for side 2 of the triangle: ");
            String side2input = input.nextLine();

            try {
                side2 = Double.parseDouble(side2input);
                side2valid = true;
            } catch (NumberFormatException e) {
                System.out.println("You did not enter a valid number for side 2, please enter a valid number: ");
            }
        }
        //side3 input validation check
        while (!side3valid) {
            System.out.print("Please enter the length for side 3 of the triangle: ");
            String side3input = input.nextLine();

            try {
                side3 = Double.parseDouble(side3input);
                side3valid = true;
            } catch (NumberFormatException e) {
                System.out.println("You did not enter a valid number for side 3, please enter a number: ");
            }
        }
        //get color input
        System.out.print("Please enter the color of the triangle: ");
        String colorInput = input.nextLine();
        //get fill input 
        System.out.print("Please enter 'true' for the triangle to be filled and 'false' if you want the triangle to not have fill: ");
        String booleanInput = input.nextLine();
        String[] booleanOptions = {"true", "false"};
        //check fill input for boolean value before attempted conversion
        while ((!booleanInput.equals(booleanOptions[0])) && (!booleanInput.equals(booleanOptions[1]))){
            System.out.print("You did not enter a valid input.  For fill, please enter 'true', and no fill, please enter 'false': ");
            booleanInput = input.nextLine();            
        }
        //parse string to boolean upon successful validation
        Boolean colorFill = Boolean.parseBoolean(booleanInput);
        String colorBoolean = "";

        //assign fill status depending on boolean value input
        if (colorFill == true) {
            colorBoolean = " filled.";
        } else {
            colorBoolean = " not filled.";
        }

        //instantiate triangle object with user inputs
        Triangle triangle = new Triangle(side1, side2, side3);
        triangle.setFilled(colorFill);
        triangle.setColor(colorInput);
        String color = triangle.getColor();
        //get area & perimeter of triangle
        double area = triangle.getArea();
        double perimeter = triangle.getPerimeter();
        System.out.print("Your triangle has a perimeter of " + perimeter + ", an area of " + area + ", a color of " + color + ", and is" + colorBoolean);
        input.close();
    }
}

class Triangle extends GeometricObject {
    private double side1 = 1.0, side2 = 1.0, side3 = 1.0;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    //accessors for getting each side
    public double getSide1(){
        return side1;
    }
    public double getSide2(){
        return side2;
    }
    public double getSide3(){
        return side3;
    }
    //method for calculating area
    public double getArea(){
        double s = this.getPerimeter()/2;
        return Math.sqrt(s * ((s - this.side1) * (s - this.side2) * (s - this.side3)));

    }
    //method for calculating perimeter
    public double getPerimeter(){
        return this.side1 + this.side2 + this.side3;
    }

    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }
}