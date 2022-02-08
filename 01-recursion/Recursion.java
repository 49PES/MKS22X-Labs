import java.util.Arrays;

public class Recursion{
  public static String reverse(String s){
    if(s.length() == 1){return s;}
    return s.substring(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
  }

  public static double sqrt(double n){
    return sqrt(n, (double) n / 2);
  }

  public static double sqrt(double n, double guess){
    if( (guess * guess / n) - 1 < 0.00001) return guess;
    return sqrt(n, (n / guess + guess) / 2);
  }

  public static int fact(int n){
    if(n == 0){return 1;}
    return (n * fact(n - 1));
  }

  public static boolean isEven(int n){
    if(n < 2){return (n == 0); }
    return isEven(n - 2);
  }

  public static boolean partialSum(int[] array, int index, int target){
    if(index == array.length - 1){
      target -= array[array.length - 1];
      return (target == 0);
    }
    System.out.println(Arrays.toString(Arrays.copyOfRange(array, index, array.length - 1)) + ", Target = " + target );
    return ( partialSum(array, index + 1, target - array[index] ) || partialSum(array, index + 1, target) );

  }

  public static void main(String[] args){
    int[] list = {8, 2, 3, 1, 7};
    System.out.println( reverse("Foo") );
    System.out.println( sqrt(100) );
    System.out.println( fact(5) );
    System.out.println( isEven(5) + ", " + isEven(6) );
    System.out.println( partialSum(list, 0, 6) );
  }
}
