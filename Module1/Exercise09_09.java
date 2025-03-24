import java.lang.Math;

public class Exercise09_09 {
    public static void main(String[] args) {
        //create triangle (default) object
        RegularPolygon triangle = new RegularPolygon();
        System.out.println("The triangle has a perimeter of " + triangle.getPerimeter());
        System.out.println("The triangle has an area of " + triangle.getArea());

        //create hexagon object
        RegularPolygon hexagon = new RegularPolygon(6, 4);
        System.out.println("The hexagon has a perimeter of " + hexagon.getPerimeter());
        System.out.println("The hexagon has an area of " + hexagon.getArea());
        
        //create decagon object
        RegularPolygon decagon = new RegularPolygon(10, 4, 5.6, 7.8);
        System.out.println("The decagon has a perimeter of " + decagon.getPerimeter());
        System.out.println("The decagon has an area of " + decagon.getArea());

    }
  }
  
  class RegularPolygon {
    //private int data field - n, defines number of sides in polygon, default of 3
    private int n = 3;

    //private double named side - stores length of side, default 1
    private double side = 1.0;

    //private double field x - defines x-coordinate of polygon's center, default - 0
    private double x = 0.0;

    //private double field y - defines y-coordinate of polygon's center, default - 0
    private double y = 0.0;

    //no arg constructor that creates a regular polygon with default values
    public RegularPolygon(){

    }

    //constructor that creates a regular polygon with specified number of sides and length of side, centered at (0, 0)
    public RegularPolygon(int n, double side){
        this.n = n;
        this.side = side;
    }

    //constructor that creates a regular polygon with specified number of sides, length of side, and x- and y-coordinates
    public RegularPolygon(int n, double side, double x, double y){
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }
    //accessor and mutator methods for all data fields
    //n accessor - gets the number of sides
    public int getN() {
        return n;
    }
    //gets the length of each side
    public double getSide(){
        return side;
    }
    //gets the x-coordinate
    public double getX() {
        return x;
    }
    //gets the y-coordinate
    public double getY() {
        return y;
    }

    //mutators
    //sets the number of sides
    public void setN(int newN){
        n = newN;
    }
    //sets the length of each side
    public void setSide(double newSide){
        side = newSide;
    }
    //sets the x-coordinate
    public void setX(double newX){
        x = newX;
    }
    //sets the y-coordinate
    public void setY(double newY){
        y = newY;
    }
    //getPerimeter() method that returns the perimeter of the polygon
    public double getPerimeter(){
        return this.n * this.side; 
    }
    //getArea() that returns the area of the polygon:   area = (n x s^2)/(4 x tan (pi/n))  n=number of sides, s = length of side...(number of sides x length of side squared)/(4 x tan (pi/number of sides))
    public double getArea(){
        //define variables for easier area formula
        double angle = Math.PI/this.n;
        double result = Math.tan(angle);
        double sideSquared = this.side * this.side;
        
        //evaluate area with formula
        double area = (this.n * (sideSquared))/(4 * result);
        return area;
    }
  }