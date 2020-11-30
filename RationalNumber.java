public class RationalNumber extends RealNumber {
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super(0.0);//this value is ignored!
    numerator = nume;
    denominator = deno;

    reduce();
  }

  public double getValue(){
    return Double.valueOf(numerator)/Double.valueOf(denominator);
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    return new RationalNumber(denominator, numerator);
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    return (numerator == other.getNumerator() && denominator == other.getDenominator());
  }

  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    if (numerator == 0){
      return "0";
    }else if (denominator == 1){
      return Integer.toString(numerator);
    }
    return Integer.toString(numerator) + "/" + Integer.toString(denominator);
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    /*use euclids method or a better one*/

    if (a == 0) {
      return b;
    }
    if (b == 0) {
      return a;
    }
    if (a == b) {
      return a;
    }
    if (a > b) {
      return gcd(a-b, b);
    }else {
      return gcd(a, b-a);
    }
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    numerator = numerator/gcd(numerator, denominator);
    denominator = denominator/gcd(numerator, denominator);
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    return new RationalNumber(numerator*other.getNumerator(), denominator*other.getDenominator());
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    return new RationalNumber(numerator*other.getDenominator(), denominator*other.getNumerator());
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    return new RationalNumber(numerator*other.getDenominator() + other.getNumerator()*denominator, denominator*other.getDenominator());
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    return new RationalNumber(numerator*other.getDenominator() - other.getNumerator()*denominator, denominator*other.getDenominator());
  }
}
