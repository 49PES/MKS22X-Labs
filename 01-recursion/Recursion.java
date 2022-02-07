public class Recursion{
  public static String reverse(String s){
    if(s.length() == 1){return s;}
    return s.substring(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
  }

  public static double sqrt(double n){
    return sqrt(n, (double) n / 2);
  }

  public static double sqrt(double n, double guess){
    if( ( n / guess + guess) / 2 < 0.00001) return guess;
    return sqrt(n, ( n / guess + guess) / 2);
  }
  public static void main(String[] args){
    System.out.println( reverse("Foo") );
    System.out.println(  );
  }
}
