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

public static int fibIter(int n, int f1, int f2){
  if (n == 1)
     return f1;
  if (n == 0)
      return f2;
  return fibIter(n - 1, f1 + f2, f1);
}

public static void printAllWords(int length){
  printAllWords(length, "");
}

public static void printAllWords(int length, String word){
    if(word.length() == length){System.out.println(word); return; }
    for(char letter = 'a' ; letter <= 'e'; letter++){
      printAllWords(length, word + letter);
    }
}

public static long countNoDoubleLetterWords(int length, String word){
  if(length == 0)
    return 1L;

  long sum = 0;
  for(char letter = 'a' ; letter <= 'e'; letter++){
    if(word.length() == 0 || word.charAt(word.length() - 1) != letter) {
      sum += countNoDoubleLetterWords(length - 1, word + letter);
    }
  }
  return sum;
}


public static void printNoDoubleLetterWords(int length,char[] letters){
              printNoDoubleLetterWords(length,"",letters);
            }
public static void printNoDoubleLetterWords(int length,String word,char[]letters){
  if(length == 0){
    System.out.println(word);
    return;
  }

  for(char letter : letters){
    if(word.length() == 0 || word.charAt(word.length() - 1) != letter) {
      printNoDoubleLetterWords(length - 1, word + letter, letters);
    }
  }
  }

  public static void main(String[] args){

  System.out.println( "\"Mr. K is Kool\" reversed is \"" + reverse("Mr. K is Kool") + "\"");
  System.out.println( "Square root of 100 is approx: " + sqrt(100) );
  for(int i = 0; i < 10; i++){
     System.out.println("Fibonacci Num " + i + ":" + fibIter(i, 1, 0));
  }
  for(int i = 0; i < 4; i++){
    System.out.println("Number of " + i + "-letter words w/out repeating adjacent letters: " + countNoDoubleLetterWords(i, ""));
  }
  // printAllWords(3);
  char[] aThruE = {'a', 'b', 'c', 'd', 'e'};
  printNoDoubleLetterWords(2, aThruE);
  }

}
