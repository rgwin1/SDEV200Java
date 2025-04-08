//main class to test Circle comparison and equality
public class Exercise13_9 {
    public static void main(String[] args) {
      //create two circles
      Circle c1 = new Circle(5.0, "red", true);
      Circle c2 = new Circle(5.0, "blue", false);
  
      //print circle details
      c1.printCircle();
      c2.printCircle();
  
      //compare circles
      System.out.println("c1.compareTo(c2): " + c1.compareTo(c2));
  
      //check equality
      System.out.println("c1.equals(c2): " + c1.equals(c2));
    }
  }

class Circle extends GeometricObject implements Comparable<Circle> {
    private double radius;
  
    //default constructor
    public Circle() {
    }
  
    //constructor with radius
    public Circle(double radius) {
      this.radius = radius;
    }
  
    //constructor with radius, color, and filled status
    public Circle(double radius, String color, boolean filled) {
      super(color, filled);
      this.radius = radius;
    }
  
    //return radius
    public double getRadius() {
      return radius;
    }
  
    //set radius
    public void setRadius(double radius) {
      this.radius = radius;
    }
  
    //return area
    @Override
    public double getArea() {
      return radius * radius * Math.PI;
    }
  
    //return diameter
    public double getDiameter() {
      return 2 * radius;
    }
  
    //return perimeter
    @Override
    public double getPerimeter() {
      return 2 * radius * Math.PI;
    }
  
    //print circle info
    public void printCircle() {
      System.out.println("The radius is " + radius);
    }
  
    //compare circles by radius
    @Override
    public int compareTo(Circle o) {
      return Double.compare(this.radius, o.radius);
    }
  
    //check if two circles are equal by radius
    @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (!(obj instanceof Circle)) return false;
      Circle other = (Circle) obj;
      return Double.compare(this.radius, other.radius) == 0;
    }
  }
  