public class Driver{

    public static void main(String[] args){

    System.out.println( Calculator.eval("11 3 - 4 + 2.5 *")); ; // is 30.0
    System.out.println( Calculator.eval("10 2.0 +")); //is 12.0
    System.out.println( Calculator.eval("8 2 + 99 9 - * 2 + 9 -")); // is 893.0
    System.out.println( Calculator.eval("1 2 3 4 5 + * - -")); // is 26.0
    System.out.println( Calculator.eval("25")); // is 25.0
    // System.out.println( Calculator.eval("")); // throws an IllegalArgumentException "too few operands"
    // System.out.println( Calculator.eval("1 1 1 +")); // throws an IllegalArgumentException "too many operands"
    System.out.println( Calculator.eval("1 1 1 - * +")); // throws an IllegalArgumentException "too few operands" or "too few operands for operation +"


    }
}
