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
/*
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

  public static void makeWords(int remainingLetters, String result){
    if(remainingLetters == 0){System.out.println(result); return;}
    for(char letter = 'a' ; letter <= 'c'; letter++){
        makeWords(remainingLetters - 1, result + letter);
    }
  }
*/

public static int fibIter(int n, int f1, int f2){
  if (n == 1)
     return f1;
  if (n == 0)
      return f2;
  return fibIter(n - 1, f1 + f2, f1);
}

public static long countNoDoubleLetterWords(int length,String word){
  if(length == 0){return 0L;}
  long sum = 0;
  for(char letter = 'a' ; letter <= 'z'; letter++){
    if(word.length() == 0 || word.charAt(word.length() - 1) != letter){
      // System.out.println(word + letter);
      sum += countNoDoubleLetterWords(length - 1, word + letter) + 1;
    }
  }
  return sum;
}
  public static void main(String[] args){
  //  int[] list = {8, 2, 3, 1, 7};
    System.out.println( reverse("Foo") );
    System.out.println( sqrt(100) );
  //  System.out.println( fact(5) );
  //  System.out.println( isEven(5) + ", " + isEven(6) );
  //    System.out.println( partialSum(list, 0, 6) );
  //    makeWords(3, "");
  for(int i = 0; i < 10; i++){
    System.out.println(fibIter(i, 1, 0));
  }
  System.out.println(countNoDoubleLetterWords(1, "")); // Should print out 26

  System.out.println(countNoDoubleLetterWords(2, "")); // Should print out 26^2 - 26 = 650
  // Above actually just prints 676 (26^2) ?

  System.out.println(countNoDoubleLetterWords(3, "")); // Should print out 26^3 - (2 * 26 * 25) - (26) = 16224 ?
  // Above actually prints out 16926  (26^3 - 26^2 + 26) ?
  }
}
