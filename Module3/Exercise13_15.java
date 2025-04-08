import java.math.*;
import java.util.Scanner;

public class Exercise13_15 {
  public static void main(String[] args) {
    //prompt the user to enter two Rational numbers
    Scanner input = new Scanner(System.in);
    System.out.print("Enter rational r1 with numerator and denominator seperated by a space: ");
    String n1 = input.next();
    String d1 = input.next();

    System.out.print("Enter rational r2 with numerator and denominator seperated by a space: ");
    String n2 = input.next();
    String d2 = input.next();

    RationalUsingBigInteger r1 = new RationalUsingBigInteger(
      new BigInteger(n1), new BigInteger(d1));
    RationalUsingBigInteger r2 = new RationalUsingBigInteger(
      new BigInteger(n2), new BigInteger(d2));

    //display results
    System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
    System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
    System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
    System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
    System.out.println(r2 + " is " + r2.doubleValue());

    input.close();
  }
}
//name the revised Rational class RationalUsingBigInteger 
class RationalUsingBigInteger extends Number 
    implements Comparable<RationalUsingBigInteger> {

  //data fields for numerator and denominator
  private BigInteger numerator = BigInteger.ZERO;
  private BigInteger denominator = BigInteger.ONE;

  //construct a rational with default properties
  public RationalUsingBigInteger() {
    this(BigInteger.ZERO, BigInteger.ONE);
  }

  //construct a rational with specified numerator and denominator
  public RationalUsingBigInteger(BigInteger numerator, BigInteger denominator) {
    BigInteger gcd = numerator.gcd(denominator);
    this.numerator = denominator.signum() > 0 ? numerator.divide(gcd) : numerator.negate().divide(gcd);
    this.denominator = denominator.abs().divide(gcd);
  }

  //return numerator
  public BigInteger getNumerator() {
    return numerator;
  }

  //return denominator
  public BigInteger getDenominator() {
    return denominator;
  }

  //add a rational number to this rational
  public RationalUsingBigInteger add(RationalUsingBigInteger secondRational) {
    BigInteger n = numerator.multiply(secondRational.getDenominator())
                     .add(denominator.multiply(secondRational.getNumerator()));
    BigInteger d = denominator.multiply(secondRational.getDenominator());
    return new RationalUsingBigInteger(n, d);
  }

  //subtract a rational number from this rational
  public RationalUsingBigInteger subtract(RationalUsingBigInteger secondRational) {
    BigInteger n = numerator.multiply(secondRational.getDenominator())
                     .subtract(denominator.multiply(secondRational.getNumerator()));
    BigInteger d = denominator.multiply(secondRational.getDenominator());
    return new RationalUsingBigInteger(n, d);
  }

  //multiply a rational number to this rational
  public RationalUsingBigInteger multiply(RationalUsingBigInteger secondRational) {
    BigInteger n = numerator.multiply(secondRational.getNumerator());
    BigInteger d = denominator.multiply(secondRational.getDenominator());
    return new RationalUsingBigInteger(n, d);
  }

  //divide a rational number from this rational
  public RationalUsingBigInteger divide(RationalUsingBigInteger secondRational) {
    BigInteger n = numerator.multiply(secondRational.getDenominator());
    BigInteger d = denominator.multiply(secondRational.getNumerator());
    return new RationalUsingBigInteger(n, d);
  }

  @Override
  public String toString() {
    if (denominator.equals(BigInteger.ONE))
      return numerator.toString();
    else
      return numerator + "/" + denominator;
  }

  @Override
  public boolean equals(Object other) {
    if ((this.subtract((RationalUsingBigInteger)(other))).getNumerator().equals(BigInteger.ZERO))
      return true;
    else
      return false;
  }

  @Override
  public int intValue() {
    return (int)doubleValue();
  }

  @Override
  public float floatValue() {
    return (float)doubleValue();
  }

  @Override
  public double doubleValue() {
    return numerator.doubleValue() / denominator.doubleValue();
  }

  @Override
  public long longValue() {
    return (long)doubleValue();
  }

  @Override
  public int compareTo(RationalUsingBigInteger o) {
    if (this.subtract(o).getNumerator().compareTo(BigInteger.ZERO) > 0)
      return 1;
    else if (this.subtract(o).getNumerator().compareTo(BigInteger.ZERO) < 0)
      return -1;
    else
      return 0;
  }
}
