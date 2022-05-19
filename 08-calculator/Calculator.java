import java.util.*;
public class Calculator{
  /*Evaluate a postfix expression stored in s.
  *Assume valid postfix notation, of ints doubles and operators separated by spaces.
  *Valid operators are + - / * and % (remainder not modulo)
  *All results are doubles even if the operands are both int.
  *@throws IllegalArgumentException when there are too many or too few operands.
  *        Use the string parameter of your exception to indicate what happened.
  *        Either "too many operands" or "too few operands for operation _" replace _ with +,- etc.
  */


public static double eval(String s){
  Deque<Double> Deck = new ArrayDeque<Double>();
  String[] tokens = s.split(" ");
  for(int i = 0; i < tokens.length; i++){
      if(!("+-/*%".contains(tokens[i]))) {
        Deck.add(Double.parseDouble(tokens[i] ) );
      }
      else{
        if(Deck.size() < 2){
          throw new IllegalArgumentException("Too few operations for operation " + tokens[i]);
        }

        double operandTwo = Deck.removeLast();
        double operandOne = Deck.removeLast();

        switch(tokens[i]){
          case "+":
            Deck.addLast(operandOne + operandTwo);
            break;
          case "-":
            Deck.addLast(operandOne - operandTwo);
            break;
          case "/":
            Deck.addLast(operandOne / operandTwo);
            break;
          case "*":
            Deck.addLast(operandOne * operandTwo);
            break;
          case "%":
            Deck.addLast(operandOne % operandTwo);
            break;
        }
      }
  }
  if(Deck.size() > 1){
    throw new IllegalArgumentException("Too many operands");
  }
  return Deck.getFirst();
}


}
